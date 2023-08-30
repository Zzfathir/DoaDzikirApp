package com.fathirdev.doadzikirapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.fathirdev.doadzikirapp.presentation.HarianDzikirDoaActivity
import com.fathirdev.doadzikirapp.presentation.QauliyahSholatActivity
import com.fathirdev.doadzikirapp.presentation.SetiapSaatDzikirActivity
import com.fathirdev.doadzikirapp.presentation.pagipetang.PagiPetangDzikirActivity
import com.google.android.material.card.MaterialCardView

class MainActivity : AppCompatActivity(), View.OnClickListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_main)

        val cardQauliyahSholat: MaterialCardView = findViewById(R.id.card_qauliyah)
        val cardDzikir = findViewById<MaterialCardView>(R.id.card_dzikir)
        val cardDzikirHarian = findViewById<MaterialCardView>(R.id.card_dzikir_harian)
        val cardPagiPetang = findViewById<MaterialCardView>(R.id.card_pagi_petang)

        cardDzikir.setOnClickListener(this)
        cardDzikirHarian.setOnClickListener(this)
        cardPagiPetang.setOnClickListener(this)



        cardQauliyahSholat.setOnClickListener {
            val intent = Intent(this, QauliyahSholatActivity::class.java)
            startActivity(intent)
        }


    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.card_dzikir -> startActivity(Intent(this, SetiapSaatDzikirActivity::class.java))
            R.id.card_dzikir_harian -> startActivity(Intent(this, HarianDzikirDoaActivity::class.java))
            R.id.card_pagi_petang -> startActivity(Intent(this, PagiPetangDzikirActivity::class.java))

        }
    }
}