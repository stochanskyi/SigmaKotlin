import demos.Demo
import demos.annotations.AnnotationsDemo
import demos.delegates.ClassDelegatesDemo
import demos.delegates.PropertyDelegatesDemo
import demos.inline.InlinesDemo
import demos.sequences.SequencesDemo

object Main {

    private val demos: List<Demo> by lazy {
        listOf(
            AnnotationsDemo(),
            ClassDelegatesDemo(),
            PropertyDelegatesDemo(),
            InlinesDemo(),
            SequencesDemo()
        )
    }

    @JvmStatic
    fun main(args: Array<String>) {
        demos.forEach { it() }
    }
}