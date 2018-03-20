package co.develoop.mkm.api.builder

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor(
        private val oAuthHeaderProvider: OAuthHeaderProvider
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
                .addHeader("Authorization", oAuthHeaderProvider.create(request.url().url().toString()))
                .build()
        return chain.proceed(request)
    }
}