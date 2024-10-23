package com.example.expensetracker.stats

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.expensetracker.data.ExpenseDatabase
import com.example.expensetracker.data.ExpenseDao
import com.example.expensetracker.data.ExpenseSummary
import com.example.expensetracker.home.HomeScreenViewModel
import com.example.expensetracker.widget.Utils
import com.github.mikephil.charting.data.Entry

class StatsViewModel(dao: ExpenseDao):ViewModel() {
    val expenseEntries = dao.getAllExpenseByDate()
    val topExpenseEntries = dao.getTopExpenses()
    fun getEntriesForChart(entries: List<ExpenseSummary>): List<Entry> {
        val list = mutableListOf<Entry>()
        for (entry in entries) {
            val formattedDate = Utils.getMillisFromDate(entry.date)
            list.add(Entry(formattedDate.toFloat(), entry.total_amount.toFloat()))
        }
        return list
    }

    val incomeEntries = dao.getAllIncomeByDate()
    val topIncomeEntries = dao.getTopIncome()
}

class StatsViewModelFactory(private val context: Context): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(StatsViewModel::class.java)){
            val dao = ExpenseDatabase.getDatabase(context).expenseDao()
            @Suppress("UNCHECKED_CAST")
            return StatsViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}