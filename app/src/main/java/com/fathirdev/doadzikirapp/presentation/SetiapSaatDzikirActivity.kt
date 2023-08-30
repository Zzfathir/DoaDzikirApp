package com.fathirdev.doadzikirapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.fathirdev.doadzikirapp.DoaDzikirAdapter
import com.fathirdev.doadzikirapp.R
import com.fathirdev.doadzikirapp.databinding.ActivityQauliyahSholatBinding
import com.fathirdev.doadzikirapp.databinding.ActivitySetiapSaatDzikirBinding
import com.fathirdev.doadzikirapp.model.DataDoaDzikir

class SetiapSaatDzikirActivity : AppCompatActivity() {

    private var _binding: ActivitySetiapSaatDzikirBinding? = null
    private val binding get() = _binding as ActivitySetiapSaatDzikirBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySetiapSaatDzikirBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvDzikirSetiapSaat.adapter = DoaDzikirAdapter(DataDoaDzikir.listDzikir)
        binding.rvDzikirSetiapSaat.layoutManager = LinearLayoutManager(this)
    }
}