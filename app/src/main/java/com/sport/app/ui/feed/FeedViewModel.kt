package com.sport.app.ui.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sport.app.domain.entity.NewsItem

class FeedViewModel : ViewModel() {

    private val _news = MutableLiveData<List<NewsItem>>().apply {
        value = listOf()
    }
    val news: LiveData<List<NewsItem>> = _news

    init {
        getNews()
    }

    fun getEvents() {
        getNews()
    }

    fun getNews() {
        _news.value = listOf(NewsItem("Новость", "Описание", "", "15/07/2022", ""))
    }
}