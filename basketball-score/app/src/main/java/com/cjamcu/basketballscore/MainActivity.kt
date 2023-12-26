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

        val localScoreText = binding.localScoreText
        val visitorScoreText = binding.visitorScoreText
        binding.localMinusButton.setOnClickListener {
            viewModel.minusPointsToScore(1, true)
            localScoreText.text = viewModel.localScore.toString()

        }

        binding.localPlusButton.setOnClickListener {
            viewModel.addPointsToScore(1, true)
            localScoreText.text = viewModel.localScore.toString()
        }

        binding.visitorMinusButton.setOnClickListener {
            viewModel.minusPointsToScore(1, false)
            visitorScoreText.text = viewModel.visitorScore.toString()

        }

        binding.visitorPlusButton.setOnClickListener {
            viewModel.addPointsToScore(1, false)
            visitorScoreText.text = viewModel.visitorScore.toString()
        }

        binding.restartButton.setOnClickListener {
            viewModel.resetScore()
            localScoreText.text = viewModel.localScore.toString()
            visitorScoreText.text = viewModel.visitorScore.toString()
        }
    }
}