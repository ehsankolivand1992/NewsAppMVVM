package com.example.newsappmvvm.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsappmvvm.data.models.local.ModelSourceX
import com.example.newsappmvvm.databinding.FragmentSourceBinding
import com.example.newsappmvvm.ui.adapters.SourceRecyclerViewAdapter
import com.example.newsappmvvm.ui.viewModels.SourceViewModel
import com.example.newsappmvvm.ui.viewModels.listinnerStructure.FragSource
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class SourceFragment : DaggerFragment(),FragSource {


    private var _binding: FragmentSourceBinding?=null

    private val binding get() = _binding!!
    @Inject
    lateinit var mainViewModel: SourceViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSourceBinding.inflate(inflater, container, false)
        mainViewModel.setView(this)

        mainViewModel.setRecyclerView()

        return binding.root
    }


    override fun setData(allNews: List<ModelSourceX>) {

        activity?.runOnUiThread {
            val sourceAdapter = SourceRecyclerViewAdapter(allNews, requireActivity().applicationContext)
            binding.rvSources.adapter = sourceAdapter
            binding.rvSources.layoutManager = LinearLayoutManager(activity)
        }
    }

    override fun getText(): String {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}