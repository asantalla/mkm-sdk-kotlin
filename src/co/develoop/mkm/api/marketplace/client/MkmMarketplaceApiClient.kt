package co.develoop.mkm.api.marketplace.client

import co.develoop.mkm.api.builder.ApiClientBuilder
import co.develoop.mkm.api.marketplace.response.MkmGetGamesResponse
import io.reactivex.Observable
import retrofit2.http.GET

class MkmMarketplaceApiClient(
        apiClientBuilder: ApiClientBuilder
) {

    private val apiClient: MkmMarketplaceApi = apiClientBuilder.create(MkmMarketplaceApi::class.java)

    fun getGamesObservable(): Observable<MkmGetGamesResponse> =
            apiClient.getGamesObservable()

    private interface MkmMarketplaceApi {

        @GET("games")
        fun getGamesObservable(): Observable<MkmGetGamesResponse>
    }
}