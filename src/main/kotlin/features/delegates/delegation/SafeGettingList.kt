package features.delegates.delegation

class SafeGettingList<out T>(
    private val list: List<T>,
    private val defaultValue: T
) : List<T> by list {

    override fun get(index: Int): T {
        return if (index in list.indices) list[index] else defaultValue
    }

}