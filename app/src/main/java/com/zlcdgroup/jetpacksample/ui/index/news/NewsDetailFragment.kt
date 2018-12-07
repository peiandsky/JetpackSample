package com.zlcdgroup.jetpacksample.ui.index.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import androidx.databinding.DataBindingUtil
import com.zlcdgroup.jetpacksample.R
import com.zlcdgroup.jetpacksample.databinding.NewsDetailFragmentBinding

class NewsDetailFragment : Fragment() {

    companion object {
        fun newInstance() = NewsDetailFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val newsUrl = arguments?.getString("newsUrl")

        val binding = DataBindingUtil.inflate<NewsDetailFragmentBinding>(
            inflater,
            R.layout.news_detail_fragment, container, false
        )

        binding.newsWebView.run {
            settings.javaScriptEnabled = true
            settings.allowContentAccess = true
            settings.allowFileAccess = true
            settings.builtInZoomControls = true
            settings.setAppCacheEnabled(true)
            settings.domStorageEnabled = true
            settings.supportMultipleWindows()
            settings.layoutAlgorithm = WebSettings.LayoutAlgorithm.NARROW_COLUMNS
            settings.useWideViewPort = true
            settings.javaScriptCanOpenWindowsAutomatically = true
            settings.loadsImagesAutomatically = true
            webChromeClient = WebChromeClient()

            loadUrl(newsUrl)
        }




        return binding.root
    }
}
