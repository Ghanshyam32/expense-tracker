package com.ghanshyam.cashmate.Models

import java.util.Date

class Transaction(
    private var type: String,
    private var category: String,
    private var account: String,
    private var note: String,
    private var date: Date,
    private var amount: Double,
    private var id: Long
) {
    fun getType(): String {
        return type
    }

    fun getCategory(): String {
        return category
    }

    fun getAccount(): String {
        return account
    }

    fun getNote(): String {
        return note
    }

    fun getDate(): Date {
        return date
    }

    fun setType(transactionType: String) {
        type = transactionType
    }

    fun setCategory(transactionCategory: String) {
        category = transactionCategory
    }

    fun setAccount(transactionAccount: String) {
        account = transactionAccount
    }

    fun setNote(transactionNote: String) {
        note = transactionNote
    }

    fun setDate(transactionDate: Date) {
        date = transactionDate
    }

    fun getAmount(): Double {
        return amount
    }

    fun setAmount(transactionAmount: Double) {
        amount = transactionAmount
    }

    fun getId(): Long {
        return id
    }

    fun setAmount(transactionId: Long) {
        id = transactionId
    }


}
