package demos.sequences

import demos.Demo
import kotlin.random.Random
import kotlin.system.measureTimeMillis

class SequencesDemo : Demo {

    companion object {
        private const val a = 'a'
        private const val z = 'z'
        private const val A = 'A'
        private const val Z = 'Z'
    }

    override val name: String = "Sequence Demo"

    override fun execute() {
        val list = List(10_000_000) { createRandomChatData(it) }
        var time = measureTimeMillis {
            list
                .filter { it.senderId == "1" }
                .map { it.transform("1") }
                .filter { !it.hasUnread }
        }

        println("List operations time: $time millis")
        time = measureTimeMillis {
            list.asSequence()
                .filter { it.senderId == "1" }
                .map { it.transform("1") }
                .filter { !it.hasUnread }
                .toList()
        }
        println("Sequance operations time: $time millis")

    }

    private fun createRandomChatData(index: Int): ChatData {
        return ChatData(
            index.toString(),
            randomString(Random.nextInt(1, 100)),
            Random.nextInt(0, 20),
            Random.nextInt(1, 3).toString()
        )
    }

    private fun randomString(size: Int): String {
        return String(CharArray(size) { randomChar() })
    }

    private fun randomChar(): Char {
        val isCapital = Random.nextInt()
        if (isCapital == 1) {
            return Random.nextInt(A.code, Z.code).toChar()
        } else {
            return Random.nextInt(a.code, z.code).toChar()
        }
    }
}

private fun ChatData.transform(myId: String): ChatViewData {
    return ChatViewData(id, name, unreadMessages > 0, myId == senderId)
}

private class ChatData(
    val id: String,
    val name: String,
    val unreadMessages: Int,
    val senderId: String
)

private class ChatViewData(
    val id: String,
    val name: String,
    val hasUnread: Boolean,
    val sentByMe: Boolean
)