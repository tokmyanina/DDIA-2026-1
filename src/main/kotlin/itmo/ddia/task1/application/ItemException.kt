package itmo.ddia.task1.application

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class ItemException(
    status: HttpStatus,
    reason: String,
) : ResponseStatusException(status, reason)
