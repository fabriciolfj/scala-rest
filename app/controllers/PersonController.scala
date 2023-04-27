package controllers

import model.Person
import play.api.libs.json.{JsValue, Json}
import play.api.mvc.{BaseController, ControllerComponents}

import javax.inject.{Inject, Singleton}

@Singleton
class PersonController @Inject()(implicit val controllerComponents: ControllerComponents) extends BaseController {

  def getPersons = Action {
    import model.WritesConverters._

    val persons : Seq[Person]= Person.find()
    val json: JsValue = Json.toJson(persons)

    Ok(json)
  }

}
