package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import models._

@Singleton
class HelloController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def sayHello() = Action {
    Ok("hello, world")
  }

  def sayHi(name: String) = Action {
    Ok(s"hi $name")
  }

}
