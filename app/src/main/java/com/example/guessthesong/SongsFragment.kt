package com.example.guessthesong


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.guessthesong.adapter.SongsAdapter
import kotlinx.android.synthetic.main.fragment_songs.*

/**
 * A simple [Fragment] subclass.
 */
class SongsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_songs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var imageModelArrayList: ArrayList<SongModel> = populateList()

        lyricsRecyclerView.apply {

            layoutManager = LinearLayoutManager(activity)
            lyricsRecyclerView.layoutManager = layoutManager
            val songsAdapter = SongsAdapter(imageModelArrayList)

            songsAdapter.setOnItemClickListener(object : SongsAdapter.ClickListener {
                override fun onClick(pos: Int, aView: View) {
                    var intent = Intent(aView.context, SongInfo::class.java)
                    startActivity(intent)

                }
            })
            lyricsRecyclerView.adapter = songsAdapter
        }

    }

    private fun populateList(): ArrayList<SongModel> {
        val list = ArrayList<SongModel>()
        val myImageList = intArrayOf(R.drawable.points50, R.drawable.points150, R.drawable.points100)
        val myImageNameList = arrayOf(R.string.test, R.string.test1, R.string.test2)

        for (i in 0..2) {
            val imageModel = SongModel()
            imageModel.setNames(getString(myImageNameList[i]))
            imageModel.setImage_drawables(myImageList[i])
            list.add(imageModel)
        }
        return list
    }

}
