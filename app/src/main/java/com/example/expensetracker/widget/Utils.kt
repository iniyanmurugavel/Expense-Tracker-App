package com.example.expensetracker.widget

import com.example.expensetracker.R
import com.example.expensetracker.data.ExpenseEntity
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object Utils {
    fun formatDateToReadableForm(dateInMillis:Long):String{
        val dateFormatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return dateFormatter.format(dateInMillis)
    }

    fun formatDateForChart(dateInMillis: Long): String {
        val dateFormatter = SimpleDateFormat("dd-MMM", Locale.getDefault())
        return dateFormatter.format(dateInMillis)
    }

    fun formatToDecimalValue(double:Double):String{
        return String.format("%.2f",double)
    }

    fun getMillisFromDate(dateFormat: String?): Long {
        var date = Date()
        val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        try {
            date = formatter.parse(dateFormat)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        println("Today is $date")
        return date.time
    }

    fun getItemIcon(item: ExpenseEntity): Int {
        if(item.category == "Salary"){
            return R.drawable.ic_paypal
        }
        else if(item.category == "Netflix"){
            return R.drawable.ic_netflix
        }
        else if(item.category == "Upwork"){
            return R.drawable.ic_upwork
        }
        else if(item.category == "Starbucks"){
            return R.drawable.ic_starbucks
        }
        else if(item.category == "Youtube"){
            return R.drawable.ic_youtube
        }
        else if(item.category == "Other") {
            if (item.type == "Income")
                return R.drawable.ic_income
        }
        return R.drawable.ic_expense
    }
}
