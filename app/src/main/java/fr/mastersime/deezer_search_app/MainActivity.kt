package fr.mastersime.deezer_search_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import fr.mastersime.deezer_search_app.setup.SetupNavGraph
import fr.mastersime.deezer_search_app.ui.theme.Deezer_search_appTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Deezer_search_appTheme {
                SetupNavGraph(
                    navController = navController
                )
            }
        }
    }
}
