package com.ghanshyam.cashmate.Views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.LinearLayoutManager
import com.ghanshyam.cashmate.Adapters.TransactionsAdapter
import com.ghanshyam.cashmate.Models.Transaction
import com.ghanshyam.cashmate.R
import com.ghanshyam.cashmate.Views.fragments.AddTransactionFragment
import com.ghanshyam.cashmate.databinding.ActivityMainBinding
import com.ghanshyam.cashmate.utils.Constants
import com.ghanshyam.cashmate.utils.Helper
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private lateinit var calendar: Calendar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        setSupportActionBar(binding?.materialToolbar)
        supportActionBar?.title = "Transactions"

        Constants.setCategories()

        calendar = Calendar.getInstance()
        updateData()


        binding!!.nextDate.setOnClickListener {
            calendar.add(Calendar.DATE, 1)
            updateData()
        }
        binding!!.previousDate.setOnClickListener {
            calendar.add(Calendar.DATE, -1)
            updateData()
        }

        binding!!.floatingActionButton.setOnClickListener {
            val fragment = AddTransactionFragment()
            fragment.show(supportFragmentManager, null)
        }

        val transactions: ArrayList<Transaction> = ArrayList()
        transactions.add(Transaction(Constants.INCOME, "Business", "Cash", "Some note", Date(), 500.0, 1))
        transactions.add(Transaction(Constants.EXPENSE, "Investment", "Cash", "Some note", Date(), 900.0, 2))
        transactions.add(Transaction(Constants.INCOME, "Business", "Paytm", "Some note", Date(), 500.0, 4))
        transactions.add(Transaction(Constants.INCOME, "Rent", "Cash", "Some note", Date(), 500.0, 5))
        transactions.add(Transaction(Constants.EXPENSE, "Business", "Card", "Some note", Date(), 500.0, 6))

        val transactionsAdapter: TransactionsAdapter = TransactionsAdapter(this, transactions)
        binding!!.transactionsList.layoutManager = LinearLayoutManager(this)
        binding!!.transactionsList.adapter = transactionsAdapter


    }

    private fun updateData() {
        binding!!.date.text = Helper.formatDate(calendar.time)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

}
