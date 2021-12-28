package demos.delegates

import demos.Demo
import features.delegates.delegation.restorablelist.RestorableMutableList

class ClassDelegatesDemo : Demo {

    override val name: String = "Class delegation"

    override fun execute() {
        val restorableList = RestorableMutableList(mutableListOf(1, 2, 3, 4, 5))

        println(restorableList.asString())

        println("Removing at index 2")
        restorableList.removeAt(2)
        println(restorableList.asString())

        println("Restoring state")
        restorableList.restore()
        println(restorableList.asString())

        println("Adding at index 0")
        restorableList.add(0, 12)
        println(restorableList.asString())

        println("Restoring state")
        restorableList.restore()
        println(restorableList.asString())
    }

    private fun <T> List<T>.asString() = joinToString(separator = ", ")

}