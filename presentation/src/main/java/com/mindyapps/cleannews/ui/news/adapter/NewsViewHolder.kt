package com.mindyapps.cleannews.ui.news.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.mindyapps.cleannews.databinding.ItemArticleBinding
import com.mindyapps.domain.entity.ArticleEntity

class NewsViewHolder(private val itemBinding: ItemArticleBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(articleEntity: ArticleEntity, onClickListener: (ArticleEntity) -> Unit) {
        itemBinding.tvTitle.text = articleEntity.title
        itemBinding.tvAuthor.text = articleEntity.author
        itemBinding.root.setOnClickListener { onClickListener(articleEntity) }
    }
}