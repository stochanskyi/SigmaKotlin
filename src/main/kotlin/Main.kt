import demos.Demo
import demos.annotations.AnnotationsDemo
import demos.delegates.ClassDelegatesDemo
import demos.delegates.PropertyDelegatesDemo

object Main {

    private val demos: List<Demo> by lazy {
        listOf(
            AnnotationsDemo(),
            ClassDelegatesDemo(),
            PropertyDelegatesDemo()
        )
    }

    @JvmStatic
    fun main(args: Array<String>) {
        demos.forEach {
            it()
        }
    }
}