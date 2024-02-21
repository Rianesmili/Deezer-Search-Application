package fr.mastersime.deezer_search_app.setup

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import fr.mastersime.deezer_search_app.feature.HomeView
import fr.mastersime.deezer_search_app.setup.Screen.HOME_VIEW_ROUTE

@Composable
fun SetupNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = HOME_VIEW_ROUTE,
    ) {
        composable(
            route = HOME_VIEW_ROUTE
        ){
            HomeView()
        }
    }
}