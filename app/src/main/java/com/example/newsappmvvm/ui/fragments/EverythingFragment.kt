package com.example.newsappmvvm.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsappmvvm.data.models.local.ModelArticle
import com.example.newsappmvvm.databinding.FragmentEverythingBinding
import com.example.newsappmvvm.ui.adapters.NewsRecyclerViewAdapter
import com.example.newsappmvvm.ui.viewModels.EverythingViewModel
import com.example.newsappmvvm.ui.viewModels.listinnerStructure.FragView
import dagger.android.support.DaggerFragment
import io.reactivex.BackpressureStrategy
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class EverythingFragment : DaggerFragment(), FragView {
    private lateinit var adapter: NewsRecyclerViewAdapter
    private var _binding: FragmentEverythingBinding? = null
    private val binding get() = _binding!!
    private val _textInput = BehaviorSubject.create<String>()
    private val textInput = _textInput.toFlowable(BackpressureStrategy.LATEST)
    private val disposable = CompositeDisposable()


    @Inject
    lateinit var mainViewModel: EverythingViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEverythingBinding.inflate(inflater, container, false)
        mainViewModel.setView(this)

        binding.etSearch.doAfterTextChanged {

            _textInput.onNext("")
        }


        disposable.add(
            textInput
                .debounce(1000, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    mainViewModel.setRecyclerView()
                })




        return binding.root

    }


    override fun setData(allNews: List<ModelArticle>) {

        activity?.runOnUiThread {

            adapter = NewsRecyclerViewAdapter(allNews)
            binding.rvEverything.adapter = adapter
            binding.rvEverything.layoutManager = LinearLayoutManager(activity)

        }
    }

    override fun getText(): String {
        return binding.etSearch.text.toString()
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}