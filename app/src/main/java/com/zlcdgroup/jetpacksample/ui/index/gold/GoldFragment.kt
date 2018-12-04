package com.zlcdgroup.jetpacksample.ui.index.gold

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zlcdgroup.jetpacksample.R

class GoldFragment : Fragment() {

    companion object {
        fun newInstance() = GoldFragment()
    }

    private lateinit var viewModel: GoldViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.gold_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(GoldViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
