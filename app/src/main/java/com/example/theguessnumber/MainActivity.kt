package com.example.theguessnumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.math.max
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var minValue = 0
    var maxValue = 100
    var num :Int = 0
    var won = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val text : TextView = findViewById(R.id.text)
        val button_down : Button = findViewById(R.id.button_down)
        val button_up : Button = findViewById(R.id.button_up)
        val generate : Button = findViewById(R.id.generator)
        val guessed : Button = findViewById(R.id.guessed)

        generate.setOnClickListener {
            num = Random.nextInt(minValue, maxValue)
            text.setText(num.toString())
            generate.visibility = View.INVISIBLE
            guessed.visibility = View.VISIBLE
        }
        button_up.setOnClickListener{
            minValue = num
            if (chekingLimits()){
                num = Random.nextInt(minValue,maxValue)
                text.setText(num.toString())
            }else{
                text.setText("No puede ser me ganaste")
            }

        }
        button_down.setOnClickListener{
            maxValue = num
            if (chekingLimits()){
                num = Random.nextInt(minValue,maxValue)
                text.setText(num.toString())
            }else{
                text.setText("No puede ser me ganaste")
            }

        }
        guessed.setOnClickListener{
            if(!won) {
                text.setText("Adivine tu numero, es : " + num)
                guessed.setText("Vover a jugar")
                won = true
            }else{
                generate.visibility = View.VISIBLE
                text.setText("Tap to generate to START")
                guessed.visibility = View.GONE
                resetValues()

            }

        }
    }

    fun resetValues(){
        minValue = 0
        maxValue = 100
        num = 0
        won = false
    }

    fun chekingLimits(): Boolean{
        return minValue!= maxValue
    }
}