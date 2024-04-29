package com.demo.leta

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.demo.leta.viewModels.MainActivityViewModel
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.loadData()
    }
}