package br.fiap.prototipomvcemotiondecoder.ui.model

import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

interface Auth {
    val auth: FirebaseAuth
        get() = Firebase.auth
}