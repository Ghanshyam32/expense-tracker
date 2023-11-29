package com.ghanshyam.cashmate.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ghanshyam.cashmate.Models.Account
import com.ghanshyam.cashmate.Models.Category
import com.ghanshyam.cashmate.R
import com.ghanshyam.cashmate.databinding.RowAccountsBinding
import com.ghanshyam.cashmate.databinding.SampleCategoryBinding

interface AccountClickListener {
    fun onAccountSelected(account: Account)
}

class AccountAdapter(
    var context: Context,
    var accountArrayList: ArrayList<Account>,
    private val accountClickListener: AccountClickListener
) :
    RecyclerView.Adapter<AccountAdapter.AccountsViewHolder>() {


    inner class AccountsViewHolder(val binding: RowAccountsBinding) :
        RecyclerView.ViewHolder(binding.root) {


    }

    override fun onBindViewHolder(holder: AccountsViewHolder, position: Int) {
        val account: Account = accountArrayList[position]
        holder.binding.accountName.text = account.getAccountName()
        holder.itemView.setOnClickListener {
            accountClickListener.onAccountSelected(account)
        }
    }

    override fun getItemCount(): Int {
        return accountArrayList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountsViewHolder {
        val binding = RowAccountsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return AccountsViewHolder(binding)
    }


}