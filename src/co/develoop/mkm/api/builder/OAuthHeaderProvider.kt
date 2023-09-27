package co.develoop.mkm.api.builder

import co.develoop.mkm.extension.utf8
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec
import javax.xml.bind.DatatypeConverter

class OAuthHeaderProvider(
        appToken: String,
        appSecret: String,
        accessToken: String,
        accessSecret: String
) {

    companion object {
        private const val OAUTH_VERSION = "1.0"
        private const val SIGNATURE_METHOD = "HMAC-SHA1"
        private const val SIGNATURE_METHOD_MAC_ID = "HmacSHA1"
    }

    private val timestamp get() = System.currentTimeMillis() / 1000

    private val oauthVersion = OAUTH_VERSION
    private val oauthConsumerKey = appToken
    private val oauthToken = accessToken
    private val oauthSignatureMethod = SIGNATURE_METHOD
    private val oauthTimestamp = "$timestamp"
    private val oauthNonce = "$timestamp"
    private lateinit var oauthSignature: String

    private val signingKey: String = appSecret.utf8() + "&" + accessSecret.utf8()

    private fun getSignature(url: String, httpMethod: String): String {
        val mac = Mac.getInstance(SIGNATURE_METHOD_MAC_ID)
        val secret = SecretKeySpec(signingKey.toByteArray(), mac.algorithm)
        mac.init(secret)
        val digest = mac.doFinal(getBaseString(url, httpMethod).toByteArray())
        return DatatypeConverter.printBase64Binary(digest)
    }

    private fun getBaseString(url: String, httpMethod: String): String {
        val urlBaseWithParams = url.split("?")
        val baseUrl = "${httpMethod.utf8()}&${urlBaseWithParams[0].utf8()}&"
        val params = if (urlBaseWithParams.size > 1) "${urlBaseWithParams[1]}&" else ""

        val paramString = params + "oauth_consumer_key=" + oauthConsumerKey.utf8() + "&" +
                "oauth_nonce=" + oauthNonce.utf8() + "&" +
                "oauth_signature_method=" + oauthSignatureMethod.utf8() + "&" +
                "oauth_timestamp=" + oauthTimestamp.utf8() + "&" +
                "oauth_token=" + oauthToken.utf8() + "&" +
                "oauth_version=" + oauthVersion.utf8()

        return baseUrl + paramString.utf8()
    }

    fun create(url: String, httpMethod: String): String {
        oauthSignature = getSignature(url, httpMethod)

        val urlWithoutParams = url.split("?")[0]

        return "OAuth " +
                "realm=\"" + urlWithoutParams.utf8() + "\", " +
                "oauth_version=\"" + oauthVersion.utf8() + "\", " +
                "oauth_timestamp=\"" + oauthTimestamp.utf8() + "\", " +
                "oauth_nonce=\"" + oauthNonce.utf8() + "\", " +
                "oauth_consumer_key=\"" + oauthConsumerKey.utf8() + "\", " +
                "oauth_token=\"" + oauthToken.utf8() + "\", " +
                "oauth_signature_method=\"" + oauthSignatureMethod.utf8() + "\", " +
                "oauth_signature=\"" + oauthSignature.utf8() + "\""
    }
}
