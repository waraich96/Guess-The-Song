package  com.example.guessthesong

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class LyricGuess : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lyric_guess)
    }

    fun halveButClick(view: View){
        println(1)
    }

    fun pointButClick(view: View){
        println(2)
    }
}