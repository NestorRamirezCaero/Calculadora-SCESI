package nestor.scesi.calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val boton0 = findViewById<Button>(R.id.boton_0)
        val boton1 = findViewById<Button>(R.id.boton_1)
        val boton2 = findViewById<Button>(R.id.boton_2)
        val boton3 = findViewById<Button>(R.id.boton_3)
        val boton4 = findViewById<Button>(R.id.boton_4)
        val boton5 = findViewById<Button>(R.id.boton_5)
        val boton6 = findViewById<Button>(R.id.boton_6)
        val boton7 = findViewById<Button>(R.id.boton_7)
        val boton8 = findViewById<Button>(R.id.boton_8)
        val boton9 = findViewById<Button>(R.id.boton_9)
        val botonPunto = findViewById<Button>(R.id.boton_punto)
        val botonSumar = findViewById<Button>(R.id.boton_suma)
        val botonRestar = findViewById<Button>(R.id.boton_resta)
        val botonMultiplicar = findViewById<Button>(R.id.boton_multiplicacion)
        val botonDividir = findViewById<Button>(R.id.boton_divicion)
        val botonBorrar = findViewById<Button>(R.id.boton_del)
        val botonIgual = findViewById<Button>(R.id.boton_igual)
        val textoResultado = findViewById<TextView>(R.id.texto_resultado)
        val textoEntrada = findViewById<TextView>(R.id.texto_entrada)
        var resultado: Int = 0
        var operando1: Int = 0
        var operacion: String? = null

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        boton0.setOnClickListener {
            textoEntrada.text = "${textoEntrada.text}0"
        }

        boton1.setOnClickListener {
            textoEntrada.text = "${textoEntrada.text}1"
        }

        boton2.setOnClickListener {
            textoEntrada.text = "${textoEntrada.text}2"
        }

        boton3.setOnClickListener {
            textoEntrada.text = "${textoEntrada.text}3"
        }

        boton4.setOnClickListener {
            textoEntrada.text = "${textoEntrada.text}4"
        }

        boton5.setOnClickListener {
            textoEntrada.text = "${textoEntrada.text}5"
        }

        boton6.setOnClickListener {
            textoEntrada.text = "${textoEntrada.text}6"
        }

        boton7.setOnClickListener {
            textoEntrada.text = "${textoEntrada.text}7"
        }

        boton8.setOnClickListener {
            textoEntrada.text = "${textoEntrada.text}8"
        }

        boton9.setOnClickListener {
            textoEntrada.text = "${textoEntrada.text}9"
        }

        botonSumar.setOnClickListener {
            operando1 = if (textoEntrada.text.isNotEmpty()) {textoEntrada.text.toString().toInt()} else resultado
            operacion = "+"
            textoEntrada.text = ""
        }

        botonRestar.setOnClickListener {
            operando1 = if (textoEntrada.text.isNotEmpty()) {textoEntrada.text.toString().toInt()} else resultado
            operacion = "-"
            textoEntrada.text = ""
        }

        botonMultiplicar.setOnClickListener {
            operando1 = if (textoEntrada.text.isNotEmpty()) {textoEntrada.text.toString().toInt()} else resultado
            operacion = "*"
            textoEntrada.text = ""
        }

        botonDividir.setOnClickListener {
            operando1 = if (textoEntrada.text.isNotEmpty()) {textoEntrada.text.toString().toInt()} else resultado
            operacion = "/"
            textoEntrada.text = ""
        }

        botonIgual.setOnClickListener {
            val operando2 = textoEntrada.text.toString().toIntOrNull() ?: 0
            when (operacion) {
                "+" -> resultado = operando1 + operando2
                "-" -> resultado = operando1 - operando2
                "*" -> resultado = operando1 * operando2
                "/" -> {
                    try {
                        if (operando2 == 0) {
                            throw ArithmeticException("División por cero")
                        }
                        resultado = operando1 / operando2
                    } catch (e: ArithmeticException) {
                        textoResultado.text = "Error: División por cero"
                        textoEntrada.text = ""
                        operacion = null
                        return@setOnClickListener
                    }
                }
            }
            textoResultado.text = "$resultado"
            textoEntrada.text = ""
            operacion = null
        }

        botonBorrar.setOnClickListener {
            textoEntrada.text = ""
            textoResultado.text = ""
            resultado = 0
            operando1 = 0
            operacion = null
        }
    }
}