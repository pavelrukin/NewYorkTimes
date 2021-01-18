package com.pavelrukin.newyorktimes.ui.news

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.pavelrukin.newyorktimes.R
import com.pavelrukin.newyorktimes.databinding.TopStoriesFragmentBinding
import com.pavelrukin.newyorktimes.model.TopStoriesResponse
import com.pavelrukin.newyorktimes.ui.adapter.TopStoriesAdapter
import com.pavelrukin.newyorktimes.utils.Resources
import org.koin.androidx.viewmodel.ext.android.viewModel

class TopStoriesFragment : Fragment() {
    private lateinit var binding: TopStoriesFragmentBinding
    private val viewModel: TopStoriesViewModel by viewModel()
   private lateinit var topStoriesAdapter: TopStoriesAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.top_stories_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fetchTopStories()
        initRV()
        // TODO: Use the ViewModel
    }
    private fun initRV() {
        topStoriesAdapter = TopStoriesAdapter{topStoriesResult:TopStoriesResponse.TopStoriesResult -> toDetailFragment(topStoriesResult)  }
        binding.rvTopStories.apply {
            adapter = topStoriesAdapter
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        }
    }
    private fun toDetailFragment(postResult: TopStoriesResponse.TopStoriesResult) {
        val bundle = Bundle().apply {
            putParcelable("post_id",postResult)
        }
        findNavController().navigate(
            R.id.action_topStoriesFragment_to_detailFragment,
            bundle
        )
    }
    private fun fetchTopStories() {
        viewModel.topStories.observe(viewLifecycleOwner, { response ->
            when (response) {
                is Resources.Success -> {
                    response.data?.let { result ->
                       topStoriesAdapter.submitList(result.topStoriesResults)
                    }
                }
                is Resources.Error -> {
                    response.message?.let { message ->
                       // hideView()
                        Toast.makeText(activity, "An error: $message", Toast.LENGTH_SHORT).show()
                        Log.i("TAG", "Message error === $message")
                    }
                }
                is Resources.Loading -> {
           /*         hideView()
                    showProgressBar()*/
                }
            }
        })
    }
    /* fun initView() {
         //topStoriesAdapter.stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY
         binding.rvTopStories.adapter = topStoriesAdapter
         binding.rvTopStories.adapter = topStoriesAdapter.withLoadStateHeaderAndFooter(
             header = TopStoriesLoadingAdapter { topStoriesAdapter.retry() },
             footer = TopStoriesLoadingAdapter { topStoriesAdapter.retry() }
         )
     }*/
}