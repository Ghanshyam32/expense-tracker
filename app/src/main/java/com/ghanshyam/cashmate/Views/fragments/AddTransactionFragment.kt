package com.ghanshyam.cashmate.Views.fragments

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ghanshyam.cashmate.Adapters.AccountAdapter
import com.ghanshyam.cashmate.Adapters.AccountClickListener
import com.ghanshyam.cashmate.Adapters.CategoryAdapter
import com.ghanshyam.cashmate.Adapters.CategoryClickListener
import com.ghanshyam.cashmate.Models.Account
import com.ghanshyam.cashmate.Models.Category
import com.ghanshyam.cashmate.R
import com.ghanshyam.cashmate.databinding.DialogListBinding
import com.ghanshyam.cashmate.databinding.FragmentAddTransactionBinding
import com.ghanshyam.cashmate.databinding.RowAccountsBinding
import com.ghanshyam.cashmate.utils.Constants.Companion.categories
import com.ghanshyam.cashmate.utils.Helper
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.text.SimpleDateFormat
import java.util.Calendar

class AddTransactionFragment : BottomSheetDialogFragment() {
    private var param1: String? = null
    private var param2: String? = null

    var binding: AddTransactionFragment? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentAddTransactionBinding.inflate(inflater, container, false)
        val rootView = binding.root

        binding.incomeSelect.setOnClickListener {

            binding.incomeSelect.setBackgroundResource((R.drawable.income_selector))
            binding.expenseSelect.setBackgroundResource((R.drawable.default_selector))
            binding.incomeSelect.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.green
                )
            )
            binding.expenseSelect.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.black
                )
            )

        }

        binding.expenseSelect.setOnClickListener {
            binding.expenseSelect.setBackgroundResource((R.drawable.expense_selector))
            binding.incomeSelect.setBackgroundResource((R.drawable.default_selector))
            binding.incomeSelect.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.black
                )
            )
            binding.expenseSelect.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.red
                )
            )
        }

        binding.datePicker.setOnClickListener {
            val datePickerDialog: DatePickerDialog = DatePickerDialog(requireContext())
            datePickerDialog.show()

            datePickerDialog.setOnDateSetListener { view, year, month, dayOfMonth ->

                val calendar: Calendar = Calendar.getInstance()
                calendar.set(Calendar.DAY_OF_MONTH, view.dayOfMonth)
                calendar.set(Calendar.MONTH, view.month)
                calendar.set(Calendar.YEAR, view.year)

                val dateToShow = Helper.formatDate(calendar.time)

                binding.datePicker.setText(dateToShow)

            }
        }

        binding.category.setOnClickListener { c ->
            val categoryBinding: DialogListBinding = DialogListBinding.inflate(inflater)
            val categoryDialog: AlertDialog = AlertDialog.Builder(context).create()
            categoryDialog.setView(categoryBinding.root)



            // Implementing CategoryClickListener
            val categoryClickListener = object : CategoryClickListener {
                override fun onCategoryClicked(category: Category) {
                    binding.category.setText(category.getCategoryName())
                    categoryDialog.dismiss()
                }
            }

            val categoryAdapter =
                CategoryAdapter(requireContext(), categories, categoryClickListener)
            categoryBinding.rectangles.layoutManager = GridLayoutManager(requireContext(), 3)
            categoryBinding.rectangles.adapter = categoryAdapter

            categoryDialog.show()
        }

        binding.account.setOnClickListener {
            val accountBinding: DialogListBinding = DialogListBinding.inflate(inflater)
            val accountDialog: AlertDialog = AlertDialog.Builder(context).create()
            accountDialog.setView(accountBinding.root)

            val accounts: ArrayList<Account> = ArrayList()
            accounts.add(Account(1300.0, "Cash"))
            accounts.add(Account(3040.0, "Paytm"))
            accounts.add(Account(5060.0, "Cash"))
            accounts.add(Account(1200.0, "Card"))

            val accountClickListener = object : AccountClickListener {
                override fun onAccountSelected(account: Account) {
                    binding.account.setText(account.getAccountName())
                    accountDialog.dismiss()
                }
            }

            val adapter: AccountAdapter =
                AccountAdapter(requireContext(), accounts, accountClickListener)
            accountBinding.rectangles.layoutManager = LinearLayoutManager(context)
            accountBinding.rectangles.addItemDecoration(
                DividerItemDecoration(
                    context,
                    DividerItemDecoration.VERTICAL
                )
            )
            accountBinding.rectangles.adapter = adapter

            accountDialog.show()
        }





        return rootView
    }


}