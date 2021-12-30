package features.builders

@DslMarker
annotation class ComputerPartMarker

@ComputerPartMarker
abstract class ComputerComponent {

    var model: String = ""

}

abstract class SimpleComputerComponent : ComputerComponent()

abstract class ComplexComputerComponent : ComputerComponent() {

    private val subcomponents: MutableList<ComputerComponent> = mutableListOf()

    fun <T : ComputerComponent> setupComponent(component: T, initialize: T.() -> Unit) {
        component.initialize()
        subcomponents.add(component)
    }

}

class Computer : ComplexComputerComponent() {

    fun powerBlock(action: PowerBlock.() -> Unit) = setupComponent(PowerBlock(), action)

    fun motherboard(init: Motherboard.() -> Unit) = setupComponent(Motherboard(), init)

}

class PowerBlock() : SimpleComputerComponent()

class Motherboard : ComplexComputerComponent() {

    fun processor(init: Processor.() -> Unit) = setupComponent(Processor(), init)

}

class Processor : SimpleComputerComponent()

fun computer(action: Computer.() -> Unit): Computer {
    val computer = Computer()
    computer.action()

    return computer
}


fun demo() {
    computer {
        powerBlock {
            model = "asfd"
        }
        motherboard {
            processor {
                model = "Intel core i5"
            }
        }
    }
}