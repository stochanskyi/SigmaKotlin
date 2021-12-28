import demos.Demo
import demos.annotations.AnnotationsDemo

object Main {

    private val demos: List<Demo> by lazy {
        listOf(
            AnnotationsDemo()
        )
    }

    fun main(args: Array<String>) {
        demos.forEach {
            it()
        }
    }
}