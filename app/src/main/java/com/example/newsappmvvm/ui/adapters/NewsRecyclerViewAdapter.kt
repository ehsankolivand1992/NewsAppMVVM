package com.example.newsappmvvm.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsappmvvm.data.models.local.ModelArticle
import com.example.newsappmvvm.databinding.NewsItemsBinding
import com.squareup.picasso.Picasso


class NewsRecyclerViewAdapter constructor(var newsList:List<ModelArticle>) :
    RecyclerView.Adapter<NewsRecyclerViewAdapter.NewsAdapterViewHolder>() {






    inner class NewsAdapterViewHolder( val item: NewsItemsBinding)
        :RecyclerView.ViewHolder(item.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapterViewHolder {
        val binding = NewsItemsBinding
            .inflate(LayoutInflater.from(parent.context),
                parent,false)

        return NewsAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsAdapterViewHolder, position: Int) {
        with(holder.item)
        {
            with(newsList[position])
            {
              txtTitle.text = this.title
                dateTxt.text = this.publishedAt
                Picasso.get()
                    .load(this.urlToImage)
                    .resize(400,400)
                    .into(imgArt);
            }
        }
    }

    override fun getItemCount() = newsList.size


}