package co.develoop.mkm.api.stock.client

import co.develoop.mkm.api.builder.ApiClientBuilder
import co.develoop.mkm.api.stock.request.*
import co.develoop.mkm.api.stock.response.*
import io.reactivex.Observable
import retrofit2.http.*

class MkmStockApiClient(
        apiClientBuilder: ApiClientBuilder
) {

    private val apiClient: MkmStockApi = apiClientBuilder.create(MkmStockApi::class.java)

    fun getStockObservable(start: Int? = null): Observable<MkmGetStockResponse> =
            start?.let {
                apiClient.getStockObservable(it)
            } ?: apiClient.getStockObservable()

    fun addProductsObservable(request: MkmAddProductsRequest): Observable<MkmAddProductsResponse> =
            apiClient.addProductsObservable(request)

    fun editArticlesObservable(request: MkmEditArticlesRequest): Observable<MkmEditArticlesResponse> =
            apiClient.editArticlesObservable(request)

    fun deleteArticlesObservable(request: MkmDeleteArticlesRequest): Observable<MkmDeleteArticlesResponse> =
            apiClient.deleteArticlesObservable(request)

    fun increaseArticlesObservable(request: MkmIncreaseArticlesRequest): Observable<MkmIncreaseArticlesResponse> =
            apiClient.increaseArticlesObservable(request)

    fun decreaseArticlesObservable(request: MkmDecreaseArticlesRequest): Observable<MkmDecreaseArticlesResponse> =
            apiClient.decreaseArticlesObservable(request)

    private interface MkmStockApi {

        @GET("stock")
        fun getStockObservable(): Observable<MkmGetStockResponse>

        @GET("stock/{start}")
        fun getStockObservable(@Path("start") start: Int): Observable<MkmGetStockResponse>

        @POST("stock")
        fun addProductsObservable(@Body request: MkmAddProductsRequest): Observable<MkmAddProductsResponse>

        @PUT("stock")
        fun editArticlesObservable(@Body request: MkmEditArticlesRequest): Observable<MkmEditArticlesResponse>

        @HTTP(method = "DELETE", path = "stock", hasBody = true)
        fun deleteArticlesObservable(@Body request: MkmDeleteArticlesRequest): Observable<MkmDeleteArticlesResponse>

        @PUT("stock/increase")
        fun increaseArticlesObservable(@Body request: MkmIncreaseArticlesRequest): Observable<MkmIncreaseArticlesResponse>

        @PUT("stock/decrease")
        fun decreaseArticlesObservable(@Body request: MkmDecreaseArticlesRequest): Observable<MkmDecreaseArticlesResponse>
    }
}