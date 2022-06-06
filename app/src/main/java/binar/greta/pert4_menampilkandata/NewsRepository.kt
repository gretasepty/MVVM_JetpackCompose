package binar.greta.pert4_menampilkandata

import binar.greta.pert4_menampilkandata.api.ApiService
import binar.greta.pert4_menampilkandata.data.ResponseNewsItem
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsapi : ApiService) {

    suspend fun getNews() : List<ResponseNewsItem>{
        return newsapi.getAllNews()
    }
}