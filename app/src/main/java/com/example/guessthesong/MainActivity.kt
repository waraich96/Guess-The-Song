package com.example.guessthesong

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Switch
import android.widget.Toast
import com.example.guessthesong.activity.GameActivity
import com.example.guessthesong.activity.RulesWalkthroughActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gameModeSwitch = findViewById<Switch>(R.id.gameModeSwitch)
        gameModeSwitch?.setOnCheckedChangeListener({_, isChecked ->
            val testMessage = if (isChecked) "Current" else "Classic"
            Toast.makeText(this@MainActivity, testMessage,
                Toast.LENGTH_SHORT).show() })

    }

    fun playButClick(view: View){
        //val playButton = findViewById<View>(R.id.playButton) as ImageButton
        println(1)

        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)


    }

    fun rulesButClick(view: View){
        println(2)

        val intent = Intent(this, RulesWalkthroughActivity::class.java)
        startActivity(intent)

    }



}
