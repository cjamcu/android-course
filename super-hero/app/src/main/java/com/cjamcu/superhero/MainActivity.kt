package com.cjamcu.superhero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.graphics.drawable.toBitmap
import com.cjamcu.superhero.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var heroImage: ImageView

    private val getContent = registerForActivityResult(ActivityResultContracts.TakePicturePreview()) { bitmap ->
        heroImage.setImageBitmap(bitmap)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        heroImage = binding.heroImage
        binding.heroImage.setOnClickListener {
         openCamera()
        }

        binding.saveButton.setOnClickListener {
            val superHeroName = binding.heroNameEdit.text.toString()
            val alterEgo = binding.heroAlterEgoEdit.text.toString()
            val bio = binding.heroBioEdit.text.toString()
            val power = binding.ratingBar.rating

            val superHero = SuperHero(superHeroName, alterEgo, bio, power)
            openDetailActivity(superHero)
        }
    }

    private fun openCamera() {
        getContent.launch(null)
    }

    private fun openDetailActivity( superHero: SuperHero) {
        val intent =  Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.SUPER_HERO_KEY, superHero)
        intent.putExtra(DetailActivity.BITMAP_KEY, heroImage.drawable.toBitmap())

        startActivity(intent)
    }

}

