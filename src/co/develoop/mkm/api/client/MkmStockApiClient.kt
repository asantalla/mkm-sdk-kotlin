package co.develoop.mkm.api.client

import co.develoop.mkm.api.builder.ApiClientBuilder
import co.develoop.mkm.api.request.MkmAddArticlesRequest
import co.develoop.mkm.api.response.MkmAddArticlesResponse
import co.develoop.mkm.api.response.MkmGetStockResponse
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

    fun addArticleObservable(request: MkmAddArticlesRequest): Observable<List<MkmArticle>> {
        return apiClient.addArticleObservable(request).map { it.articles.map { it.article } }
    }

    private interface MkmStockApi {

        @GET("stock")
        fun getStockObservable(): Observable<MkmGetStockResponse>

        @POST("stock")
        fun addArticleObservable(@Body request: MkmAddArticlesRequest): Observable<MkmAddArticlesResponse>
    }
}