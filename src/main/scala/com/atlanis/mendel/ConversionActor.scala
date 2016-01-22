package com.atlanis.mendel

import akka.actor.Actor
import spray.routing._
import spray.http._
import MediaTypes._

class ConversionActor extends Actor with Conversion {
  def actorRefFactory = context
  def receive = runRoute(route)
}

trait Conversion extends HttpService {
  val route =
    path("") {
      get {
        respondWithMediaType(`text/html`) {
          complete {
            <html>
              <body>
                Hi
              </body>
            </html>
          }
        }
      }
    }
}
