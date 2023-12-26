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

            val superHero = SuperHero(superHeroName, alterEgo, bio, power)
            openDetailActivity(superHero)
        }
    }

    private fun openDetailActivity( superHero: SuperHero) {
        val intent =  Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.SUPER_HERO_KEY, superHero)

        startActivity(intent)
    }
}

