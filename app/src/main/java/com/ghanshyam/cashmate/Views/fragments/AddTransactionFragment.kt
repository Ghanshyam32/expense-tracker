package com.ghanshyam.cashmate.Views.fragments

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.ghanshyam.cashmate.Adapters.CategoryAdapter
import com.ghanshyam.cashmate.Models.Category
import com.ghanshyam.cashmate.R
import com.ghanshyam.cashmate.databinding.CategoryDialogBinding
import com.ghanshyam.cashmate.databinding.FragmentAddTransactionBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.text.SimpleDateFormat
import java.util.Calendar

class AddTransactionFragment : BottomSheetDialogFragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    var binding: AddTransactionFragment? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

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

            datePickerDialog.setOnDateSetListener() { view, year, month, dayOfMonth ->

                val calendar: Calendar = Calendar.getInstance()
                calendar.set(Calendar.DAY_OF_MONTH, view.dayOfMonth)
                calendar.set(Calendar.MONTH, view.month)
                calendar.set(Calendar.YEAR, view.year)

                val simpleDateFormat: SimpleDateFormat = SimpleDateFormat("dd-MMMM-yyyy")
                val dateToShow = simpleDateFormat.format(calendar.time)

                binding.datePicker.setText(dateToShow)

            }
        }

        binding.category.setOnClickListener { c ->
            val categoryBinding: CategoryDialogBinding = CategoryDialogBinding.inflate(inflater)
            val categoryDialog: AlertDialog = AlertDialog.Builder(context).create()
            categoryDialog.setView(categoryBinding.root)

            val categories: ArrayList<Category> = ArrayList()
            categories.add(Category("Salary", R.drawable.salary))
            categories.add(Category("Business", R.drawable.business))
            categories.add(Category("Investment", R.drawable.investment))
            categories.add(Category("Loan", R.drawable.loan))
            categories.add(Category("Rent", R.drawable.rent))
            categories.add(Category("Other", R.drawable.menu))

            val categoryAdapter: CategoryAdapter = CategoryAdapter(requireContext(), categories)
            categoryBinding.rectangles.layoutManager = GridLayoutManager(requireContext(), 3)
            categoryBinding.rectangles.adapter = categoryAdapter

            categoryDialog.show()
        }

        return rootView
    }

    companion object {
    }
}