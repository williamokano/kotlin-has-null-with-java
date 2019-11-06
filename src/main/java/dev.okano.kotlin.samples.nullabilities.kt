import com.google.gson.Gson

data class User(
    val name: String,
    val age: Int
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

    println("Finished")
}