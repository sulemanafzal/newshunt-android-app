package com.example.newshunt.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import com.example.newshunt.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etUserName.isEnabled = false
        binding.etUseremial.isEnabled = false
        binding.etUsernumber.isEnabled = false
        binding.etUserpassword.isEnabled = false

        binding.tvUserName.setOnClickListener {
            enableEditTextAndShowCursor(
                binding.etUserName,
                binding.tvUserName
            )
        }

        binding.tvUseremial.setOnClickListener {
            enableEditTextAndShowCursor(
                binding.etUseremial,
                binding.tvUseremial
            )
        }

        binding.tvUserpassword.setOnClickListener {
            enableEditTextAndShowCursor(
                binding.etUserpassword,
                binding.tvUserpassword
            )
        }

        binding.tvUsernumber.setOnClickListener {
            enableEditTextAndShowCursor(
                binding.etUsernumber,
                binding.tvUsernumber
            )
        }

        binding.btnSave.setOnClickListener {
            // Show the "Edit" TextViews again
            binding.tvUserName.visibility = View.VISIBLE
            binding.tvUseremial.visibility = View.VISIBLE
            binding.tvUserpassword.visibility = View.VISIBLE
            binding.tvUsernumber.visibility = View.VISIBLE
        }
    }

    private fun enableEditTextAndShowCursor(editText: EditText, textView: TextView) {
        editText.isEnabled = true
        editText.isFocusableInTouchMode = true
        editText.requestFocus()

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT)

        editText.setSelection(editText.text.length)
        textView.visibility = View.GONE
    }
}