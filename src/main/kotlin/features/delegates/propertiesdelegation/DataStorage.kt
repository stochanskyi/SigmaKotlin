package features.delegates.propertiesdelegation

interface DataStorage {
    fun getString(key: String): String

    fun setString(key: String, value: String)
}

class MockedDataStorage : DataStorage {

    private val data: MutableMap<String, String> = mutableMapOf()

    override fun getString(key: String): String {
        return data[key]!!
    }

    override fun setString(key: String, value: String) {
        data[key] = value
    }

}