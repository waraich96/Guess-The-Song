package com.example.guessthesong


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.guessthesong.adapter.LyricsAdapter
import kotlinx.android.synthetic.main.fragment_lyrics.*


/**
 * A simple [Fragment] subclass.
 */
class LyricsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lyrics, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var imageModelArrayList: ArrayList<MyModel> = populateList()

        lyricsRecyclerView.apply {

            layoutManager = LinearLayoutManager(activity)
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

}
