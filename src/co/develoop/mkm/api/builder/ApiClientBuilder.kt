package co.develoop.mkm.api.builder

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.jaxb.JaxbConverterFactory

class ApiClientBuilder(
        appToken: String,
        appSecret: String,
        accessToken: String,
        accessSecret: String
) {

    companion object {
        private const val BASE_URL = "https://www.mkmapi.eu/ws/v2.0/output.json/"
        private const val DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss+0100"
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
            .addInterceptor(HeaderInterceptor(oAuthHeaderProvider))
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