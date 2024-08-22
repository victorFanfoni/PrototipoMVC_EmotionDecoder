package br.fiap.prototipomvcemotiondecoder.ui.view

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import br.fiap.prototipomvcemotiondecoder.R
import br.fiap.prototipomvcemotiondecoder.ui.controller.ResultScreenController

class ResultScreen : ComponentActivity() {

    private lateinit var controller: ResultScreenController
    private lateinit var textViewRelatorio: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultscreen)

        // Inicializa o controller
        controller = ResultScreenController()

        // Inicializa as views
        textViewRelatorio = findViewById(R.id.textViewRelatorio)

        // Obtém os dados do Intent
        val relatorioCompleto = intent.getStringExtra(getString(R.string.relatorio)) ?: ""

        // Exibe o relatório na tela
        textViewRelatorio.text = controller.formatarRelatorio(relatorioCompleto)
    }
}
