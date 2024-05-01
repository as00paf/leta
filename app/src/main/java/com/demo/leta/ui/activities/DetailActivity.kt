package com.demo.leta.ui.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.demo.leta.AppConsts
import com.demo.leta.databinding.ActivityDetailBinding
import com.demo.leta.models.getArtistFromBundle
import com.demo.leta.viewModels.DetailActivityViewModel

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private val viewModel: DetailActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupUI()

        val artist = intent.extras?.getBundle(AppConsts.ARTIST)?.getArtistFromBundle()
        artist?.let{
            title = it.name
            viewModel.loadData(it)
        }
    }

    private fun setupUI() {
        binding = ActivityDetailBinding.inflate(layoutInflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        setContentView(binding.root)
    }
}