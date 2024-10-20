package com.example.expensetracker.widget

import java.text.SimpleDateFormat
import java.util.Locale

object Utils {
    fun formatDateToReadableForm(dateInMillis:Long):String{
        val dateFormatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return dateFormatter.format(dateInMillis)
    }
    fun formatToDecimalValue(double:Double):String{
        return String.format("%.2f",double)
    }
}
