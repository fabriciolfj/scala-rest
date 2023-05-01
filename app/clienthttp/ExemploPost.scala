package clienthttp

import sttp.client3.{HttpURLConnectionBackend, UriContext, basicRequest}

object ExemploPost extends App {

  val backend = HttpURLConnectionBackend()
  val response = basicRequest
    .body("Hello, world!")
    .post(uri"https://httpbin.org/post?hello=world")
    .send(backend)
  println(response)

}
