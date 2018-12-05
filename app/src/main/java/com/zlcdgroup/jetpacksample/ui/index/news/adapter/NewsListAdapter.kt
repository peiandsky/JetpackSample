package com.zlcdgroup.jetpacksample.ui.index.news.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.zlcdgroup.jetpacksample.databinding.NewsItemBinding
import com.zlcdgroup.jetpacksample.ui.index.news.data.NewsData
import org.jetbrains.anko.sdk27.coroutines.onClick

class NewsListAdapter(private val itemClick: (NewsData, Int) -> Unit) :
    ListAdapter<NewsData, NewsListAdapter.ViewHolder>(DiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), position, itemClick)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = NewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    class ViewHolder(val binding: NewsItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(newsData: NewsData, position: Int, itemClick: (NewsData, Int) -> Unit) {
            binding.apply {
                this.news = newsData
                binding.root.onClick {
                    itemClick(newsData, position)
                }
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<NewsData>() {
        override fun areItemsTheSame(oldItem: NewsData, newItem: NewsData): Boolean {
            return oldItem.uniquekey == newItem.uniquekey
        }

        override fun areContentsTheSame(oldItem: NewsData, newItem: NewsData): Boolean {
            return oldItem.uniquekey == newItem.uniquekey
        }
    }


}
