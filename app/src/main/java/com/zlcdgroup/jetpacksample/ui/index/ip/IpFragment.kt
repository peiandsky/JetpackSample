package com.zlcdgroup.jetpacksample.ui.index.ip

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zlcdgroup.jetpacksample.R

class IpFragment : Fragment() {

    companion object {
        fun newInstance() = IpFragment()
    }

    private lateinit var viewModel: IpViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.ip_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(IpViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
