package com.zlcdgroup.jetpacksample.ui.index.news

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zlcdgroup.jetpacksample.ui.index.news.data.NewsData
import com.zlcdgroup.jetpacksample.ui.index.news.data.NewsRepository

class NewsListViewModel(private val repository: NewsRepository, private val category: String) : ViewModel() {
    val newsType = ObservableField<String>()
    val newsTypeTitle = ObservableField<String>()

    val newsList: LiveData<List<NewsData>> = repository.getNewsDataList(category)

}

class NewsListViewModelFactory(private val repository: NewsRepository,private val category: String) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsListViewModel(repository,category) as T
    }
}