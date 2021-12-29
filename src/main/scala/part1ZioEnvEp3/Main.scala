package part1ZioEnvEp3

import part1ZioEnvEp3.businesslogic.UserRegistration
import part1ZioEnvEp3.domain.User
import part1ZioEnvEp3.resources.{ConnectionPoolIntegration, DBConfig}
import part1ZioEnvEp3.services.DB
import zio.{Clock, Tag, ZIO, ZIOApp, ZIOAppArgs, ZLayer}

object Main extends ZIOApp {
  override type Environment = DB
  override implicit def tag: zio.Tag[Environment] = Tag[Environment]

  override def layer: ZLayer[ZIOAppArgs, Any, Environment] = ZLayer.make[DB](
    ConnectionPoolIntegration.live,
    DB.live,
    ZLayer.succeed(DBConfig("jdbc://localhost"))
  )

  override def run: ZIO[DB with Clock, Any, Any] =
    UserRegistration
      .register(User("kablam", "kablam@kaboom.com"))
      .map { u => println(s"Registered user: $u")}
}
