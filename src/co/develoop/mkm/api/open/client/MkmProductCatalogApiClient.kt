package co.develoop.mkm.api.open.client

import co.develoop.mkm.api.builder.OpenApiClientBuilder
import co.develoop.mkm.api.open.response.MkmGetProductCatalogResponse
import io.reactivex.Observable
import retrofit2.http.GET

class MkmProductCatalogApiClient(
    openApiClientBuilder: OpenApiClientBuilder
) {

    private val apiClient: MkmPriceGuideApi = openApiClientBuilder.create(MkmPriceGuideApi::class.java)

    fun getMagicTheGatheringSinglesObservable(): Observable<MkmGetProductCatalogResponse> =
        apiClient.getMagicTheGatheringSinglesObservable()

    fun getMagicTheGatheringNonSinglesObservable(): Observable<MkmGetProductCatalogResponse> =
        apiClient.getMagicTheGatheringNonSinglesObservable()

    fun getLorcanaSinglesObservable(): Observable<MkmGetProductCatalogResponse> =
        apiClient.getLorcanaSinglesObservable()

    fun getLorcanaNonSinglesObservable(): Observable<MkmGetProductCatalogResponse> =
        apiClient.getLorcanaNonSinglesObservable()

    private interface MkmPriceGuideApi {

        @GET("productCatalog/productList/products_singles_1.json")
        fun getMagicTheGatheringSinglesObservable(): Observable<MkmGetProductCatalogResponse>

        @GET("productCatalog/productList/products_nonsingles_1.json")
        fun getMagicTheGatheringNonSinglesObservable(): Observable<MkmGetProductCatalogResponse>

        @GET("productCatalog/productList/products_singles_19.json")
        fun getLorcanaSinglesObservable(): Observable<MkmGetProductCatalogResponse>

        @GET("productCatalog/productList/products_nonsingles_19.json")
        fun getLorcanaNonSinglesObservable(): Observable<MkmGetProductCatalogResponse>
    }
}