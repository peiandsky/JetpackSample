package com.zlcdgroup.jetpacksample.ui.index.news

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zlcdgroup.jetpacksample.R
import com.zlcdgroup.jetpacksample.databinding.NewslistFragmentBinding
import com.zlcdgroup.jetpacksample.db.AppDatabase
import com.zlcdgroup.jetpacksample.net.Http
import com.zlcdgroup.jetpacksample.ui.index.news.adapter.NewsListAdapter
import com.zlcdgroup.jetpacksample.ui.index.news.data.NewsRepository
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.support.v4.toast

/**
 * 新闻列表界面
 */
class NewsListFragment : Fragment() {
    companion object {
        fun newInstance() = NewsListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val newsType = arguments?.getString("newsType")
        val newsTypeTitle = arguments?.getString("newsTypeTitle")

        val repository = NewsRepository(AppDatabase.instance)
        val factory = NewsListViewModelFactory(repository, newsTypeTitle!!)
        val viewModel = ViewModelProviders.of(this, factory).get(NewsListViewModel::class.java)
        viewModel.newsType.set(newsType)
        viewModel.newsTypeTitle.set(newsTypeTitle)


        val binding =
            DataBindingUtil.inflate<NewslistFragmentBinding>(inflater, R.layout.newslist_fragment, container, false)
        binding.viewmodel = viewModel

        val adapter = NewsListAdapter(itemClick = { data, pos ->

            toast(data.title ?: "")

        })

        binding.recyclerView.adapter = adapter

        viewModel.newsList.observe(this, Observer { list ->
            if (list != null) {
                adapter.submitList(list)
                viewModel.refreshState.set(System.currentTimeMillis().toInt())
            }
        })

        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            var lastVisibleItem = 0
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//                super.onScrollStateChanged(recyclerView, newState)
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                    if (lastVisibleItem + 1 == layoutManager.itemCount) {
//                        toast("上拉加载更多")
                    }
                }
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val manager: LinearLayoutManager = recyclerView.layoutManager as LinearLayoutManager
                lastVisibleItem = manager.findLastVisibleItemPosition()
            }
        })

        binding.refreshLayout.setOnRefreshListener {
            //            toast("下拉刷新")
            Http.createAPI().toutiao(newsType!!).subscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .subscribe({ response ->

                    viewModel.refreshState.set(System.currentTimeMillis().toInt())

                    if (response.error_code != 0) {
                        //toast是系统处理的，可以不和生命周期处理，其他的提示信息就要慎重，避免溢出
                        toast(response.reason ?: "服务器数据返回异常")
                        return@subscribe
                    }
                    response.result?.data?.let {
                        repository.insertAll(it)
                    }
                }, Throwable::printStackTrace)
        }
        return binding.root
    }

}
