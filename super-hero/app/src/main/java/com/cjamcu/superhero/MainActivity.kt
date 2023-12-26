package com.cjamcu.superhero

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import com.cjamcu.superhero.databinding.ActivityMainBinding
import java.io.File

class MainActivity : AppCompatActivity() {

    private lateinit var heroImage: ImageView

    private var picturePath = ""
    private val getPhoto = registerForActivityResult(ActivityResultContracts.TakePicture()) { success ->

        if (success && picturePath.isNotEmpty()) {
            heroImage.setImageBitmap(BitmapFactory.decodeFile(picturePath))
        }
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

            val superHero = SuperHero(superHeroName, alterEgo, bio, power,picturePath)
            openDetailActivity(superHero)
        }
    }

    private fun openCamera() {
        val file =  createImageFile()
        picturePath = file.absolutePath

        val uri =
            FileProvider.getUriForFile(this, "$packageName.fileprovider", file)

        getPhoto.launch(uri)

    }

    private fun createImageFile(): File {
        val fileName = "heroImage"
        val storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(fileName, ".jpg", storageDir)
    }

    private fun openDetailActivity( superHero: SuperHero) {
        val intent =  Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.SUPER_HERO_KEY, superHero)
        startActivity(intent)
    }

}

