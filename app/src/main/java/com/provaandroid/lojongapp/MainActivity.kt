package com.provaandroid.lojongapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.provaandroid.lojongapp.databinding.ActivityMainBinding
import com.provaandroid.lojongapp.presentation.viewmodel.LojongViewModel
import com.provaandroid.lojongapp.presentation.viewmodel.LojongViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: LojongViewModelFactory
    lateinit var viewModel: LojongViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this,factory)
            .get(LojongViewModel::class.java)

    }
}


