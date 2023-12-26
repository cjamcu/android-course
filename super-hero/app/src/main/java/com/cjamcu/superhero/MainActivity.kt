package com.cjamcu.superhero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cjamcu.superhero.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveButton.setOnClickListener {
            val superHeroName = binding.heroNameEdit.text.toString()
            val alterEgo = binding.heroAlterEgoEdit.text.toString()
            val bio = binding.heroBioEdit.text.toString()
            val power = binding.ratingBar.rating



            openDetailActivity(superHeroName, alterEgo, bio, power)
        }
    }

    private fun openDetailActivity( superHeroName: String, alterEgo: String, bio: String, power: Float) {
        val intent =  Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.SUPER_HERO_NAME_KEY, superHeroName)
        intent.putExtra(DetailActivity.ALTER_EGO_KEY, alterEgo)
        intent.putExtra(DetailActivity.BIO_KEY, bio)
        intent.putExtra(DetailActivity.POWER_KEY, power)
        startActivity(intent)
    }
}

