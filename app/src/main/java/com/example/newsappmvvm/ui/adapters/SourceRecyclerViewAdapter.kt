package com.example.newsappmvvm.ui.adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsappmvvm.data.models.local.ModelSourceX
import com.example.newsappmvvm.databinding.SourcesItemsBinding

class SourceRecyclerViewAdapter constructor(
    var sourceList: List<ModelSourceX>,
    val context: Context
) : RecyclerView.Adapter<SourceRecyclerViewAdapter.SourceRecyclerViewAdapterViewHolder>() {
    inner class SourceRecyclerViewAdapterViewHolder(val item: SourcesItemsBinding) :
        RecyclerView.ViewHolder(item.root)

    override fun getItemCount(): Int {
        return sourceList.size
    }

    override fun onBindViewHolder(holder: SourceRecyclerViewAdapterViewHolder, position: Int) {

        val source = sourceList[position]
        with(holder.item)
        {
            txtCategory.text = source.category
            txtCountry.text = source.country
            txtLanguage.text = source.language
            txtName.text = source.name
            btnUrl.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(source.url))
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK;
                context.startActivity(intent)
            }
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SourceRecyclerViewAdapterViewHolder {
        val binding =
            SourcesItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return SourceRecyclerViewAdapterViewHolder(binding)
    }
}