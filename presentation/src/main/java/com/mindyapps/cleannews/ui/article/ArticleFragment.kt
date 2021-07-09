package com.mindyapps.cleannews.ui.article

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.mindyapps.cleannews.R
import com.mindyapps.cleannews.base.BaseFragment
import com.mindyapps.cleannews.databinding.FragmentArticleBinding
import com.mindyapps.cleannews.databinding.FragmentNewsBinding
import com.mindyapps.domain.entity.ArticleEntity
import java.lang.Exception


class ArticleFragment : BaseFragment() {

    private var _binding: FragmentArticleBinding? = null
    private val binding get() = _binding!!
    private val args: ArticleFragmentArgs by navArgs()

    private lateinit var articleEntity: ArticleEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        articleEntity = args.article
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentArticleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        articleEntity.title?.let { setActionBarData(it, true) }
        setArticleData()
    }

    private fun setArticleData() {
        binding.articleTitle.text = articleEntity.title
        binding.articleAuthor.text = articleEntity.author
        binding.articleContent.text = articleEntity.content
    }

}