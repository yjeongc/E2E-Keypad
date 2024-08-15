package bob.simple.spring.util

import java.security.MessageDigest
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

object EncryptionUtils {

    private const val SECRET_KEY = "your-secret-key"

    fun generateHmac(data: String): String {
        val mac = Mac.getInstance("HmacSHA256")
        val secretKeySpec = SecretKeySpec(SECRET_KEY.toByteArray(), "HmacSHA256")
        mac.init(secretKeySpec)
        return mac.doFinal(data.toByteArray()).joinToString("") { "%02x".format(it) }
    }

    fun generateKeypadId(): String {
        return java.util.UUID.randomUUID().toString()
    }

    fun getTimestamp(): String {
        return System.currentTimeMillis().toString()
    }
}
