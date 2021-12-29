package demos.delegates

import demos.Demo
import features.delegates.propertiesdelegation.DataStorage
import features.delegates.propertiesdelegation.MockedDataStorage
import features.delegates.propertiesdelegation.storage

class PropertyDelegatesDemo : Demo {

    private val dataStorage: DataStorage = MockedDataStorage()

    override val name: String = "Property delegation"

    private var someData: String by storage(dataStorage, "test_prop")

    override fun execute() {
        println("Setting \"Test 1\" to delegate property")
        someData = "Test 1"

        println("Delegate property value: $someData")
        println("Storage property value: ${dataStorage.getString("test_prop")}")

        println("Setting \"Test 2\" to delegate property")
        someData = "Test 2"

        println("Delegate property value: $someData")
        println("Storage property value: ${dataStorage.getString("test_prop")}")
    }

}