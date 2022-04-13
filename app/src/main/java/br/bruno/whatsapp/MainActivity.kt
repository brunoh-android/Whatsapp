package br.bruno.whatsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import br.bruno.whatsapp.adapters.ViewPagerAdapter
import br.bruno.whatsapp.fragments.Fragmento1
import br.bruno.whatsapp.fragments.Fragmento2
import br.bruno.whatsapp.fragments.Fragmento3
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.add(Fragmento1(),"Chats")
        adapter.add(Fragmento2(),"Camera")
        adapter.add(Fragmento3(),"Call")

        var viewPager = findViewById<ViewPager>(R.id.viewPagerID)
        viewPager.adapter = adapter

        var tabLayout = findViewById<TabLayout>(R.id.tablayout)
        tabLayout.setupWithViewPager(viewPager)
    }
}