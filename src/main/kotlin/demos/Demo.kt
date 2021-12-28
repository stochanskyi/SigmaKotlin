package demos

interface Demo {

    val name: String

    fun execute()

    operator fun invoke() {
        println()
        println("----------------------${name}----------------------")
        println()
        execute()
    }

}