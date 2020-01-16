package com.example.yummy.ui.intro

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.yummy.R
import kotlinx.android.synthetic.main.activity_intro.*
class SliderAdapter(
    val context: Context
) : PagerAdapter() {


    lateinit var layoutInflater: LayoutInflater
    val slide_images: IntArray = intArrayOf(R.drawable.intro1, R.drawable.intro1, R.drawable.intro3)
    val slide_headings = arrayOf(R.string.Slider_Title1,R.string.Slider_Title2,R.string.Slider_Title3)
    val slide_bodies = arrayOf(R.string.Slider_Body1,R.string.Slider_Body2,R.string.Slider_Body3)
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return slide_images.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = LayoutInflater.from(context)
        val view: View = layoutInflater.inflate(R.layout.slide_layout, container, false)
        val  slide_image : ImageView = view.findViewById(R.id.slide_image)
        val  slide_text_header : TextView = view.findViewById(R.id.slide_text_header)
        val  slide_text_body : TextView = view.findViewById(R.id.slide_text_body)
        slide_image.setImageResource(slide_images[position])
        slide_text_header.setText(slide_headings[position])
        slide_text_body.setText(slide_bodies[position])
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }
}