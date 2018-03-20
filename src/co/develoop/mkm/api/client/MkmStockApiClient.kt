package co.develoop.mkm.api.client

import co.develoop.mkm.api.builder.ApiClientBuilder
import co.develoop.mkm.api.response.MkmStockResponse
import io.reactivex.Observable
import retrofit2.http.GET

class MkmStockApiClient(
        apiClientBuilder: ApiClientBuilder
) {

    private val apiClient: MkmStockApi = apiClientBuilder.create(MkmStockApi::class.java)

    fun getStockObservable(): Observable<MkmStockResponse> {
        return apiClient.getStockObservable()
    }

    private interface MkmStockApi {

        @GET("stock")
        fun getStockObservable(): Observable<MkmStockResponse>
    }
}