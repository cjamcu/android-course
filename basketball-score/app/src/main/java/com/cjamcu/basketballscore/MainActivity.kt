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

        viewModel.localScore.observe(this) {
            binding.localScoreText.text = it.toString()
        }

        viewModel.visitorScore.observe(this) {
            binding.visitorScoreText.text = it.toString()
        }


        // Minus local
        binding.localMinusButton.setOnClickListener {
            viewModel.minusPointsToScore(1, true)
        }

        binding.visitorMinusButton.setOnClickListener {
            viewModel.minusPointsToScore(1, false)
        }

        binding.localPlusButton.setOnClickListener {
            viewModel.addPointsToScore(1, true)
        }

        binding.localPlusTwoButton.setOnClickListener {
            viewModel.addPointsToScore(2, true)
        }

        binding.localPlusThreeButton.setOnClickListener {
            viewModel.addPointsToScore(3, true)
        }



        binding.visitorMinusButton.setOnClickListener {
            viewModel.minusPointsToScore(1, false)
        }

        binding.visitorPlusButton.setOnClickListener {
            viewModel.addPointsToScore(1, false)
        }


        binding.visitorPlusTwoButton.setOnClickListener {
            viewModel.addPointsToScore(2, false)
        }


        binding.visitorPlusThreeButton.setOnClickListener {
            viewModel.addPointsToScore(3, false)
        }



        binding.restartButton.setOnClickListener {
            viewModel.resetScore()
        }
    }
}