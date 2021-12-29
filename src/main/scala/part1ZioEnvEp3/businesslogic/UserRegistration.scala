package part1ZioEnvEp3.businesslogic

import part1ZioEnvEp3.domain.User
import part1ZioEnvEp3.services.DB
import zio.{Clock, ZIO}

object UserRegistration {
  def register(user: User): ZIO[Clock with DB, Throwable, User] = {
    for {
      _ <- UserModel.insert(user)
      _ <- UserNotifier.notify(user, "Hello my friend!")
    } yield user
  }

}
