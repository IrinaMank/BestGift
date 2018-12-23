package com.giffter.bestgift

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.giffter.bestgift.ui.AllGiftFragment
import com.giffter.bestgift.ui.empty.EmptyFragment
import com.giffter.bestgift.ui.filter.FilterFragment
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import java.util.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        //addItem()

        supportFragmentManager.beginTransaction().replace(R.id.main_container, AllGiftFragment
                .newInstance(1))
                .commit()
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.all_gifts -> {
                supportFragmentManager.beginTransaction().replace(R.id.main_container, AllGiftFragment
                        .newInstance(1))
                        .commit()
            }
            R.id.filter_gifts -> {
                supportFragmentManager.beginTransaction().replace(R.id.main_container, FilterFragment
                        .newInstance())
                        .commit()

            }
            R.id.communicate -> {
                supportFragmentManager.beginTransaction().replace(R.id.main_container,
                        EmptyFragment())
                        .commit()

            }
            R.id.developer -> {
                supportFragmentManager.beginTransaction().replace(R.id.main_container,
                        EmptyFragment())
                        .commit()
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    fun addItem() {
        val db = FirebaseFirestore.getInstance()

        val data1 = HashMap<String, Any>()
        data1["id"] = UUID.randomUUID().toString()
        data1["title"] = "Эфирные масла"
        data1["occasion"] = listOf("c.dob", "c.ny", "c.8m")
        data1["gender"] =listOf("s.f")
        data1["role"] = emptyList<String>()
        data1["ageFrom"] = 18
        data1["ageTo"] = 80

        db.collection("gifts")
                .add(data1)
                .addOnSuccessListener { documentReference ->
                    Log.d("fjg", "DocumentSnapshot written with ID: " + documentReference.id)
                }
                .addOnFailureListener { e ->
                    Log.w("dkj", "Error adding document", e)
                }


        val data2 = HashMap<String, Any>()
        data2["id"] = UUID.randomUUID().toString()
        data2["title"] = "Набор для бани"
        data2["occasion"] = listOf("c.dob", "c.ny", "c.8m","c.23f", "c.housewarming")
        data2["gender"] = emptyList<String>()
        data2["role"] = listOf("m.colleague",  "m.noncloserelative", "m.familiar")
        data2["ageFrom"] = 12
        data2["ageTo"] = 70

        db.collection("gifts")
                .add(data2)
                .addOnSuccessListener { documentReference ->
                    Log.d("fjg", "DocumentSnapshot written with ID: " + documentReference.id)
                }
                .addOnFailureListener { e ->
                    Log.w("dkj", "Error adding document", e)
                }


        val data3 = HashMap<String, Any>()
        data3["id"] = UUID.randomUUID().toString()
        data3["title"] = "Мозайка"
        data3["occasion"] = listOf("c.dob", "c.ny", "c.8m","c.23f")
        data3["gender"] = emptyList<String>()
        data3["role"] = emptyList<String>()
        data3["ageFrom"] = 5
        data3["ageTo"] = 60

        db.collection("gifts")
                .add(data3)
                .addOnSuccessListener { documentReference ->
                    Log.d("fjg", "DocumentSnapshot written with ID: " + documentReference.id)
                }
                .addOnFailureListener { e ->
                    Log.w("dkj", "Error adding document", e)
                }

        val data4 = HashMap<String, Any>()
        data4["id"] = UUID.randomUUID().toString()
        data4["title"] = "Настольная игра"
        data4["occasion"] = listOf("c.dob", "c.ny", "c.8m","c.23f")
        data4["gender"] = emptyList<String>()
        data4["role"] = emptyList<String>()
        data4["ageFrom"] = 8
        data4["ageTo"] = 99

        db.collection("gifts")
                .add(data4)
                .addOnSuccessListener { documentReference ->
                    Log.d("fjg", "DocumentSnapshot written with ID: " + documentReference.id)
                }
                .addOnFailureListener { e ->
                    Log.w("dkj", "Error adding document", e)
                }


        val data6 = HashMap<String, Any>()
        data6["id"] = UUID.randomUUID().toString()
        data6["title"] = "Вышивка"
        data6["occasion"] = listOf("c.dob", "c.8m", "c.ny")
        data6["gender"] =listOf("s.f")
        data6["role"] = emptyList<String>()
        data6["ageFrom"] = 12
        data6["ageTo"] = 60

        db.collection("gifts")
                .add(data6)
                .addOnSuccessListener { documentReference ->
                    Log.d("fjg", "DocumentSnapshot written with ID: " + documentReference.id)
                }
                .addOnFailureListener { e ->
                    Log.w("dkj", "Error adding document", e)
                }

        val data7 = HashMap<String, Any>()
        data7["id"] = UUID.randomUUID().toString()
        data7["title"] = "Кубики для виски"
        data7["occasion"] = emptyList<String>()
        data7["gender"] =emptyList<String>()
        data7["role"] = emptyList<String>()
        data7["ageFrom"] = 5
        data7["ageTo"] = 99

        db.collection("gifts")
                .add(data7)
                .addOnSuccessListener { documentReference ->
                    Log.d("fjg", "DocumentSnapshot written with ID: " + documentReference.id)
                }
                .addOnFailureListener { e ->
                    Log.w("dkj", "Error adding document", e)
                }

        val data8 = HashMap<String, Any>()
        data8["id"] = UUID.randomUUID().toString()
        data8["title"] = "Подушка для шеи"
        data8["occasion"] = listOf("c.dob", "c.8m", "c.14f", "c.ny")
        data8["gender"] = emptyList<String>()
        data8["role"] = emptyList<String>()
        data8["ageFrom"] = 12
        data8["ageTo"] = 99

        db.collection("gifts")
                .add(data8)
                .addOnSuccessListener { documentReference ->
                    Log.d("fjg", "DocumentSnapshot written with ID: " + documentReference.id)
                }
                .addOnFailureListener { e ->
                    Log.w("dkj", "Error adding document", e)
                }

        val data9 = HashMap<String, Any>()
        data9["id"] = UUID.randomUUID().toString()
        data9["title"] = "Абонементы"
        data9["occasion"] = emptyList<String>()
        data9["gender"] = emptyList<String>()
        data9["role"] = emptyList<String>()
        data9["ageFrom"] = 12
        data9["ageTo"] = 99

        db.collection("gifts")
                .add(data9)
                .addOnSuccessListener { documentReference ->
                    Log.d("fjg", "DocumentSnapshot written with ID: " + documentReference.id)
                }
                .addOnFailureListener { e ->
                    Log.w("dkj", "Error adding document", e)
                }


        val data10 = HashMap<String, Any>()
        data10["id"] = UUID.randomUUID().toString()
        data10["title"] = "Футбольная форма"
        data10["occasion"] = emptyList<String>()
        data10["gender"] = emptyList<String>()
        data10["role"] = emptyList<String>()
        data10["ageFrom"] = 0
        data10["ageTo"] = 99

        db.collection("gifts")
                .add(data10)
                .addOnSuccessListener { documentReference ->
                    Log.d("fjg", "DocumentSnapshot written with ID: " + documentReference.id)
                }
                .addOnFailureListener { e ->
                    Log.w("dkj", "Error adding document", e)
                }

        val data11 = HashMap<String, Any>()
        data11["id"] = UUID.randomUUID().toString()
        data11["title"] = "Гетры"
        data11["occasion"] = emptyList<String>()
        data11["gender"] = emptyList<String>()
        data11["role"] = emptyList<String>()
        data11["ageFrom"] = 0
        data11["ageTo"] = 99

        db.collection("gifts")
                .add(data11)
                .addOnSuccessListener { documentReference ->
                    Log.d("fjg", "DocumentSnapshot written with ID: " + documentReference.id)
                }
                .addOnFailureListener { e ->
                    Log.w("dkj", "Error adding document", e)
                }

        val data12 = HashMap<String, Any>()
        data12["id"] = UUID.randomUUID().toString()
        data12["title"] = "Бутсы"
        data12["occasion"] = emptyList<String>()
        data12["gender"] = emptyList<String>()
        data12["role"] = emptyList<String>()
        data12["ageFrom"] = 0
        data12["ageTo"] = 99

        db.collection("gifts")
                .add(data12)
                .addOnSuccessListener { documentReference ->
                    Log.d("fjg", "DocumentSnapshot written with ID: " + documentReference.id)
                }
                .addOnFailureListener { e ->
                    Log.w("dkj", "Error adding document", e)
                }

        val data13 = HashMap<String, Any>()
        data13["id"] = UUID.randomUUID().toString()
        data13["title"] = "Футбольный мяч"
        data13["occasion"] = emptyList<String>()
        data13["gender"] = emptyList<String>()
        data13["role"] = emptyList<String>()
        data13["ageFrom"] = 0
        data13["ageTo"] = 99

        db.collection("gifts")
                .add(data13)
                .addOnSuccessListener { documentReference ->
                    Log.d("fjg", "DocumentSnapshot written with ID: " + documentReference.id)
                }
                .addOnFailureListener { e ->
                    Log.w("dkj", "Error adding document", e)
                }


        val data14 = HashMap<String, Any>()
        data14["id"] = UUID.randomUUID().toString()
        data14["title"] = "Спининг"
        data14["occasion"] = emptyList<String>()
        data14["gender"] = emptyList<String>()
        data14["role"] = emptyList<String>()
        data14["ageFrom"] = 0
        data14["ageTo"] = 99

        db.collection("gifts")
                .add(data14)
                .addOnSuccessListener { documentReference ->
                    Log.d("fjg", "DocumentSnapshot written with ID: " + documentReference.id)
                }
                .addOnFailureListener { e ->
                    Log.w("dkj", "Error adding document", e)
                }

        val data15 = HashMap<String, Any>()
        data15["id"] = UUID.randomUUID().toString()
        data15["title"] = "Наживки"
        data15["occasion"] = emptyList<String>()
        data15["gender"] = emptyList<String>()
        data15["role"] = emptyList<String>()
        data15["ageFrom"] = 0
        data15["ageTo"] = 99

        db.collection("gifts")
                .add(data15)
                .addOnSuccessListener { documentReference ->
                    Log.d("fjg", "DocumentSnapshot written with ID: " + documentReference.id)
                }
                .addOnFailureListener { e ->
                    Log.w("dkj", "Error adding document", e)
                }
    }
}
