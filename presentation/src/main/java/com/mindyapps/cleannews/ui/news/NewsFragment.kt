package com.mindyapps.cleannews.ui.news

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mindyapps.cleannews.R
import com.mindyapps.cleannews.base.BaseFragment
import com.mindyapps.cleannews.databinding.FragmentNewsBinding
import com.mindyapps.cleannews.ui.news.adapter.NewsAdapter
import com.mindyapps.cleannews.utils.state.State
import com.mindyapps.domain.entity.ArticleEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
class NewsFragment : BaseFragment() {

    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: NewsAdapter

    private val viewModel: NewsViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setActionBarData(getString(R.string.news), true)
        initAdapter()
        observeStates()
    }

    private fun observeStates() {
        lifecycleScope.launch {
            viewModel.newsState.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED).collect { state ->
                    when (state) {
                        is State.Default -> {
                        }
                        is State.Loading -> {
                            binding.progress.root.visibility = View.VISIBLE
                        }
                        is State.Success -> {
                            binding.progress.root.visibility = View.GONE
                            adapter.updateData(state.data.articles)
                        }
                        is State.Error -> {
                            binding.progress.root.visibility = View.GONE
                            handleError(state) { viewModel.getNews() }
                        }
                    }
                }
        }
    }

    private fun initAdapter() {
        adapter = NewsAdapter(mutableListOf()) { article ->
            onGoToArticle(article)
        }
        binding.rvNews.layoutManager = LinearLayoutManager(requireContext())
        binding.rvNews.adapter = adapter
    }

    private fun onGoToArticle(articleEntity: ArticleEntity) {
        val action = NewsFragmentDirections.actionToNewsFragment(articleEntity)
        findNavController().navigate(action)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}