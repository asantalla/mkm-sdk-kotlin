package co.develoop.mkm.api.marketplace.client

import co.develoop.mkm.api.builder.ApiClientBuilder
import co.develoop.mkm.api.marketplace.response.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

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

    fun getMetaproductsObservable(idMetaproduct: Long): Observable<MkmGetMetaproductResponse> =
        apiClient.getMetaproductsObservable(idMetaproduct)

    fun findUsersObservable(username: String): Observable<MkmFindUsersResponse> =
        apiClient.findUsersObservable(username)

    private interface MkmMarketplaceApi {

        @GET("games")
        fun getGamesObservable(): Observable<MkmGetGamesResponse>

        @GET("games/{idGame}/expansions")
        fun getExpansionsByGameObservable(@Path("idGame") idGame: Int): Observable<MkmGetExpansionsByGameResponse>

        @GET("expansions/{idExpansion}/singles")
        fun getExpansionSinglesObservable(@Path("idExpansion") idExpansion: Int): Observable<MkmGetExpansionSinglesResponse>

        @GET("products/{idProduct}")
        fun getProductObservable(@Path("idProduct") idProduct: Long): Observable<MkmGetProductResponse>

        @GET("metaproducts/{idMetaproduct}")
        fun getMetaproductsObservable(@Path("idMetaproduct") idMetaproduct: Long): Observable<MkmGetMetaproductResponse>

        @GET("users/find")
        fun findUsersObservable(@Query("search") username: String): Observable<MkmFindUsersResponse>
    }
}