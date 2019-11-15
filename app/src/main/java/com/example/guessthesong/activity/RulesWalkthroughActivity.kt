package com.example.guessthesong.activity

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.example.guessthesong.MainActivity
import com.example.guessthesong.R
import com.example.guessthesong.adapter.RulesWalkthroughAdapter
import kotlinx.android.synthetic.main.rules_walkthrough_activity.*

@Suppress("DEPRECATION")
class RulesWalkthroughActivity : AppCompatActivity() {


    private lateinit var rulesWalkthroughAdapter: RulesWalkthroughAdapter
    internal lateinit var pages: Array<TextView?>
    internal lateinit var welcomeScreen: IntArray



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rules_walkthrough_activity)

        initUI()

        initActions()

    }

    private fun initUI() {

        welcomeScreen = intArrayOf(R.layout.rules_walkthrough_slider_1, R.layout.rules_walkthrough_slider_2, R.layout.rules_walkthrough_slider_3, R.layout.rules_walkthrough_slider_4)

        addPagination(0)

    }

    private fun initActions() {

        val viewPagerPageChangeListener = object : ViewPager.OnPageChangeListener {

            override fun onPageSelected(position: Int) {
                addPagination(position)


                if (position == welcomeScreen.size - 1) {
                    btn_next.text = "LET'S GO"
                    btn_skip.visibility = View.GONE
                } else {
                    btn_next.text = "Next"
                    btn_skip.visibility = View.VISIBLE
                }
            }

            override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {

            }

            override fun onPageScrollStateChanged(arg0: Int) {

            }
        }


        rulesWalkthroughAdapter = RulesWalkthroughAdapter(welcomeScreen, applicationContext)
        view_pager.adapter = rulesWalkthroughAdapter
        view_pager.addOnPageChangeListener(viewPagerPageChangeListener)

        btn_skip.setOnClickListener { launchApp() }

        btn_next.setOnClickListener {

            val current = getItem(+1)
            if (current < welcomeScreen.size) {
                view_pager.currentItem = current
            } else {
                launchApp()
            }
        }

    }

    private fun addPagination(currentPage: Int) {
        pages = arrayOfNulls(welcomeScreen.size)

        layoutDots.removeAllViews()
        for (i in pages.indices) {
            pages[i] = TextView(this)
            pages[i]?.text = Html.fromHtml("&#8226;")
            pages[i]?.textSize = 35f
            pages[i]?.setTextColor(ContextCompat.getColor(this,R.color.md_grey_300))
            layoutDots.addView(pages[i])
        }

        if (pages.size > 0) {
            pages[currentPage]?.setTextColor(ContextCompat.getColor(this,R.color.md_yellow_600))
        }
    }

    private fun getItem(i: Int): Int {
        return view_pager.currentItem + i
    }

    private fun launchApp() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}
