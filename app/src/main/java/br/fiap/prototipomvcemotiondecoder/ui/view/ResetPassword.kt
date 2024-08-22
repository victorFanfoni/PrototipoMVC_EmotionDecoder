package br.fiap.prototipomvcemotiondecoder.ui.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import br.fiap.prototipomvcemotiondecoder.R
import br.fiap.prototipomvcemotiondecoder.ui.controller.ResetPasswordController

class ResetPasswordActivity : ComponentActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var resetPasswordButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        emailEditText = findViewById(R.id.emailEditText)
        resetPasswordButton = findViewById(R.id.resetPasswordButton)

        resetPasswordButton.setOnClickListener {
            val email = emailEditText.text.toString()
            if (email.isNotBlank()) {
                val resetPasswordController = ResetPasswordController(this)
                resetPasswordController.sendPasswordResetEmail(email)
            } else {
                Toast.makeText(this, "Por favor, insira um e-mail válido.", Toast.LENGTH_LONG).show()
            }
        }
    }
}
