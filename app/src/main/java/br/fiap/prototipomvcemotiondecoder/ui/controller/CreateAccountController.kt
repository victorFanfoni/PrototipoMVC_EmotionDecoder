package br.fiap.prototipomvcemotiondecoder.ui.controller

import android.content.Context
import android.content.Intent
import android.widget.Toast
import br.fiap.prototipomvcemotiondecoder.ui.model.UserModel
import br.fiap.prototipomvcemotiondecoder.ui.view.Login
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class CreateAccountController(private val context: Context) : UserModel() {

    fun createAccount(email: String, password: String) {
        this.email = email
        this.password = password

        Firebase.auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = Firebase.auth.currentUser
                    user?.sendEmailVerification()?.addOnCompleteListener { verifyTask ->
                        if (verifyTask.isSuccessful) {
                            println("Email sent.")
                        }
                    }
                    Toast.makeText(context, "Cadastro realizado com sucesso", Toast.LENGTH_LONG).show()
                    val intent = Intent(context, Login::class.java)
                    context.startActivity(intent)
                } else {
                    Toast.makeText(context, "Usuário já cadastrado", Toast.LENGTH_LONG).show()
                }
            }
    }
}
