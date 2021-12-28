package features.annotations.serialization

import features.annotations.serialization.annotations.FieldName
import features.annotations.serialization.annotations.IgnoreField
import kotlin.reflect.KProperty
import kotlin.reflect.KProperty1
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.hasAnnotation

interface JsonSerializer {

    fun serialize(data: Any): String

    fun <T> deserialize(data: String): T

}

class JsonSerializerImpl : JsonSerializer {

    override fun serialize(data: Any): String {
        val klass = data.javaClass.kotlin

        val builder = StringBuilder()

        val members = klass.declaredMemberProperties.filter { !it.ignoreJson }

        builder.append("{")

        builder.appendProperty(data, members.firstOrNull() ?: return "{}")

        members.asSequence().drop(1).forEach {
            builder.append(", ")
            builder.appendProperty(data, it)
        }

        builder.append("}")

        return builder.toString()
    }

    private fun StringBuilder.appendProperty(data: Any, prop: KProperty1<Any, *>) {
        val name = prop.resolveName()
        val value = prop(data)

        append("\"$name\"")
        append(": ")
        append(value)
    }

    private fun KProperty<*>.resolveName(): String {
        return findAnnotation<FieldName>()?.name ?: name
    }

    private val KProperty<*>.ignoreJson
        get() = hasAnnotation<IgnoreField>()

    override fun <T> deserialize(data: String): T {
        TODO("Not yet implemented")
    }


}