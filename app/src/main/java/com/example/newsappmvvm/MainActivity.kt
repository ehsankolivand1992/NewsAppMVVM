package com.example.newsappmvvm

import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.newsappmvvm.data.models.local.relations.ArticleAndNews
import com.example.newsappmvvm.databinding.ActivityMainBinding
import com.example.newsappmvvm.ui.adapters.NewsViewPagerAdapter
import com.example.newsappmvvm.ui.viewModels.listinnerStructure.MainView
import com.example.newsappmvvm.ui.viewModels.MainViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), MainView {
    lateinit var mainBinding: ActivityMainBinding

    lateinit var adapter:NewsViewPagerAdapter
    @Inject
    lateinit var mainViewModel: MainViewModel


    override  fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)
        mainViewModel.setView(this)
        adapter = NewsViewPagerAdapter(this)

        with(mainBinding)
        {
            viewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
            viewpager.adapter = adapter
        }


    }

    override fun getTargetName(): String {
        return "main"
    }

    override fun setRecyclerViewData(news: ArticleAndNews) {

    }

    override fun showProgressDialog() {
        TODO("Not yet implemented")
    }

    override fun dismissProgressDialog() {
        TODO("Not yet implemented")
    }

    override fun refreshRecyclerView() {
        TODO("Not yet implemented")
    }

}