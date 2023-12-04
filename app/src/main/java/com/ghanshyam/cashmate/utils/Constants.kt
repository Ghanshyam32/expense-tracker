package com.ghanshyam.cashmate.utils

import com.ghanshyam.cashmate.Models.Category
import com.ghanshyam.cashmate.R

class Constants {

    companion object {
        val INCOME: String = "INCOME"
        val EXPENSE: String = "EXPENSE"
        val categories: ArrayList<Category> = ArrayList()

        fun setCategories() {
            categories.add(Category("Salary", R.drawable.salary))
            categories.add(Category("Business", R.drawable.business))
            categories.add(Category("Investment", R.drawable.investment))
            categories.add(Category("Loan", R.drawable.loan))
            categories.add(Category("Rent", R.drawable.rent))
            categories.add(Category("Other", R.drawable.menu))
        }

        fun findCategoryByName(categoryName: String): Category? {
            for (cat in categories) {
                if (cat.getCategoryName() == categoryName) {
                    return cat
                }
            }

            return null
        }

        fun getAccountsColor(accountName: String): Int {
            return when (accountName) {
                "Paytm" -> R.color.paytm_color
                "Cash" -> R.color.cash_color
                "Card" -> R.color.card_color
                else -> R.color.default_color
            }
        }

    }



}