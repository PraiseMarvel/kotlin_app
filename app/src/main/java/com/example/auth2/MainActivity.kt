package com.example.auth2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.PopupMenu
import androidx.drawerlayout.widget.DrawerLayout
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize Firebase Auth
        firebaseAuth = FirebaseAuth.getInstance()

        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)
        val menuImageView = findViewById<ImageView>(R.id.menuImageView)

        menuImageView.setOnClickListener { view ->
            val popupMenu = PopupMenu(this, view)
            popupMenu.inflate(R.menu.nav_menu)

            // Set item click listener for the menu items
            popupMenu.setOnMenuItemClickListener { menuItem ->
                // Handle menu item click event
                when (menuItem.itemId) {
                    R.id.nav_home -> {
                        // Handle Home menu item click
                        Toast.makeText(
                            applicationContext,
                            "Clicked Home",
                            Toast.LENGTH_SHORT
                        ).show()
                        true
                    }
                    R.id.nav_tag -> {
                        // Handle Tag menu item click
                        Toast.makeText(
                        applicationContext,
                        "Clicked Tags",
                        Toast.LENGTH_SHORT
                        ).show()
                        true
                    }
                    R.id.nav_setting -> {
                        // Handle Tag menu item click
                        Toast.makeText(
                            applicationContext,
                            "Clicked Setting",
                            Toast.LENGTH_SHORT
                        ).show()
                        true
                    }
                    R.id.nav_notification -> {
                        // Handle Tag menu item click
                        Toast.makeText(
                            applicationContext,
                            "Clicked Notification",
                            Toast.LENGTH_SHORT
                        ).show()
                        true
                    }
                    R.id.nav_share -> {
                        // Handle Tag menu item click
                        Toast.makeText(
                            applicationContext,
                            "Clicked Share",
                            Toast.LENGTH_SHORT
                        ).show()
                        true
                    }
                    R.id.nav_rate_us -> {
                        // Handle Tag menu item click
                        Toast.makeText(
                            applicationContext,
                            "Clicked Rate Us",
                            Toast.LENGTH_SHORT
                        ).show()
                        true
                    }
                    R.id.signOutButton -> {
                        // Handle sign out on item click
                        firebaseAuth.signOut()
                        // Redirect to the login activity or any other desired activity
                        val intent = Intent(this, SignInActivity::class.java)
                        startActivity(intent)
                        finish()
                        true
                    }
                    // Add more cases for other menu items as needed
                    else -> false
                }
            }

            // Show the popup menu
            popupMenu.show()
        }



        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

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
            "Seychelles",
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

    }

}