package part1ZioEnvEp3.businesslogic

import part1ZioEnvEp3.domain.User
import part1ZioEnvEp3.services.DB
import zio.ZIO

object UserModel {
  def insert(user: User): ZIO[DB, Throwable, Unit] =
    DB.execute(s"INSERT INTO user VALUES (${user.name})")
}
