package co.develoop.mkm.api.builder

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.lang.reflect.Type

class RxCallAdapterFactory : CallAdapter.Factory() {

    private val originalRxCallAdapterFactory = RxJava2CallAdapterFactory.create()

    companion object {
        fun create(): CallAdapter.Factory {
            return RxCallAdapterFactory()
        }
    }

    override fun get(returnType: Type, annotations: Array<out Annotation>, retrofit: Retrofit): RxCallAdapterWrapper<out Any> =
            RxCallAdapterWrapper(retrofit, originalRxCallAdapterFactory.get(returnType, annotations, retrofit)!!)

}

class RxCallAdapterWrapper<R>(
        private val retrofit: Retrofit,
        private val wrappedCallAdapter: CallAdapter<R, *>
) : CallAdapter<R, Any> {

    override fun responseType(): Type =
            wrappedCallAdapter.responseType()

    override fun adapt(call: Call<R>): Any {
        val result = wrappedCallAdapter.adapt(call)

        if (result is Completable) {
            return result.onErrorResumeNext(
                    { throwable ->
                        Completable.error(throwable)
                    })
        }

        if (result is Single<*>) {
            return result.onErrorResumeNext(
                    { throwable: Throwable ->
                        Single.error(throwable)
                    })
        }

        if (result is Observable<*>) {
            return result.onErrorResumeNext(
                    { throwable: Throwable ->
                        Observable.error(throwable)
                    })
        }

        throw RuntimeException("Observable Type not supported")
    }
}