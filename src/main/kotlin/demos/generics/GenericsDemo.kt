package demos.generics

import demos.Demo
import jdk.jshell.spi.ExecutionControl

class GenericsDemo : Demo {
    override val name: String = "Generics Demo"

    override fun execute() {
        val invariantObj1 = GenericClass<String>()
        /**
         * invariantFunc(invariantObj1)
         * will not build because GenericClass<String> is not a subtype if GenericClass<Any>
         */

        // Now we can use invariantObj1 as argument as covariantFunc param is covariant
        covariantFunc(invariantObj1)
    }

    private fun covariantFunc(value: GenericClass<out Any>) {
        //TODO
    }

    private fun invariantFunc(value: GenericClass<Any>) {
        //TODO
    }
}

private class GenericClass<T> {

    fun returnFunc(): T { throw ExecutionControl.NotImplementedException("") }
    fun inputFunc(v: T) { }
}

private class CovariantGenericClass<out T> {

    fun returnFunc(): T { throw ExecutionControl.NotImplementedException("") }

    /**
     * fun inputFunc(v: T) { }
     * Will not build as T cannot be used as a param of covariant class
     */
}

private class ContravariantGenericClass<in T> {
    fun inputFunc(v: T) { }

    /**
     * fun returnFunc(): T { }
     * Will not build as T cannot be used as return type of contravariant class
     */

}