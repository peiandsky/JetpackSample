package com.zlcdgroup.jetpacksample.ui.index.news

import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.*
import com.zlcdgroup.jetpacksample.BuildConfig
import com.zlcdgroup.jetpacksample.ui.index.news.data.NewsData
import com.zlcdgroup.jetpacksample.ui.index.news.data.NewsRepository

class NewsListViewModel(private val repository: NewsRepository) : ViewModel() {
    /**
     * 0：表示未设置
     * 1：表示显示
     * 2：表示隐藏
     */
    val refreshState = ObservableInt(0)
    val newsType = ObservableField<String>()
    val newsTypeTitle = ObservableField<String>()

//    val newsTypeLiveData: MutableLiveData<String> = MutableLiveData()

//    var newsList: LiveData<List<NewsData>> = Transformations.map(newsTypeLiveData) {
//
//        val temp = repository.getNewsDataList(newsTypeTitle.get() ?: "国内").value
//        if (BuildConfig.DEBUG) {
//            println("Transformations:newsList${temp?.size}")
//        }
//        temp
//    }

    val newsListChange=MediatorLiveData<List<NewsData>>()

//    val newsListOrginal=repository.getNewsDataList(newsTypeTitle.get() ?: "国内")

}

class NewsListViewModelFactory(private val repository: NewsRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewsListViewModel(repository) as T
    }
}