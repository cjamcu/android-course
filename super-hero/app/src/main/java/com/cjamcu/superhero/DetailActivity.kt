package com.cjamcu.superhero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cjamcu.superhero.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    companion object {
        const val SUPER_HERO_KEY = "superHero"
        const val BITMAP_KEY = "bitmap"


    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras!!
        binding.heroImage.setImageBitmap(bundle.getParcelable(BITMAP_KEY))
        binding.superHero = bundle.getParcelable<SuperHero>(SUPER_HERO_KEY)!!

    }
}