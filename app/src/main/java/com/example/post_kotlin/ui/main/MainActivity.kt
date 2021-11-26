package com.example.post_kotlin.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.post_kotlin.R
import com.example.post_kotlin.databinding.ActivityMainBinding
import com.example.post_kotlin.recyclerViev.PostAdapter
import com.example.post_kotlin.repazitori.Repazitori

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainVievModel: MainVievModel
    private  val adapter by lazy { PostAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecycler()
        setUpVievModel()
        getData()
    }

    private fun initRecycler() {
        binding.recViev.layoutManager = LinearLayoutManager(applicationContext)
    }

    private fun getData() {
        mainVievModel.getPosts()
        mainVievModel.myResponse.observe(this, Observer {
       adapter.setData( it)
            binding.recViev.adapter = adapter


        })
    }

    private fun setUpVievModel() {
        val repazitori = Repazitori()
        val mainVievModelProvider = MainVievModelProvider(repazitori)
        mainVievModel = ViewModelProvider(this,mainVievModelProvider).get(MainVievModel::class.java)

    }
}