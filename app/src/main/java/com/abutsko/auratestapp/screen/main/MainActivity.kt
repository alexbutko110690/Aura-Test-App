package com.abutsko.auratestapp.screen.main

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.abutsko.auratestapp.R
import com.abutsko.auratestapp.databinding.ActivityMainBinding
import com.abutsko.auratestapp.screen.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<MainViewModel>() {

    private lateinit var binding: ActivityMainBinding
    override val viewModel: MainViewModel by viewModel()
    private lateinit var bootAdapter: BootAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        this.binding = binding
        setContentView(binding.root)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initViews()
        initObservers()
    }

    private fun initViews() {
        bootAdapter = BootAdapter(this)
        binding.rvBoot.adapter = bootAdapter
    }

    private fun initObservers() {
        with(viewModel) {
            bootListLoaded.observe(this@MainActivity) { items ->
                binding.rvBoot.isVisible = items.isNotEmpty()
                binding.tvPlaceholder.isVisible = items.isEmpty()

                bootAdapter.setItems(items)
            }
        }
    }
}