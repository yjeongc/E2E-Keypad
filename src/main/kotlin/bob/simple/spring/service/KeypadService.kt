package bob.simple.spring.service

import bob.simple.spring.dto.KeypadResponseDto
import bob.simple.spring.dto.KeypadDigitDto
import bob.simple.spring.util.EncryptionUtils
import bob.simple.spring.util.KeypadUtils
import org.springframework.stereotype.Service

@Service
class KeypadService {

    fun generateKeypadData(): KeypadResponseDto {
        val keypadId = EncryptionUtils.generateKeypadId()
        val timestamp = EncryptionUtils.getTimestamp()
        val layout = KeypadUtils.generateKeypadLayout()
        val hash = EncryptionUtils.generateHmac(keypadId + timestamp)  // Now using public key bytes

        val layoutDto = layout.map { KeypadDigitDto(it.digit, it.image) }
        return KeypadResponseDto(keypadId, timestamp, hash, layoutDto)
    }
}
