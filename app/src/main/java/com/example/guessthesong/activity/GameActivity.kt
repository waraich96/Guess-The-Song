package com.example.guessthesong.activity


import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

import com.example.guessthesong.*
import kotlinx.android.synthetic.main.fragment_map.*

import kotlinx.android.synthetic.main.game_activity.*

class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_activity)

        bottomNavigation()
        replaceFragment(LyricsFragment())

    }

    fun bottomNavigation(){
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            if (item.itemId == android.R.id.home) {
                finish()
            } else {
                when (item.itemId) {
                    R.id.lyricsMenu -> { replaceFragment(LyricsFragment()) }
                    R.id.mapMenu -> {replaceFragment(MapFragment()) }
                    R.id.songMenu -> { replaceFragment(SongsFragment()) }
                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }

}
