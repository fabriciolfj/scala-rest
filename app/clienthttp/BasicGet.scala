package clienthttp

import sttp.client3.{HttpURLConnectionBackend, UriContext, basicRequest}

import scala.concurrent.duration.DurationInt

object BasicGet extends App {

  val backend = HttpURLConnectionBackend()
  val response = basicRequest
    .header("Accpet", "application/json")
    .get(uri"http://httpbin.org/get")
    .readTimeout(5.seconds)
    .send(backend)

  response.body match {
    case Right(result) => println("ok")
    case Left(error) => println("deu ruim")
  }

  println(response)
  println(response.code)
  println(response.is200)
  println(response.body)

}