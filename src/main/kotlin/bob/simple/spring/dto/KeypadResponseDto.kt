package bob.simple.spring.dto

data class KeypadResponseDto(
    val keypadId: String,
    val timestamp: String,
    val hash: String,
    val layout: List<KeypadDigitDto>
)

data class KeypadDigitDto(
    val digit: Int,
    val image: String
)
