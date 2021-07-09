package com.mindyapps.cleannews.ui.news.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mindyapps.cleannews.databinding.ItemArticleBinding
import com.mindyapps.domain.entity.ArticleEntity

class NewsAdapter(
    private val list: MutableList<ArticleEntity>,
    private val onClickListener: (ArticleEntity) -> Unit
) : RecyclerView.Adapter<NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):NewsViewHolder {
        val itemBinding =
            ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = list.size

    fun updateData(list: List<ArticleEntity>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(list[position], onClickListener)
    }
}