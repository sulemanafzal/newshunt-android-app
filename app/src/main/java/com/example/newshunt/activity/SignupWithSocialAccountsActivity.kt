package com.example.newshunt.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newshunt.databinding.ActivitySignupWithSocialAccountsBinding

class SignupWithSocialAccountsActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupWithSocialAccountsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupWithSocialAccountsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignupemail.setOnClickListener {
            val intent = Intent(this, SignInWithEmailActivity::class.java)
            startActivity(intent)
        }
}
}