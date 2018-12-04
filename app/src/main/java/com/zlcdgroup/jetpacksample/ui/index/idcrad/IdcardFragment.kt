package com.zlcdgroup.jetpacksample.ui.index.idcrad

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zlcdgroup.jetpacksample.R

class IdcardFragment : Fragment() {

    companion object {
        fun newInstance() = IdcardFragment()
    }

    private lateinit var viewModel: IdcardViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.idcard_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(IdcardViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
