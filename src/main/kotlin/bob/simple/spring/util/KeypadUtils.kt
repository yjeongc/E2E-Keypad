package bob.simple.spring.util

import bob.simple.spring.dto.KeypadDigitDto
import org.springframework.core.io.ClassPathResource
import java.util.*

object KeypadUtils {

    fun generateKeypadLayout(): List<KeypadDigitDto> {
        val digits = (0..9).toList()
        val shuffledDigits = digits.shuffled()
        return shuffledDigits.map { digit ->
            val image = ClassPathResource("keypad/_$digit.png").file.readBytes().toBase64()
            KeypadDigitDto(digit, image)
        }
    }

    private fun ByteArray.toBase64(): String {
        return Base64.getEncoder().encodeToString(this)
    }
}
