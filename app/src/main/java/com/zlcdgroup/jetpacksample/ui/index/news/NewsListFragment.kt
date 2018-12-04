package com.zlcdgroup.jetpacksample.ui.index.news

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.zlcdgroup.jetpacksample.R
import com.zlcdgroup.jetpacksample.databinding.NewsListFragmentBinding

class NewsListFragment : Fragment() {

    companion object {
        fun newInstance() = NewsListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding =
            DataBindingUtil.inflate<NewsListFragmentBinding>(inflater, R.layout.news_list_fragment, container, false)
        val viewModel = ViewModelProviders.of(this).get(NewsListViewModel::class.java)

        binding.viewmodel = viewModel

        return binding.root
    }

}
