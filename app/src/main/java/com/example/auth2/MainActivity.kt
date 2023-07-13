package com.example.auth2

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {

            when (it.itemId) {


                R.id.nav_home -> Toast.makeText(
                    applicationContext,
                    "Clicked Home",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.nav_login -> Toast.makeText(
                    applicationContext,
                    "Clicked Login",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.nav_tag -> Toast.makeText(
                    applicationContext,
                    "Clicked Tags",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.nav_share -> Toast.makeText(
                    applicationContext,
                    "Clicked Share",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.nav_rate_us -> Toast.makeText(
                    applicationContext,
                    "Clicked Rate us",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.nav_notification -> Toast.makeText(
                    applicationContext,
                    "Clicked Notification",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.nav_setting -> Toast.makeText(
                    applicationContext,
                    "Clicked Setting",
                    Toast.LENGTH_SHORT
                ).show()

            }

            true

        }



                val itemLayout: LinearLayout = findViewById(R.id.LayoutCategories)
                val itemLayoutRecommended: LinearLayout = findViewById(R.id.layoutRecommended)

                val imageList = arrayOf<Int>(
                    R.drawable.plane,
                    R.drawable.hotel,
                    R.drawable.passport,
                    R.drawable.bus,
                    R.drawable.restaurant,

                    )

                val nameList = arrayOf<String>(
                    "Flights", "Hotels", "Visa", "Buses", "Restaurants"
                )

                val imagesRecommended = arrayOf<Int>(
                    R.drawable.chinaimage,
                    R.drawable.switzerland,
                    R.drawable.sychelles,
                    R.drawable.germany,
                    R.drawable.brazil,
                    R.drawable.newfrance,
                    R.drawable.dubai,
                    R.drawable.mombasa,
                    R.drawable.zanzibar,
                    R.drawable.japan,
                )

                val countryRecommended = arrayOf<String>(
                    "China",
                    "Switzerland",
                    "Sychelles",
                    "Germany",
                    "Brazil",
                    "France",
                    "Dubai",
                    "Mombasa",
                    "Zanzibar",
                    "Japan"
                )

                for (i in imageList.indices) {
                    val view = layoutInflater.inflate(R.layout.item_categories, itemLayout, false)
                    val itemImage: ImageView = view.findViewById(R.id.item_image)
                    val itemName: TextView = view.findViewById(R.id.item_name)
                    itemImage.setImageResource(imageList[i])
                    itemName.text = nameList[i]
                    itemLayout.addView(view)
                }

                for (i in imagesRecommended.indices) {
                    val view = layoutInflater.inflate(
                        R.layout.item_recommended,
                        itemLayoutRecommended,
                        false
                    )
                    val itemRecommended: ImageView = view.findViewById(R.id.item_recommended_image)
                    val itemCountry: TextView = view.findViewById(R.id.item_country)
                    itemRecommended.setImageResource(imagesRecommended[i])
                    itemCountry.text = countryRecommended[i]
                    itemLayoutRecommended.addView(view)

                }

        fun onOptionsItemSelected(item: MenuItem): Boolean {

            if (toggle.onOptionsItemSelected(item)){

                return true

            }

            return super.onOptionsItemSelected(item)
        }
    }
}