package demos.annotations

import demos.Demo
import features.annotations.serialization.JsonSerializerImpl
import features.annotations.serialization.annotations.FieldName
import features.annotations.serialization.annotations.IgnoreField

class AnnotationsDemo : Demo {

    class Test(
        @IgnoreField val abc: Int = 1,
        @FieldName("testName") val cba: Int = 2
    )

    override val name: String
        get() = "Annotations (Simple JSON serializer)"

    override fun execute() {
        val jsonSerializer = JsonSerializerImpl()

        val testObject = Test()
        println(jsonSerializer.serialize(testObject))
    }
}