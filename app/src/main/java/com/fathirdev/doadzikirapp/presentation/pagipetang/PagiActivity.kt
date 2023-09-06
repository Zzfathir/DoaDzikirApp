package com.fathirdev.doadzikirapp.presentation.pagipetang

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.fathirdev.doadzikirapp.adapter.DoaDzikirAdapter
import com.fathirdev.doadzikirapp.R
import com.fathirdev.doadzikirapp.databinding.ActivityPagiBinding
import com.fathirdev.doadzikirapp.model.DataDoaDzikir

class PagiActivity : AppCompatActivity() {

    private var _binding: ActivityPagiBinding? = null
    private val binding get() = _binding as ActivityPagiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = resources.getString(R.string.txt_dzikir_pagi)
        actionBar?.setDisplayHomeAsUpEnabled(true)
        _binding = ActivityPagiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvDzikirPagi.adapter = DoaDzikirAdapter(DataDoaDzikir.listDzikirPagi)
        binding.rvDzikirPagi.layoutManager = LinearLayoutManager(applicationContext)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }
}