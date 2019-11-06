import com.google.gson.Gson

data class InnerObject(
    val birthDate: String
)

data class User(
    val name: String,
    val age: Int,
    val innerObject: InnerObject = InnerObject("Today!")
)

fun main(args: Array<String>) {
    val json = "{}"
    val json2 = """
        {
            "name": null,
            "age": 22
        }""".trimIndent()
    val gson = Gson()
    val unmarshalledObject1 = gson.fromJson(json, User::class.java)
    val unmarshalledObject2 = gson.fromJson(json2, User::class.java)

    // try some nullability check
    if (unmarshalledObject1.name == null) {
        println("Name is null, but it's a non-nullable variable")
    }

    if (unmarshalledObject2.name == null) {
        println("Here's the same, this should never be shown")
    }

    if (unmarshalledObject2.innerObject == null) {
        println("We should not print this as well, right? Because we have a default value! But you(we)'re, at least so far, wrong!")
    }

    println(unmarshalledObject1)
    println(unmarshalledObject2)
    println("Finished")
}