package model

case class Person(name: String, address: Address)
case class Address(street: String, city: String, state: String, postalCode: String)

object WritesConverters {
  import play.api.libs.json._

  implicit val addressWrites = new Writes[Address] {

    override def writes(o: Address): JsValue =Json.obj(
      "street" -> o.street,
      "city" -> o.city,
      "state" -> o.city,
      "postal_code" -> o.postalCode
    )
  }

  implicit val personWrites = new Writes[Person] {
    override def writes(o: Person): JsValue = Json.obj(
      "name" -> o.name,
      "address" -> o.address
    )
  }
}

object Person {
  def find() =
    List(Person("fabricio", Address("rua teste", "Serrana", "SP", "141502233")))
}
