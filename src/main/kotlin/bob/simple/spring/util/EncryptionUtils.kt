package bob.simple.spring.util

import java.nio.file.Files
import java.nio.file.Paths
import java.security.KeyFactory
import java.security.PublicKey
import java.security.spec.X509EncodedKeySpec
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

object EncryptionUtils {

    private val PUBLIC_KEY: ByteArray = loadPublicKeyBytes()

    // Load the public key bytes from PEM file
    private fun loadPublicKeyBytes(): ByteArray {
        val keyPath = Paths.get("src/main/resources/key/public_key.pem")
        val keyBytes = Files.readAllBytes(keyPath)

        // Optional: If you want to remove the PEM headers/footers and base64 decode it
        val keyString = String(keyBytes)
            .replace("-----BEGIN PUBLIC KEY-----", "")
            .replace("-----END PUBLIC KEY-----", "")
            .replace("\\s".toRegex(), "")
        return java.util.Base64.getDecoder().decode(keyString)
    }

    // HMAC generation using the public key bytes as the secret key
    fun generateHmac(data: String): String {
        val mac = Mac.getInstance("HmacSHA256")
        val secretKeySpec = SecretKeySpec(PUBLIC_KEY, "HmacSHA256")
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
