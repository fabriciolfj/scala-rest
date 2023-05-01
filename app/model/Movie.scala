package model

import play.api.libs.json._
import play.api.libs.functional.syntax._
import play.api.libs.json.Reads._


case class Movie(title: String, year: Int, rating: Double)

object Movie {

  implicit val movieReads: Reads[Movie] = (
    (JsPath \ "title").read[String](minLength[String](2)) and
      (JsPath \ "year").read[Int](Reads.min(1920).keepAnd(Reads.max(2020))) and
      (JsPath \ "rating").read[Double](Reads.min(0d).keepAnd(Reads.max(10d)))
    )(Movie.apply _)

  def goodMovies(): Seq[String] = List(
    "the princess bride",
    "the matrix",
    "firefly"
  )

}
