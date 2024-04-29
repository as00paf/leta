package com.demo.leta

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.demo.leta.viewModels.MainActivityViewModel
import androidx.activity.viewModels
import com.demo.leta.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupUI()
        viewModel.loadData()
    }

    private fun setupUI() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        setContentView(binding.root)
    }
}