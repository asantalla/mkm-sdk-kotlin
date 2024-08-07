package co.develoop.mkm.api.open.client

import co.develoop.mkm.api.builder.OpenApiClientBuilder
import co.develoop.mkm.api.open.response.MkmGetPriceGuideResponse
import io.reactivex.Observable
import retrofit2.http.GET

class MkmPriceGuideApiClient(
    openApiClientBuilder: OpenApiClientBuilder
) {

    private val apiClient: MkmPriceGuideApi = openApiClientBuilder.create(MkmPriceGuideApi::class.java)

    fun getMagicTheGatheringPriceGuideObservable(): Observable<MkmGetPriceGuideResponse> =
        apiClient.getMagicTheGatheringPriceGuideObservable()

    fun getLorcanaPriceGuideObservable(): Observable<MkmGetPriceGuideResponse> =
        apiClient.getLorcanaPriceGuideObservable()

    private interface MkmPriceGuideApi {

        @GET("productCatalog/priceGuide/price_guide_1.json")
        fun getMagicTheGatheringPriceGuideObservable(): Observable<MkmGetPriceGuideResponse>

        @GET("productCatalog/priceGuide/price_guide_19.json")
        fun getLorcanaPriceGuideObservable(): Observable<MkmGetPriceGuideResponse>
    }
}