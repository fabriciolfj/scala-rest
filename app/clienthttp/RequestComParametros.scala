package clienthttp

import sttp.client3.{HttpURLConnectionBackend, UriContext, basicRequest}

object RequestComParametros extends App {

  val query = "http language:scala"
  val request = basicRequest.get(
    uri"https://api.github.com/search/repositories?q=$query"
  )

  val backend = HttpURLConnectionBackend()
  val response = request.send(backend)
  println(s"URL: ${request.toCurl}") // prints the URL that’s created
  println(response.body)

}
