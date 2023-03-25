package com.example.aula5_intents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aula5_intents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
     lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        val name = intent.getStringExtra(EXTRA_NAME)
        name?.let { binding.textWelcolme.text = it }

        binding.buttonGo.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
            finish()
        }

        binding.buttonPhone.setOnClickListener {
            startActivity(Intent(Intent.ACTION_DIAL))
        }

        binding.buttonPhoneNumber.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:0123456789")
            startActivity(intent)
        }

    }
}

