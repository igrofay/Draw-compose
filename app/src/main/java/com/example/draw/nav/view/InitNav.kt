package com.example.draw.nav.view

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.draw.circles.view.CirclesScreen
import com.example.draw.nav.model.MainRouting

@Composable
fun InitNav() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MainRouting.route) {
        composable(MainRouting.route) {
            ChooseWhatDraw(listRoute = MainRouting.listRoute, onSelectRoute = {
                navController.navigate(it.route){
                    popUpTo(MainRouting.route)
                }
            })
        }
        composable(MainRouting.CirclesDraw.route){
            CirclesScreen()
        }

    }
}