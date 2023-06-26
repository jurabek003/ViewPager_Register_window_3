package com.jurabek888.viewpager_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.tabs.TabLayout
import com.jurabek888.viewpager_3.Adapter.MyAdapter
import com.jurabek888.viewpager_3.Madels.User
import com.jurabek888.viewpager_3.databinding.ActivityMainBinding
import com.jurabek888.viewpager_3.databinding.ItemTabLayout2Binding
import com.jurabek888.viewpager_3.databinding.ItemTabLayoutBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var list:ArrayList<User>
    private lateinit var myAdapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    loaddata()
        binding.button1.setOnClickListener {
            val current= binding.myViewPager.currentItem
            if (current < myAdapter.count-1){
                binding.myViewPager.currentItem = current+1
            }
        }
        myAdapter= MyAdapter(list)
        binding.myViewPager.adapter=myAdapter
        binding.myTabLayout.setupWithViewPager(binding.myViewPager)
        var tabcount= binding.myTabLayout.tabCount
                for (i in 0 until tabcount){
            val itemTabLayoutBinding=ItemTabLayoutBinding.inflate(layoutInflater)
            val itemTabLayout2Binding=ItemTabLayout2Binding.inflate(layoutInflater)
            val tab=binding.myTabLayout.getTabAt(i)
            val tab2=binding.myTabLayout.getTabAt(0)
            tab?.customView=itemTabLayout2Binding.root
            tab2?.customView=itemTabLayoutBinding.root
            if (i == 0){
                itemTabLayoutBinding.tabImage.visibility=View.VISIBLE
            }else{
                itemTabLayout2Binding.tabImage2.visibility=View.VISIBLE
            }
        }
        binding.myTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val itemTabLayoutBinding=ItemTabLayoutBinding.inflate(layoutInflater)
                itemTabLayoutBinding.tabImage.visibility=View.VISIBLE
                tab?.customView=itemTabLayoutBinding.root
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val itemTabLayout2Binding=ItemTabLayout2Binding.inflate(layoutInflater)
                itemTabLayout2Binding.tabImage2.visibility=View.VISIBLE
                tab?.customView=itemTabLayout2Binding.root
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }


        })

    }

    private fun loaddata() {
        list=ArrayList()
        list.add(User(" Geoaxborot","Geoaxborot moduli orqali siz o'zingizga yaqin bo'lgan migrantlar va boshqa muassasalar haqida ma'lumot olishingiz mumkin",R.drawable.img))
        list.add(User("Huquqiy axborot","Huquqiy axborot moduli orqali siz migratsiya sohasiga oid yangiliklardan, qonunlardan xabardor bo'lishingiz va online konsultatsiya olishingiz mumkin",R.drawable.rasm2))
        list.add(User(" To'lovlar xizmatlari","To'lov xizmatlari moduli orqali siz masofadan turib turli xil xizmatlarga to'lovlar haqida ma'lumot olishingiz va to'lovlarni amalga oshirishingiz mumkin",R.drawable.rasm3))
        list.add(User("Qo'shimcha imkoniyat","Qo'shimcha imkoniyatlar moduli orqali siz interaktiv so'zlashgichlar va lug'atlar yordamida til bilish savodxonligingizni oshirishingiz mumkin",R.drawable.rasm4))
    }
}