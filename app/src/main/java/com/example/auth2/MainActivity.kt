package com.example.auth2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemLayout: LinearLayout = findViewById(R.id.LayoutCategories)
        val itemLayoutRecommended: LinearLayout = findViewById(R.id.layoutRecommended)

        val imageList = arrayOf<Int>(
            R.drawable.plane,
            R.drawable.hotel,
            R.drawable.passport,
            R.drawable.bus,
            R.drawable.restaurant,
            R.drawable.plane,
            R.drawable.hotel,
        )

        val nameList = arrayOf<String>(
            "Flights","Hotels","Visa","Buses","Restaurants","Flights","Hotels"
        )

        val imagesRecommended = arrayOf<Int>(
            R.drawable.chinaimage,
            R.drawable.chinaimage,
            R.drawable.chinaimage,
        )

        val countryRecommended = arrayOf<String>("China","France","India")

        for (i in imageList.indices){
            val view = layoutInflater.inflate(R.layout.item_categories,itemLayout, false)
            val itemImage: ImageView = view.findViewById(R.id.item_image)
            val itemName: TextView = view.findViewById(R.id.item_name)
            itemImage.setImageResource(imageList[i])
            itemName.text = nameList[i]
            itemLayout.addView(view)
        }

        for (i in imagesRecommended.indices){
            val view = layoutInflater.inflate(R.layout.item_recommended,itemLayoutRecommended,false)
            val itemRecommended: ImageView = view.findViewById(R.id.item_recommended_image)
            val itemCountry: TextView = view.findViewById(R.id.item_country)
            itemRecommended.setImageResource(imagesRecommended[i])
            itemCountry.text = countryRecommended[i]
            itemLayoutRecommended.addView(view)

        }

    }
}