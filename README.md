# scala-rest
- para criar um projeto scala com framework play
```
sbt new playframework/play-scala-seed.g8

```

- para definir rotas ou endpoints rest, precisamos informar no arquivo conf/routes, por exemplo:
```
POST    /movies                     controllers.MovieController.saveMovies
```

- para deserializar um json para um objeto, precisamos de um object com método implicito correspondente.
- por exemplo:
```
object Movie {

  implicit val movieReads: Reads[Movie] = (
    (JsPath \ "title").read[String](minLength[String](2)) and
      (JsPath \ "year").read[Int](Reads.min(1920).keepAnd(Reads.max(2020))) and
      (JsPath \ "rating").read[Double](Reads.min(0d).keepAnd(Reads.max(10d)))
    )(Movie.apply _)

}
```