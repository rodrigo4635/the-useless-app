package com.rodrigo.useless.ui.imc

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.rodrigo.useless.R

class ImcFragment : Fragment() {

    private lateinit var imcViewModel: ImcViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        imcViewModel =
            ViewModelProviders.of(this).get(ImcViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_imc, container, false)

        val btn: Button = root.findViewById(R.id.button_calculate_imc)
        val result: TextView = root.findViewById(R.id.imc_result)
        val resultDescription: TextView = root.findViewById(R.id.imc_result_description)
        val resultLabel: TextView = root.findViewById(R.id.imc_result_label)
        val weightInput: EditText = root.findViewById(R.id.imc_weight_input)
        val heightInput: EditText = root.findViewById(R.id.imc_height_input)

        btn.setOnClickListener {
            val weight = weightInput.text.toString()
            val height = heightInput.text.toString()

            if (weight == "" || height == "") {
                resultLabel.text = "Não esqueça de preencher tudo"
            } else {
                val imc = calculateImc(weight.toFloat(), height.toFloat())
                result.text = String.format("%.2f", imc)
                resultLabel.visibility = View.VISIBLE
                resultDescription.text = getDescription(imc)
                hideKeyboard(root)
            }
        }

        return root
    }

    private fun calculateImc(weight: Float, height: Float): Float {
        return weight / (height * height)
    }

    private fun getDescription(imc: Float): String {
        if (imc < 18.5) {
            return "Tem que comprar alimento"
        } else if (imc >= 25 && imc < 30 ) {
            return "Melhor trocar o videogame por uma bike"
        } else if (imc >= 30 && imc < 40) {
            return "Cancela a Netflix e vai pra academia querido(a)"
        } else if (imc >= 40 && imc < 100) {
            return "Negócio tá feio pro seu lado..."
        } else if (imc >= 100) {
            return "Eu sou uma piada pra vc?"
        } else {
            return "Parece que ta tudo certo"
        }
    }

    private fun hideKeyboard(view: View) {
        view?.apply {
            val imm = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

}