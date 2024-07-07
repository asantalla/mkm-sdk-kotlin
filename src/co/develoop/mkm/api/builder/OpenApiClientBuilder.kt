package co.develoop.mkm.api.builder

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.jaxb.JaxbConverterFactory
import java.util.concurrent.TimeUnit

class OpenApiClientBuilder {

    companion object {
        private const val BASE_URL = "https://downloads.s3.cardmarket.com/"
        private const val DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ"
        private const val TIMEOUT_UNIT = 60L
    }

    private val gson: Gson = GsonBuilder()
        .setDateFormat(DATE_FORMAT)
        .create()

    private val okHttpClient: OkHttpClient = OkHttpClient()
        .newBuilder()
        .readTimeout(TIMEOUT_UNIT, TimeUnit.MINUTES)
        .connectTimeout(TIMEOUT_UNIT, TimeUnit.MINUTES)
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