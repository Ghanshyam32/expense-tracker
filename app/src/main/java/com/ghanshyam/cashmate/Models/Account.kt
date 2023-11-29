package com.ghanshyam.cashmate.Models

class Account(
    private var accountAmount: Double = 0.0,
    private var accountName: String = ""
) {
    fun getAccountAmount(): Double {
        return accountAmount
    }


    fun getAccountName(): String {
        return accountName
    }

    fun setAccountAmount(amount: Double) {
        accountAmount = amount
    }

    fun setAccountName(name: String) {
        accountName = name
    }
}