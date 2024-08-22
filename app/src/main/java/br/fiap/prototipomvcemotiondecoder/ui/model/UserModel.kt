package br.fiap.prototipomvcemotiondecoder.ui.model

open class UserModel(
    var name: String = "",
    var email: String = "",
    var password: String = ""
) {

    // Sobrescrevendo o método toString para facilitar a depuração
    override fun toString(): String {
        return "UserModel(name='$name', email='$email')"
    }

    // Métodos adicionais que podem ser úteis
    fun updatePassword(newPassword: String) {
        password = newPassword
    }

    fun isPasswordValid(): Boolean {
        // Adicione sua lógica de validação de senha aqui
        return password.length >= 6
    }
}
