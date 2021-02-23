package com.example.newsappmvvm.ui.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.newsappmvvm.MainActivity
import com.example.newsappmvvm.ui.fragments.EverythingFragment
import com.example.newsappmvvm.ui.fragments.HeadLineFragment
import com.example.newsappmvvm.ui.fragments.SourceFragment

class NewsViewPagerAdapter(mainActivity: MainActivity) : FragmentStateAdapter(mainActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> {
                return HeadLineFragment()
            }
            1 -> {
                return SourceFragment()
            }
            2 -> {
                return EverythingFragment()
            }

        }
        return HeadLineFragment()

    }

}