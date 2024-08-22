package br.fiap.prototipomvcemotiondecoder.ui.controller

import android.content.ContentValues.TAG
import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.widget.Toast
import br.fiap.prototipomvcemotiondecoder.ui.model.UserModel
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginController(private val context: Context) : UserModel(), Parcelable {

    fun signIn() {
        Firebase.auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success")
                    val user = Firebase.auth.currentUser
                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                        context,
                        "Authentication failed.",
                        Toast.LENGTH_SHORT,
                    ).show()
                    updateUI(null)
                }
            }
    }

    private fun updateUI(user: Any?) {
        // Implementar a atualização da UI após o login
    }

    // Parcelable Implementation
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(email)
        parcel.writeString(password)
    }

    override fun describeContents(): Int {
        return 0
    }

    private constructor(parcel: Parcel) : this(parcel.readParcelable(Context::class.java.classLoader)!!) {
        email = parcel.readString() ?: ""
        password = parcel.readString() ?: ""
    }

    companion object CREATOR : Parcelable.Creator<LoginController> {
        override fun createFromParcel(parcel: Parcel): LoginController {
            return LoginController(parcel)
        }

        override fun newArray(size: Int): Array<LoginController?> {
            return arrayOfNulls(size)
        }
    }
}
