package co.develoop.mkm.api.builder

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor(
    private val oAuthHeaderProvider: OAuthHeaderProvider
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        val requestBuilder = request.newBuilder()

        request = requestBuilder.apply {
            if (request.method == "POST" && request.url.toString() != "https://api.cardmarket.com/ws/v2.0/output.json/exports/stock") {
                addHeader("Content-Type", "application/xml")
            }
            addHeader("Authorization", oAuthHeaderProvider.create(request.url.toString(), request.method))
            addHeader("Host", "api.cardmarket.com")
        }.build()

        return chain.proceed(request)
    }
}
