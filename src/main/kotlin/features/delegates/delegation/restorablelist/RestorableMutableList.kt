package features.delegates.delegation.restorablelist

import features.delegates.delegation.restorablelist.actions.AddElementAction
import features.delegates.delegation.restorablelist.actions.DeleteElementAction
import features.delegates.delegation.restorablelist.actions.ListAction

class RestorableMutableList<T>(
    private val list: MutableList<T>
) : MutableList<T> by list {

    private var lastAction: ListAction<T>? = null

    override fun removeAt(index: Int): T {
        val value = list[index]
        lastAction = DeleteElementAction(index, value)

        return list.removeAt(index)
    }

    override fun add(index: Int, element: T) {
        lastAction = AddElementAction(index)

        return list.add(index, element)
    }

    fun restore() {
        val action = lastAction ?: return

        action.redoAction(list)
    }

}

