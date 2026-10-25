package itmo.ddia.task1.application

import java.util.*

data class Item(
    val id: UUID,
    val value: String,
) {
    fun updateValue(value: String): Item {
        return copy(
            value = value,
        )
    }

    companion object {
        fun newItem(value: String): Item {
            return Item(
                id = UUID.randomUUID(),
                value = value,
            )
        }
    }
}
