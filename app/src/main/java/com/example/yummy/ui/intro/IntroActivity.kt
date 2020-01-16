package com.example.yummy.ui.intro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.ViewParent
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.example.yummy.R
import kotlinx.android.synthetic.main.activity_intro.*

class IntroActivity : AppCompatActivity() {

    lateinit var SliderAdapter : SliderAdapter
    var currentPage = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        SliderAdapter = SliderAdapter(this)
        slide_view_pager.adapter = SliderAdapter
        addDotsIndicator(0)
        slide_view_pager?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }
            override fun onPageSelected(position: Int) {
                addDotsIndicator(position)
                currentPage = position
                if (position == 0){
                    next_button.isEnabled = true
                }
                if (position == 2){
                    next_button.isEnabled = false
                }
            }

        })
        next_button.setOnClickListener {
            slide_view_pager.currentItem = currentPage + 1
        }
        skip_button.setOnClickListener {
            slide_view_pager.currentItem = 2
        }
    }

    fun addDotsIndicator(pos : Int){
        var mDots = arrayOfNulls<TextView>(3)
        dots_layout.removeAllViews()
        for (i in 0..2){
            mDots[i] = TextView(this)
            mDots[i]?.setText(Html.fromHtml("&#8226;"))
            mDots[i]?.setTextSize(35F)
            mDots[i]?.setTextColor(resources.getColor(R.color.colorTransparentWhite))
            dots_layout.addView(mDots[i])
        }
        mDots[pos]?.setTextColor(resources.getColor(R.color.colorRed))
    }

}
