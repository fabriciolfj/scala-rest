package service

import model.Movie
import play.api.libs.json.{JsError, JsSuccess, JsValue}

import javax.inject.Singleton

@Singleton
class MovieService {

  def execute(json: JsValue): Unit = {
    val result = json.validate[Seq[Movie]]
    result match {
      case JsSuccess(value, path) => println(s" deu certo: $value, path $path")
      case e: JsError => println(e.errors)
    }
  }

  private def printAll(movies: Seq[Movie]) : Unit = {
    movies.foreach(println(_))
  }
}
