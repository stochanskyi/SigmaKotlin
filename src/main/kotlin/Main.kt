import demos.Demo
import demos.annotations.AnnotationsDemo
import demos.delegates.ClassDelegatesDemo

object Main {

    private val demos: List<Demo> by lazy {
        listOf(
            AnnotationsDemo(),
            ClassDelegatesDemo()
        )
    }

    @JvmStatic
    fun main(args: Array<String>) {
        demos.forEach {
            it()
        }
    }
}