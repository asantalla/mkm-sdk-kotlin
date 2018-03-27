package co.develoop.mkm.api.stock.client

import co.develoop.mkm.api.builder.ApiClientBuilder
import co.develoop.mkm.api.stock.request.MkmAddProductsRequest
import co.develoop.mkm.api.stock.request.MkmDeleteArticlesRequest
import co.develoop.mkm.api.stock.request.MkmEditArticlesRequest
import co.develoop.mkm.api.stock.response.MkmAddProductsResponse
import co.develoop.mkm.api.stock.response.MkmDeleteArticlesResponse
import co.develoop.mkm.api.stock.response.MkmEditArticlesResponse
import co.develoop.mkm.api.stock.response.MkmGetStockResponse
import io.reactivex.Observable
import retrofit2.http.*

class MkmStockApiClient(
        apiClientBuilder: ApiClientBuilder
) {

    private val apiClient: MkmStockApi = apiClientBuilder.create(MkmStockApi::class.java)

    fun getStockObservable(): Observable<MkmGetStockResponse> =
            apiClient.getStockObservable()

    fun addProductsObservable(request: MkmAddProductsRequest): Observable<MkmAddProductsResponse> =
            apiClient.addProductsObservable(request)

    fun editArticlesObservable(request: MkmEditArticlesRequest): Observable<MkmEditArticlesResponse> =
            apiClient.editArticlesObservable(request)

    fun deleteArticlesObservable(request: MkmDeleteArticlesRequest): Observable<MkmDeleteArticlesResponse> =
            apiClient.deleteArticlesObservable(request)

    private interface MkmStockApi {

        @GET("stock")
        fun getStockObservable(): Observable<MkmGetStockResponse>

        @POST("stock")
        fun addProductsObservable(@Body request: MkmAddProductsRequest): Observable<MkmAddProductsResponse>

        @PUT("stock")
        fun editArticlesObservable(@Body request: MkmEditArticlesRequest): Observable<MkmEditArticlesResponse>

        @HTTP(method = "DELETE", path = "stock", hasBody = true)
        fun deleteArticlesObservable(@Body request: MkmDeleteArticlesRequest): Observable<MkmDeleteArticlesResponse>
    }
}