package com.example.newsappmvvm.deleted

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.newsappmvvm.MainActivity
import com.example.newsappmvvm.ui.fragments.HeadLineFragment
import com.example.newsappmvvm.ui.fragments.SourceFragment
import com.example.newsappmvvm.ui.fragments.EverythingFragment

class ViewPagerAdapter(main: MainActivity) : FragmentStateAdapter(main) {


    override fun getItemCount(): Int {
       return 3
    }

    override fun createFragment(position: Int): Fragment {
      when (position)
      {
          0-> {
              return HeadLineFragment()
          }
          1-> {
              return  SourceFragment()
          }

          2 -> {
              return  EverythingFragment()
          }
      }

        return HeadLineFragment()
    }

}