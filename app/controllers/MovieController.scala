package controllers

import model.Movie

import javax.inject._
import play.api._
import play.api.mvc._
import models._
import play.api.libs.json.{JsValue, Json}

@Singleton
class MovieController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def getMovies = Action {
    val goodMoveis: Seq[String] = Movie.goodMovies()
    val json: JsValue = Json.toJson(goodMoveis)
    Ok(json)
  }
}
