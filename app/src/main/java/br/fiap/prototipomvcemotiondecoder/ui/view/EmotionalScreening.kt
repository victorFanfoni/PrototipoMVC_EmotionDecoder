package br.fiap.prototipomvcemotiondecoder.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import br.fiap.prototipomvcemotiondecoder.R
import br.fiap.prototipomvcemotiondecoder.ui.controller.EmotionalScreeningController

class EmotionalScreening : ComponentActivity() {

    private lateinit var controller: EmotionalScreeningController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emotionalscreening)

        controller = EmotionalScreeningController(this)

        button_enviar.setOnClickListener {
            val selectedEmotion = getSelectedEmotion()
            val comments = edit_comentarios.text.toString()
            controller.handleEmotionSelection(selectedEmotion, comments)
        }
    }

    private fun getSelectedEmotion(): String {
        return when {
            radio_alegria.isChecked -> EmotionModel.EMOTION_HAPPY
            radio_tristeza.isChecked -> EmotionModel.EMOTION_SAD
            radio_raiva.isChecked -> EmotionModel.EMOTION_ANGER
            radio_medo.isChecked -> EmotionModel.EMOTION_FEAR
            else -> ""
        }
    }
}
