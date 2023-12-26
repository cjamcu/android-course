package com.cjamcu.superhero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cjamcu.superhero.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    companion object {
        const val SUPER_HERO_KEY = "superHero"

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras!!

        val superHero = bundle.getParcelable<SuperHero>(SUPER_HERO_KEY)!!

        binding.heroName.text = superHero.name
        binding.alterEgoText.text =  superHero.alterEgo
        binding.bioText.text =  superHero.bio
        binding.ratingBar.rating = superHero.power



    }
}