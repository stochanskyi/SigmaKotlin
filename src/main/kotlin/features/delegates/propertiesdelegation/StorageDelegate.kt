package features.delegates.propertiesdelegation

import kotlin.reflect.KProperty

class StorageDelegate<T>(
    private val dataStorage: DataStorage,
    private val key: String
) {

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return dataStorage.getString(key)
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        dataStorage.setString(key, value as String)
    }

}

fun storage(dataStorage: DataStorage, key: String) = StorageDelegate<String>(dataStorage, key)