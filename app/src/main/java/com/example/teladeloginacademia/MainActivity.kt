package com.example.teladeloginacademia

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.example.teladeloginacademia.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportActionBar!!.hide()
        window.statusBarColor = Color.parseColor("#FFFFFF")

        binding.btEntrar.setOnClickListener {

            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()

            when{
                email.isEmpty() -> {
                    binding.editEmail.error = "Preencha o E-mail!"
                }
                senha.isEmpty() -> {
                    binding.editSenha.error = "Preencha a Senha!"
                }
                !email.contains("@gmail.com") -> {
                    val snackbar = Snackbar.make(it,"E-mail inválido!",Snackbar.LENGTH_SHORT)
                    snackbar.show()
                }
                senha.length <= 5 -> {
                    val snackbar = Snackbar.make(it,"A Senha precisa ter pelo menos 6 caracteres!",Snackbar.LENGTH_SHORT)
                    snackbar.show()
                }
                else -> {
                    login(it)
                }
            }
        }
    }
    private fun login(view: View){

        val progressbar = binding.progressBar
        progressbar.visibility = View.VISIBLE

        binding.btEntrar.isEnabled = false
        binding.btEntrar.setTextColor(Color.parseColor("#FFFFFF"))

        Handler(Looper.getMainLooper()).postDelayed({
            val snackbar = Snackbar.make(view,"Login efetuado em SUCESSO!",Snackbar.LENGTH_SHORT)
            snackbar.show()
        },3000)
    }

    private fun navegarTelaPrincipal(){
        val intent = Intent(this,TelaPrincipal::class.java)
        startActivity(intent)
        finish()
    }
}