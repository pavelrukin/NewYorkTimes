package com.pavelrukin.newyorktimes.ui.adapter.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.pavelrukin.newyorktimes.R
import com.pavelrukin.newyorktimes.databinding.FragmentDetailBinding
import com.pavelrukin.newyorktimes.databinding.TopStoriesFragmentBinding


class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
      val args:DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
      binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail,container,false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.webView.loadUrl(args.postId.url)
        Log.d("Detail", "onActivityCreated:${args.postId.url}")
    }

}