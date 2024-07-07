package co.develoop.mkm.api.marketplace.client

import co.develoop.mkm.api.builder.ApiClientBuilder
import co.develoop.mkm.api.marketplace.response.MkmGetExpansionSinglesResponse
import co.develoop.mkm.api.marketplace.response.MkmGetExpansionsByGameResponse
import co.develoop.mkm.api.marketplace.response.MkmGetGamesResponse
import co.develoop.mkm.api.marketplace.response.MkmGetProductResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

class MkmMarketplaceApiClient(
    apiClientBuilder: ApiClientBuilder
) {

    private val apiClient: MkmMarketplaceApi = apiClientBuilder.create(MkmMarketplaceApi::class.java)

    fun getGamesObservable(): Observable<MkmGetGamesResponse> = apiClient.getGamesObservable()

    fun getExpansionsByGameObservable(idGame: Int): Observable<MkmGetExpansionsByGameResponse> =
        apiClient.getExpansionsByGameObservable(idGame)

    fun getExpansionSinglesObservable(idExpansion: Int): Observable<MkmGetExpansionSinglesResponse> =
        apiClient.getExpansionSinglesObservable(idExpansion)

    fun getProductObservable(idProduct: Long): Observable<MkmGetProductResponse> =
        apiClient.getProductObservable(idProduct)

    private interface MkmMarketplaceApi {

        @GET("games")
        fun getGamesObservable(): Observable<MkmGetGamesResponse>

        @GET("games/{idGame}/expansions")
        fun getExpansionsByGameObservable(@Path("idGame") idGame: Int): Observable<MkmGetExpansionsByGameResponse>

        @GET("expansions/{idExpansion}/singles")
        fun getExpansionSinglesObservable(@Path("idExpansion") idExpansion: Int): Observable<MkmGetExpansionSinglesResponse>

        @GET("products/{idProduct}")
        fun getProductObservable(@Path("idProduct") idProduct: Long): Observable<MkmGetProductResponse>
    }
}