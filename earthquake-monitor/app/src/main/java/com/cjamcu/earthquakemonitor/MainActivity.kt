package com.cjamcu.earthquakemonitor

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cjamcu.earthquakemonitor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val adapter = EqAdapter()
        binding.recyclerView.adapter = adapter

        viewModel.eqList.observe(this) {
            adapter.submitList(it)
            handleEmptyState(it)
        }

        adapter.onItemClickListener = {
            Toast.makeText(this, it.place, Toast.LENGTH_SHORT).show()
        }

    }

    private fun handleEmptyState(it: MutableList<Earthquake>) {
        if (it.isEmpty()) {
            binding.eqEmptyView.visibility = View.VISIBLE
        } else {
            binding.eqEmptyView.visibility = View.GONE
        }
    }
}