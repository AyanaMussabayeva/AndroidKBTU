package supermegadeveloper.ayana.lab5

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ApiClient {
    fun getNews(): Observable<List<News>>

    /* Get one article by it's id */
    @GET("posts/{id}")
    fun getNews(@Path("id") id: Int): Observable<News>

    /* Add new article */
    @Headers("Content-Type: application/json;charset=utf-8")
    @POST("posts")
    fun addNews(@Body news: News): Observable<News>

    companion object {

        fun create(): ApiClient {

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .build()

            return retrofit.create(ApiClient::class.java)

        }
    }
}