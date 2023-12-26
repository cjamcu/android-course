package com.cjamcu.earthquakemonitor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.cjamcu.earthquakemonitor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val eqList = mutableListOf<Earthquake>()


        val adapter = EqAdapter()
        binding.recyclerView.adapter = adapter
        adapter.submitList(eqList)

        adapter.onItemClickListener = {
           Toast.makeText(this, it.place, Toast.LENGTH_SHORT).show()
        }

        if(eqList.isEmpty()){
            binding.eqEmptyView.visibility = View.VISIBLE
        }else{
            binding.eqEmptyView.visibility = View.GONE
        }


    }
}