package com.ghanshyam.cashmate.Views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.ghanshyam.cashmate.R
import com.ghanshyam.cashmate.Views.fragments.AddTransactionFragment
import com.ghanshyam.cashmate.databinding.ActivityMainBinding
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private lateinit var calendar: Calendar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        setSupportActionBar(binding?.materialToolbar)
        supportActionBar?.title = "Transactions"

        calendar = Calendar.getInstance()
        updateData()


        binding!!.nextDate.setOnClickListener{
            calendar.add(Calendar.DATE, 1)
            updateData()
        }
        binding!!.previousDate.setOnClickListener{
            calendar.add(Calendar.DATE, -1)
            updateData()
        }

        binding!!.floatingActionButton.setOnClickListener {
            val fragment = AddTransactionFragment()
            fragment.show(supportFragmentManager, null)
        }
    }

        private fun updateData() {
            val dateFormat: SimpleDateFormat = SimpleDateFormat("dd MMMM, yyyy")
            binding!!.date.text = dateFormat.format(calendar.time)
        }

        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.top_menu, menu)
            return super.onCreateOptionsMenu(menu)
        }

    }
