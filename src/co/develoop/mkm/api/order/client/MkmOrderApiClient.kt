package co.develoop.mkm.api.order.client

import co.develoop.mkm.api.builder.ApiClientBuilder
import co.develoop.mkm.api.order.response.MkmGetOrdersResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

class MkmOrderApiClient(
    apiClientBuilder: ApiClientBuilder
) {

    private val apiClient: MkmOrderApiClient.MkmOrderApi =
        apiClientBuilder.create(MkmOrderApiClient.MkmOrderApi::class.java)

    fun getOrdersObservable(
        actor: Actor,
        state: State,
        start: Int
    ): Observable<MkmGetOrdersResponse> =
        apiClient.getOrdersObservable(actor.name.toLowerCase(), state.name.toLowerCase(), start)

    private interface MkmOrderApi {

        @GET("orders/{actor}/{state}/{start}")
        fun getOrdersObservable(
            @Path("actor") actor: String,
            @Path("state") state: String,
            @Path("start") start: Int
        ): Observable<MkmGetOrdersResponse>
    }

    enum class Actor {
        SELLER, BUYER
    }

    enum class State {
        BOUGHT, PAID, SENT, RECEIVED, LOST, CANCELLED
    }
}