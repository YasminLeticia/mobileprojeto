package com.example.teladeloginacademia

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class TelaPrincipal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_principal)

        supportActionBar!!.hide()
        window.statusBarColor = Color.parseColor("#2E7E76")
    }
}