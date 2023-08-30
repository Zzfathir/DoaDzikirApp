package com.fathirdev.doadzikirapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.fathirdev.doadzikirapp.DoaDzikirAdapter
import com.fathirdev.doadzikirapp.databinding.ActivityQauliyahSholatBinding
import com.fathirdev.doadzikirapp.model.DataDoaDzikir

class QauliyahSholatActivity : AppCompatActivity() {

    private var _binding: ActivityQauliyahSholatBinding? = null
    private val binding get() = _binding as ActivityQauliyahSholatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityQauliyahSholatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvQauliyahShalat.adapter = DoaDzikirAdapter(DataDoaDzikir.listQauliyah)
        binding.rvQauliyahShalat.layoutManager = LinearLayoutManager(this)
    }
}