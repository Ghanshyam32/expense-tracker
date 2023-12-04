package com.ghanshyam.cashmate.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.ghanshyam.cashmate.Models.Category
import com.ghanshyam.cashmate.Models.Transaction
import com.ghanshyam.cashmate.R
import com.ghanshyam.cashmate.databinding.RowTransactionBinding
import com.ghanshyam.cashmate.utils.Constants
import com.ghanshyam.cashmate.utils.Helper

class TransactionsAdapter(
    private val context: Context,
    private val transactions: ArrayList<Transaction>
) : RecyclerView.Adapter<TransactionsAdapter.TransactionViewHolder>() {

    inner class TransactionViewHolder(val binding: RowTransactionBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val binding = RowTransactionBinding.inflate(LayoutInflater.from(context), parent, false)
        return TransactionViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return transactions.size
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val transaction: Transaction = transactions[position]
        holder.binding.amount.text = transaction.getAmount().toString()
        holder.binding.accountLabel.text = transaction.getAccount()
        val format = Helper.formatDate(transaction.getDate())
        holder.binding.date.text = format
        holder.binding.transactionCategory.text = transaction.getCategory()

        holder.binding.accountLabel.backgroundTintList =
            ContextCompat.getColorStateList(
                context,
                Constants.getAccountsColor(transaction.getAccount())
            )


        val redColor = ContextCompat.getColor(context, R.color.red)
        val greenColor = ContextCompat.getColor(context, R.color.green)

        val transactionCategory: Category? = Constants.findCategoryByName(transaction.getCategory())
        if (transactionCategory != null) {
            holder.binding.categoryIcon.setImageResource(transactionCategory.getCategoryImage())
        }
//        holder.binding.categoryIcon.backgroundTintList(context.getColorStateList(transactionCategory.get))


        if (transaction.getType().equals(Constants.INCOME)) {
            holder.binding.amount.setTextColor(greenColor)
        } else if (transaction.getType().equals(Constants.EXPENSE)) {
            holder.binding.amount.setTextColor(redColor)
        }

    }

}