package bob.simple.spring.controller

import bob.simple.spring.dto.KeypadResponseDto
import bob.simple.spring.service.KeypadService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/keypad")
class KeypadController(private val keypadService: KeypadService) {

    @GetMapping
    fun getKeypadData(): KeypadResponseDto {
        return keypadService.generateKeypadData()
    }
}
