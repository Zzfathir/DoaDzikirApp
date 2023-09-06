package com.fathirdev.doadzikirapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.viewpager2.widget.ViewPager2
import com.fathirdev.doadzikirapp.adapter.ArtikelAdapter
import com.fathirdev.doadzikirapp.model.Artikel
import com.fathirdev.doadzikirapp.presentation.HarianDzikirDoaActivity
import com.fathirdev.doadzikirapp.presentation.QauliyahSholatActivity
import com.fathirdev.doadzikirapp.presentation.SetiapSaatDzikirActivity
import com.fathirdev.doadzikirapp.presentation.pagipetang.PagiPetangDzikirActivity
import com.google.android.material.card.MaterialCardView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var dotSlider: Array<ImageView?>

    private val listArtikel: ArrayList<Artikel> = arrayListOf()

    private val slidingCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            for (i in 0 until listArtikel.size) {
                dotSlider[i]?.setImageDrawable(
                    ContextCompat.getDrawable(applicationContext, R.drawable.dot_inactive)
                )
            }

            dotSlider[position]?.setImageDrawable(
                ContextCompat.getDrawable(applicationContext, R.drawable.dot_active)
            )

        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_main)

        val cardQauliyahSholat: MaterialCardView = findViewById(R.id.card_qauliyah)
        val cardDzikir = findViewById<MaterialCardView>(R.id.card_dzikir)
        val cardDzikirHarian = findViewById<MaterialCardView>(R.id.card_dzikir_harian)
        val cardPagiPetang = findViewById<MaterialCardView>(R.id.card_pagi_petang)

        initData()

        cardDzikir.setOnClickListener(this)
        cardDzikirHarian.setOnClickListener(this)
        cardPagiPetang.setOnClickListener(this)
        cardQauliyahSholat.setOnClickListener {
            val intent = Intent(this, QauliyahSholatActivity::class.java)
            startActivity(intent)
        }
        val vpArtikel: ViewPager2 = findViewById(R.id.vp_artikel)
        vpArtikel.adapter = ArtikelAdapter(listArtikel)
        vpArtikel.registerOnPageChangeCallback(slidingCallback)

        setupViewPager()




    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.card_dzikir -> startActivity(Intent(this, SetiapSaatDzikirActivity::class.java))
            R.id.card_dzikir_harian -> startActivity(Intent(this, HarianDzikirDoaActivity::class.java))
            R.id.card_pagi_petang -> startActivity(Intent(this, PagiPetangDzikirActivity::class.java))

        }
    }


    private fun initData() {
        val titleArtikel = resources.getStringArray(R.array.arr_title_artikel)
        val descArtikel = resources.getStringArray(R.array.arr_desc_artikel)
        val imgArtikel = resources.obtainTypedArray(R.array.arr_img_artikel)

        for (i in titleArtikel.indices) {
            val data =  Artikel(
                titleArtikel[i],
                descArtikel[i],
                imgArtikel.getResourceId(i, 0)
            )
            listArtikel.add(data)
        }
        imgArtikel.recycle()
    }

    private fun setupViewPager() {
        val llSliderDots: LinearLayout = findViewById(R.id.ll_slider_dots)

        dotSlider = arrayOfNulls(listArtikel.size)

        for (i in 0 until listArtikel.size) {
            dotSlider[i] = ImageView(this)
            dotSlider[i]?.setImageDrawable(
                ContextCompat.getDrawable(applicationContext, R.drawable.dot_inactive)
            )

            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(9, 0, 8, 0)
            params.gravity = Gravity.CENTER_VERTICAL

            llSliderDots.addView(dotSlider[i], params)
        }

        dotSlider[0]?.setImageDrawable(
            ContextCompat.getDrawable(applicationContext, R.drawable.dot_active)
        )

    }
}