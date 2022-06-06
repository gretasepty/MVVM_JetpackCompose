package binar.greta.pert4_menampilkandata.api

import binar.greta.pert4_menampilkandata.data.ResponseNewsItem
import retrofit2.http.GET

interface ApiService {
    @GET("news")
    suspend fun getAllNews() : List<ResponseNewsItem>
}