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

    private val signingKey: String by lazy { ("${appSecret.utf8()}&${accessSecret.utf8()}") }

    private fun getSignature(url: String, httpMethod: String): String {
        val mac = Mac.getInstance(SIGNATURE_METHOD_MAC_ID)
        val secret = SecretKeySpec(signingKey.toByteArray(), mac.algorithm)
        mac.init(secret)
        val digest = mac.doFinal(getBaseString(url, httpMethod).toByteArray())
        return DatatypeConverter.printBase64Binary(digest)
    }

    private fun getBaseString(url: String, httpMethod: String): String {
        val urlBaseWithParams = url.split("?")
        val baseUrl = "${httpMethod}&${urlBaseWithParams[0].utf8()}&"
        val params = urlBaseWithParams.subList(1, urlBaseWithParams.size).toMutableList()

        params.add("oauth_consumer_key=" + oauthConsumerKey.utf8())
        params.add("oauth_nonce=" + oauthNonce.utf8())
        params.add("oauth_signature_method=" + oauthSignatureMethod.utf8())
        params.add("oauth_timestamp=" + oauthTimestamp.utf8())
        params.add("oauth_token=" + oauthToken.utf8())
        params.add("oauth_version=" + oauthVersion.utf8())

        var paramString = ""
        params.sortedBy { it }.forEachIndexed { index, it ->
            paramString += if (index < params.size - 1) {
                "$it&"
            } else {
                it
            }
        }

        return baseUrl + paramString.utf8()
    }

    fun create(url: String, httpMethod: String): String {
        oauthSignature = getSignature(url, httpMethod)

        val urlWithoutParams = url.split("?")[0]

        return "OAuth " +
                "realm=\"" + urlWithoutParams.utf8() + "\"," +
                "oauth_consumer_key=\"" + oauthConsumerKey + "\"," +
                "oauth_token=\"" + oauthToken + "\"," +
                "oauth_nonce=\"" + oauthNonce + "\"," +
                "oauth_timestamp=\"" + oauthTimestamp + "\"," +
                "oauth_signature_method=\"" + oauthSignatureMethod + "\"," +
                "oauth_version=\"" + oauthVersion + "\"," +
                "oauth_signature=\"" + oauthSignature + "\""
    }
}