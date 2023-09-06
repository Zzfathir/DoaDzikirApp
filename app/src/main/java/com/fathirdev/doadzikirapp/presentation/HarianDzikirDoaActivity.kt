package com.fathirdev.doadzikirapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.fathirdev.doadzikirapp.adapter.DoaDzikirAdapter
import com.fathirdev.doadzikirapp.databinding.ActivityHarianDzikirDoaBinding
import com.fathirdev.doadzikirapp.R
import com.fathirdev.doadzikirapp.model.DzikirDoa

class HarianDzikirDoaActivity : AppCompatActivity() {
    private var _binding: ActivityHarianDzikirDoaBinding? = null
    private val listDzikir: ArrayList<DzikirDoa> = arrayListOf()
    private val binding get() = _binding as ActivityHarianDzikirDoaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        _binding = ActivityHarianDzikirDoaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        providingDzikirDatas()
        initView()


    }

    private fun providingDzikirDatas() {
        val titleDzikir = resources.getStringArray(R.array.arr_dzikir_doa_harian)
        val arabicDzikir = resources.getStringArray(R.array.arr_lafaz_dzikir_doa_harian)
        val translateDzikir = resources.getStringArray(R.array.arr_terjemah_dzikir_doa_harian)

        for (i in titleDzikir.indices) {
            val dzikir = DzikirDoa(
                titleDzikir[i],
                arabicDzikir[i],
                translateDzikir[i]
            )
            listDzikir.add(dzikir)
        }

    }
    private fun initView() {
        binding.rvDzikirDoaHarian.apply {
            adapter = DoaDzikirAdapter(listDzikir)
            layoutManager = LinearLayoutManager(this@HarianDzikirDoaActivity)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        finish()
        return super.onSupportNavigateUp()
    }
}