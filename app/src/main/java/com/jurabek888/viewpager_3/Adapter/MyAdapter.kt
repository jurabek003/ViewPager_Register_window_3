package com.jurabek888.viewpager_3.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.jurabek888.viewpager_3.Madels.User
import com.jurabek888.viewpager_3.databinding.ItemViewPagerBinding

class MyAdapter(val list: ArrayList<User>):PagerAdapter() {
    override fun getCount(): Int =list.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view==`object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemViewPagerBinding=ItemViewPagerBinding.inflate(LayoutInflater.from(container.context),container,false)

        itemViewPagerBinding.itemImage.setImageResource(list[position].userimage)
        itemViewPagerBinding.itemText1.text=list[position].text_1
        itemViewPagerBinding.itemText2.text=list[position].text_2

        container.addView(itemViewPagerBinding.root)
        return itemViewPagerBinding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}