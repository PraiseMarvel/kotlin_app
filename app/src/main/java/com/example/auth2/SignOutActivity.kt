package com.example.auth2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.auth2.databinding.ActivitySignOutBinding
import com.google.firebase.auth.FirebaseAuth


class SignOutActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignOutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_out)
        binding = ActivitySignOutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
    }
}