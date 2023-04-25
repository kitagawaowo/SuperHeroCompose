package pe.edu.superherocompose.data.remote

import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Path

interface SuperHeroService {
    @GET("search/{name}")
    fun fetchByName(@Path("name") name: String): Call<SuperHeroResponse>
}