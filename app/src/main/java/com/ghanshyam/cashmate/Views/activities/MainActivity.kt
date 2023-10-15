package com.ghanshyam.cashmate.Views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.ghanshyam.cashmate.R
import com.ghanshyam.cashmate.Views.fragments.AddTransactionFragment
import com.ghanshyam.cashmate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        setSupportActionBar(binding?.materialToolbar)
        supportActionBar?.title = "Transactions"

        binding!!.floatingActionButton.setOnClickListener {
            val fragment = AddTransactionFragment()
            fragment.show(supportFragmentManager, null)
        }

        fun onCreateOptionsMenu(menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.top_menu, menu)
            return super.onCreateOptionsMenu(menu)
        }

    }
}