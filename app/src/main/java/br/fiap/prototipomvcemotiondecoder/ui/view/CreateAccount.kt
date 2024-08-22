package br.fiap.prototipomvcemotiondecoder.ui.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import br.fiap.prototipomvcemotiondecoder.R

class CreateAccount: ComponentActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        val email = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val senha = findViewById<EditText>(R.id.editTextTextPassword)
        val confirmaSenha = findViewById<EditText>(R.id.editTextTextPasswordCheck)
        val button = findViewById<Button>(R.id.button2)

        button.setOnClickListener {
            val email = email.text.toString()
            val senha = senha.text.toString()
            val confirmaSenha = confirmaSenha.text.toString()

            if (email.isNotEmpty() && senha.isNotEmpty()){
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
            if (!email.contains("@")){
                Toast.makeText(this, "Email inválido", Toast.LENGTH_SHORT).show()
            }
            else if (senha != confirmaSenha){
                Toast.makeText(this, "As senhas não coincidem", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "Conta criada com sucesso", Toast.LENGTH_SHORT).show()

            }
        }

    }

}