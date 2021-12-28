package features.delegates.delegation.restorablelist.actions

interface ListAction<T> {
    fun redoAction(list: MutableList<T>)
}

class DeleteElementAction<T>(
    private val index: Int,
    private val element: T
) : ListAction<T> {

    override fun redoAction(list: MutableList<T>) {
        if (index !in 0..list.size) {
            list.add(element)
        } else {
            list.add(index, element)
        }
    }

}

class AddElementAction<T>(
    private val index: Int,
) : ListAction<T> {
    override fun redoAction(list: MutableList<T>) {
        if (index !in list.indices) return

        list.removeAt(index)
    }
}