package co.develoop.mkm.api.stock.client

import co.develoop.mkm.api.builder.ApiClientBuilder
import co.develoop.mkm.api.stock.request.MkmAddProductsRequest
import co.develoop.mkm.api.stock.response.MkmAddProductsResponse
import co.develoop.mkm.api.stock.response.MkmGetStockResponse
import co.develoop.mkm.model.MkmArticle
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

class MkmStockApiClient(
        apiClientBuilder: ApiClientBuilder
) {

    private val apiClient: MkmStockApi = apiClientBuilder.create(MkmStockApi::class.java)

    fun getStockObservable(): Observable<List<MkmArticle>> {
        return apiClient.getStockObservable().map { it.articles }
    }

    fun addProductsObservable(request: MkmAddProductsRequest): Observable<List<MkmArticle>> {
        return apiClient.addProductsObservable(request).map { it.articles.map { it.article } }
    }

    private interface MkmStockApi {

        @GET("stock")
        fun getStockObservable(): Observable<MkmGetStockResponse>

        @POST("stock")
        fun addProductsObservable(@Body request: MkmAddProductsRequest): Observable<MkmAddProductsResponse>
    }
}