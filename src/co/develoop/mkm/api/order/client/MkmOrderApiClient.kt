package co.develoop.mkm.api.order.client

import co.develoop.mkm.api.builder.ApiClientBuilder
import co.develoop.mkm.api.order.request.MkmUpdateOrderStatusRequest
import co.develoop.mkm.api.order.response.MkmGetOrderDetailsResponse
import co.develoop.mkm.api.order.response.MkmGetOrdersResponse
import co.develoop.mkm.api.order.response.MkmUpdateOrderStatusResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path
import java.util.*

class MkmOrderApiClient(
    apiClientBuilder: ApiClientBuilder
) {

    private val apiClient: MkmOrderApiClient.MkmOrderApi =
        apiClientBuilder.create(MkmOrderApiClient.MkmOrderApi::class.java)

    fun getOrdersObservable(
        actor: Actor,
        state: State,
        start: Int
    ): Observable<Response<MkmGetOrdersResponse>> =
        apiClient.getOrdersObservable(
            actor.name.lowercase(Locale.getDefault()),
            state.name.lowercase(Locale.getDefault()),
            start
        )

    fun updateOrderStatusObservable(
        request: MkmUpdateOrderStatusRequest,
        orderId: String
    ): Observable<Response<MkmUpdateOrderStatusResponse>> =
        apiClient.updateOrderStatusObservable(request, orderId)

    fun getOrderDetailsObservable(
        orderId: String
    ): Observable<Response<MkmGetOrderDetailsResponse>> =
        apiClient.getOrderDetailsObservable(orderId)

    private interface MkmOrderApi {

        @GET("orders/{actor}/{state}/{start}")
        fun getOrdersObservable(
            @Path("actor") actor: String,
            @Path("state") state: String,
            @Path("start") start: Int
        ): Observable<Response<MkmGetOrdersResponse>>

        @PUT("order/{orderId}")
        fun updateOrderStatusObservable(
            @Body request: MkmUpdateOrderStatusRequest,
            @Path("orderId") orderId: String
        ): Observable<Response<MkmUpdateOrderStatusResponse>>

        @GET("order/{orderId}")
        fun getOrderDetailsObservable(
            @Path("orderId") orderId: String
        ): Observable<Response<MkmGetOrderDetailsResponse>>
    }

    enum class Actor {
        SELLER, BUYER
    }

    enum class State {
        BOUGHT, PAID, SENT, RECEIVED, LOST, CANCELLED
    }

    enum class ACTION(val action: String) {
        SEND(action = "send"),
        CONFIRM_RECEPTION(action = "confirmReception"),
        CANCEL(action = "cancel"),
        REQUEST_CANCELLATION(action = "requestCancellation"),
        ACCEPT_CANCELLATION(action = "acceptCancellation")
    }
}