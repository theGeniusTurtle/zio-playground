package part0HelloWorld

import zio.{Console, ZEnv, ZIO, ZIOAppArgs, ZIOAppDefault}

import java.io.IOException

object HelloWorld extends ZIOAppDefault {
  val helloWorldApp: ZIO[Console, IOException, Unit] =
    Console.printLine("Hello, World!")


  override def run: ZIO[ZEnv with ZIOAppArgs, Any, Any] = helloWorldApp
}
