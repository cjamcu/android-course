package com.cjamcu.basketballscore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.cjamcu.basketballscore.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.mainViewModel = viewModel

        viewModel.localScore.observe(this) {
            binding.localScoreText.text = it.toString()
        }

        viewModel.visitorScore.observe(this) {
            binding.visitorScoreText.text = it.toString()
        }





    }
}