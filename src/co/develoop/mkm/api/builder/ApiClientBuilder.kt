package co.develoop.mkm.api.builder

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.jaxb.JaxbConverterFactory
import java.util.concurrent.TimeUnit

class ApiClientBuilder(
    appToken: String,
    appSecret: String,
    accessToken: String,
    accessSecret: String
) {

    companion object {
        private const val BASE_URL = "https://api.cardmarket.com/ws/v2.0/output.json/"
        private const val DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ"
        private const val TIMEOUT_UNIT = 60L
    }

    private val oAuthHeaderProvider: OAuthHeaderProvider = OAuthHeaderProvider(
        appToken = appToken,
        appSecret = appSecret,
        accessToken = accessToken,
        accessSecret = accessSecret
    )

    private val gson: Gson = GsonBuilder()
        .setDateFormat(DATE_FORMAT)
        .create()

    private val okHttpClient: OkHttpClient = OkHttpClient()
        .newBuilder()
        .readTimeout(TIMEOUT_UNIT, TimeUnit.MINUTES)
        .connectTimeout(TIMEOUT_UNIT, TimeUnit.MINUTES)
        .addInterceptor(HeaderInterceptor(oAuthHeaderProvider))
        .addInterceptor(HttpLoggingInterceptor().apply { // logging interceptor coming from OkHttp
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addCallAdapterFactory(RxCallAdapterFactory.create())
        .addConverterFactory(JaxbConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttpClient)
        .build()

    fun <T> create(clazz: Class<T>): T {
        return retrofit.create(clazz)
    }
}
