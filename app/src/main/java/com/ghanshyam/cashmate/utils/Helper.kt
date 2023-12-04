package com.ghanshyam.cashmate.utils

import java.text.SimpleDateFormat
import java.util.Date

class Helper {
    companion object {
        @JvmStatic
        fun formatDate(date: Date): String {
            val dateFormat = SimpleDateFormat("dd MMMM, yyyy")
            return dateFormat.format(date)
        }
    }


}
