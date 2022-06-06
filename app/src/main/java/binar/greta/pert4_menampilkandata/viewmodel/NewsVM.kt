package binar.greta.pert4_menampilkandata.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import binar.greta.pert4_menampilkandata.NewsRepository
import binar.greta.pert4_menampilkandata.data.ResponseNewsItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsVM @Inject constructor(private val api : NewsRepository) : ViewModel() {
    private val newsState = MutableStateFlow(emptyList<ResponseNewsItem>())

    val datastate : StateFlow<List<ResponseNewsItem>>
    get() = newsState

    init {
        viewModelScope.launch {
            val news = api.getNews()
            newsState.value = news
        }
    }
}