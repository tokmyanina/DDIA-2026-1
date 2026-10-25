package itmo.ddia.task1.presentation

import itmo.ddia.task1.application.ItemService
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.*

@Component
@RestController
@RequestMapping("/items")
class ItemController(
    private val itemService: ItemService
) {
    @GetMapping("/{id}")
    fun get(
        @PathVariable id: String
    ): Item {
        return itemService
            .get(id = id.toUUID())
            .toDto()
    }

    @PostMapping
    fun create(
        @RequestBody request: ItemCreateRequest
    ): Item {
        return itemService.add(request.value).toDto()
    }

    @PutMapping("/{id}")
    fun replace(
        @PathVariable id: String,
        @RequestBody request: ItemModifyRequest
    ): Item {
        return itemService.replace(
            id = id.toUUID(),
            value = request.value
        ).toDto()
    }
}