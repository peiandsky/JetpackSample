package com.zlcdgroup.jetpacksample.ui.index.lottery

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zlcdgroup.jetpacksample.R

class LotteryFragment : Fragment() {

    companion object {
        fun newInstance() = LotteryFragment()
    }

    private lateinit var viewModel: LotteryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.lottery_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LotteryViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
