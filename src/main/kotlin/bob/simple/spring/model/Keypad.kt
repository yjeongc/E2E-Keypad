package bob.simple.spring.model

data class Keypad(
    val keypadId: String,
    val timestamp: String,
    val hash: String,
    val layout: List<KeypadDigit>
)

data class KeypadDigit(
    val digit: Int,
    val image: String
)
