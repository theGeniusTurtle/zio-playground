package part1ZioEnvEp3.businesslogic

import part1ZioEnvEp3.domain.User
import zio.{Clock, Console, Task, ZIO}

object UserNotifier {
  def notify(user: User, msg: String): ZIO[Clock, Throwable, Unit] = {
    Clock.currentDateTime.flatMap {
      dateTime =>
        Task {
          println(s"Sending $msg to ${user.email} @ $dateTime")
        }
    }
  }
}
