package itmo.ddia.task1.application

import itmo.ddia.task1.application.Item.Companion.newItem
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class ItemService {
    val items = mutableListOf<Item>()

    fun get(id: UUID): Item {
        return getOrNull(id = id) ?: throw ItemException(
            status = HttpStatus.NOT_FOUND,
            reason = "Не найден item с идентификатором $id",
            )
    }

    private fun getOrNull(id: UUID): Item? {
        return items.firstOrNull { it.id == id }
    }

    fun add(value: String): Item {
        val item = newItem(value = value)
        items.add(item)
        return item
    }

    fun replace(
        id: UUID,
        value: String,
    ): Item {
        val item = get(id = id)
            .updateValue(value = value)
            .also {
                items.removeIf { item -> item.id == id }
                items.add(it)
            }
        return item
    }
}