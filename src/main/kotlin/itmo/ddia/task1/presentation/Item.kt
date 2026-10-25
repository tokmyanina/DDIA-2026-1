package itmo.ddia.task1.presentation

import itmo.ddia.task1.application.ItemException
import org.springframework.http.HttpStatus
import java.util.UUID
import itmo.ddia.task1.application.Item as DomainItem

data class Item(
    val id: UUID,
    val value: String,
)

fun DomainItem.toDto() = Item(
    id = id,
    value = value
)

fun String.toUUID(): UUID {
    val identifier = try {
        UUID.fromString(this)
    } catch (_: IllegalArgumentException) {
        throw ItemException(
            status = HttpStatus.BAD_REQUEST,
            reason = "Некорректное значение идентификатора $this"
        )
    }
    return identifier
}

