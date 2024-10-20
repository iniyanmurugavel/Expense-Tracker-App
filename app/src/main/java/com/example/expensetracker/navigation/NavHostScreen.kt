package com.example.expensetracker.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.expensetracker.addExpense.AddExpenseScreen
import com.example.expensetracker.home.HomeScreen
import com.example.expensetracker.stats.StatsScreen

@Composable
fun NavHostScreen(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ScreenRoute.HomeScreenRoute.route){
        composable(ScreenRoute.HomeScreenRoute.route){
            HomeScreen(navController)
        }
        composable(ScreenRoute.AddExpenseScreenRoute.route){
            AddExpenseScreen(navController)
        }
        composable(ScreenRoute.StatsScreenRoute.route){
            StatsScreen(navController)
        }
    }
}