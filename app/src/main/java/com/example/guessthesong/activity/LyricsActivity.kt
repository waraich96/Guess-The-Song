package com.example.guessthesong.activity

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.guessthesong.MyModel
import com.example.guessthesong.R
import com.example.guessthesong.LyricGuess
import com.example.guessthesong.adapter.LyricsAdapter
import kotlinx.android.synthetic.main.lyrics_activity.*

class LyricsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lyrics_activity)

        bottomNavigation()

        var imageModelArrayList: ArrayList<MyModel> = populateList()

        val lyricsRecyclerView = findViewById<View>(R.id.lyricsRecyclerView) as RecyclerView
        val layoutManager = LinearLayoutManager(this)
        lyricsRecyclerView.layoutManager = layoutManager
        val lyricsAdapter = LyricsAdapter(imageModelArrayList)
        lyricsAdapter.setOnItemClickListener(object : LyricsAdapter.ClickListener {
            override fun onClick(pos: Int, aView: View) {
                    var intent = Intent(aView.context, LyricGuess::class.java)
                    startActivity(intent)

            }
        })
        lyricsRecyclerView.adapter = lyricsAdapter
    }

    private fun populateList(): ArrayList<MyModel> {
        val list = ArrayList<MyModel>()
        val myImageList = intArrayOf(R.drawable.points50, R.drawable.points150, R.drawable.points100, R.drawable.points50, R.drawable.points200, R.drawable.points150, R.drawable.points100,R.drawable.points200, R.drawable.points50, R.drawable.points150)
        val myImageNameList = arrayOf(R.string.test, R.string.test1, R.string.test2, R.string.test3, R.string.test4, R.string.test5, R.string.test6, R.string.test1, R.string.test, R.string.test2)

        for (i in 0..9) {
            val imageModel = MyModel()
            imageModel.setNames(getString(myImageNameList[i]))
            imageModel.setImage_drawables(myImageList[i])
            list.add(imageModel)
        }
        return list
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    fun bottomNavigation(){
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            if (item.itemId == android.R.id.home) {
                finish()
            } else {
                when (item.itemId) {
                    R.id.lyricsMenu -> { }
                    R.id.mapMenu -> { }
                    R.id.songMenu -> { }
                }
            }
            true
        }
    }
}
