package controllers

import model.Movie

import javax.inject._
import play.api.mvc._
import play.api.libs.json.{JsValue, Json}
import service.MovieService

@Singleton
class MovieController @Inject()(val controllerComponents: ControllerComponents,
                                val movieService: MovieService) extends BaseController {

  def getMovies = Action {
    val goodMoveis: Seq[String] = Movie.goodMovies()
    val json: JsValue = Json.toJson(goodMoveis)
    Ok(json)
  }

  def saveMovies = Action { request: Request[AnyContent] =>
    val json = request.body.asJson
    json match {
      case Some(value) => movieService.execute(value)
      case None => println("error")
    }

    Created
  }
}
