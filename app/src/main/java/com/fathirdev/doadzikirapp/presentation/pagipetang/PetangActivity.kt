package com.fathirdev.doadzikirapp.presentation.pagipetang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.fathirdev.doadzikirapp.adapter.DoaDzikirAdapter
import com.fathirdev.doadzikirapp.R
import com.fathirdev.doadzikirapp.databinding.ActivityPetangBinding
import com.fathirdev.doadzikirapp.model.DataDoaDzikir

class PetangActivity : AppCompatActivity() {

    private var _binding: ActivityPetangBinding? = null
    private val binding get() = _binding as ActivityPetangBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = resources.getString(R.string.txt_dzikir_petang)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding = ActivityPetangBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvDzikirPetang.adapter = DoaDzikirAdapter(DataDoaDzikir.listDzikirPetang)
        binding.rvDzikirPetang.layoutManager = LinearLayoutManager(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }
}