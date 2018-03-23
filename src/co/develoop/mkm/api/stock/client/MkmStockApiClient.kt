package co.develoop.mkm.api.stock.client

import co.develoop.mkm.api.builder.ApiClientBuilder
import co.develoop.mkm.api.stock.request.MkmAddProductsRequest
import co.develoop.mkm.api.stock.request.MkmEditArticlesRequest
import co.develoop.mkm.api.stock.response.MkmAddProductsResponse
import co.develoop.mkm.api.stock.response.MkmEditArticlesResponse
import co.develoop.mkm.api.stock.response.MkmGetStockResponse
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

class MkmStockApiClient(
        apiClientBuilder: ApiClientBuilder
) {

    private val apiClient: MkmStockApi = apiClientBuilder.create(MkmStockApi::class.java)

    fun getStockObservable(): Observable<MkmGetStockResponse> {
        return apiClient.getStockObservable()
    }

    fun addProductsObservable(request: MkmAddProductsRequest): Observable<MkmAddProductsResponse> {
        return apiClient.addProductsObservable(request)
    }

    fun editArticlesObservable(request: MkmEditArticlesRequest): Observable<MkmEditArticlesResponse> {
        return apiClient.editArticlesObservable(request)
    }

    private interface MkmStockApi {

        @GET("stock")
        fun getStockObservable(): Observable<MkmGetStockResponse>

        @POST("stock")
        fun addProductsObservable(@Body request: MkmAddProductsRequest): Observable<MkmAddProductsResponse>

        @PUT("stock")
        fun editArticlesObservable(@Body request: MkmEditArticlesRequest): Observable<MkmEditArticlesResponse>
    }
}