package demos.inline

import demos.Demo
import kotlin.random.Random
import kotlin.system.measureTimeMillis

class InlinesDemo : Demo {
    override val name: String = "Inlines demo"

    override fun execute() {
        val list = List(10_000_000) { Random.nextInt() }

        var time = measureTimeMillis {
            list.map {
                it.transform { toString() }
            }
        }
        println("Modifying list with not inline function in $time millis")

        time = measureTimeMillis {
            list.map {
                it.transformInline { toString() }
            }
        }
        println("Modifying list with inline function in $time millis")
    }

    private fun <T, D> T.transform(transformation: T.() -> D): D {
        return transformation()
    }

    private inline fun <T, D> T.transformInline(crossinline transformation: T.() -> D): D {
        return transformation()
    }
}