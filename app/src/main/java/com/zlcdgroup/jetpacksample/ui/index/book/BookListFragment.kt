package com.zlcdgroup.jetpacksample.ui.index.book

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zlcdgroup.jetpacksample.R

class BookListFragment : Fragment() {

    companion object {
        fun newInstance() = BookListFragment()
    }

    private lateinit var viewModel: BookListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.book_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BookListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
