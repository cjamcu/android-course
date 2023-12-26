package com.cjamcu.superhero

import android.graphics.BitmapFactory
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
        val  hero = bundle.getParcelable<SuperHero>(SUPER_HERO_KEY)!!
        val bitmap = BitmapFactory.decodeFile(hero.image)

        binding.heroImage.setImageBitmap(bitmap)

        binding.superHero = hero

    }
}