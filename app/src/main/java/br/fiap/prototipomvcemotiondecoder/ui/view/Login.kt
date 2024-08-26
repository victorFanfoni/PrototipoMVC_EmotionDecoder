package br.fiap.prototipomvcemotiondecoder.ui.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import br.fiap.prototipomvcemotiondecoder.R
import br.fiap.prototipomvcemotiondecoder.ui.controller.LoginController
import br.fiap.prototipomvcemotiondecoder.ui.model.UserModel

class Login : ComponentActivity() {

    private lateinit var controller: LoginController

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        controller = LoginController(this)

        val buttonLogin = findViewById<Button>(R.id.button_entrar)
        val editEmail = findViewById<EditText>(R.id.edit_email)
        val editPassword = findViewById<EditText>(R.id.edit_senha)
        val buttonCreateAccount = findViewById<TextView>(R.id.textView4)

        buttonLogin.setOnClickListener {
            val email = editEmail.text.toString()
            val password = editPassword.text.toString()
            val userModel = UserModel(email, password)
            controller.signIn(userModel)
        }

        buttonCreateAccount.setOnClickListener {
            val intent = Intent(this, CreateAccount::class.java)
            startActivity(intent)
        }
    }
}