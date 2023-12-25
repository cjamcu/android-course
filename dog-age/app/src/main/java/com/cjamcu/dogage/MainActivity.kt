package com.cjamcu.dogage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.cjamcu.dogage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener {
            val age = binding.ageEdit.text.toString();

            if (age.isEmpty()) {
                Toast.makeText(this, R.string.must_insert_age, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val result = age.toInt() * 7
            binding.resultText.text = getString(R.string.result_format, result)

        }

    }
}