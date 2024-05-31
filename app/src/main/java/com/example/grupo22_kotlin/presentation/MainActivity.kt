package com.example.grupo22_kotlin.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.grupo22_kotlin.presentation.navigation.RootNavGraph
import com.example.grupo22_kotlin.presentation.screens.mainHome.ConnectivityObserver
import com.example.grupo22_kotlin.presentation.screens.mainHome.NetworkConnectivityObserver
import com.example.grupo22_kotlin.presentation.ui.theme.Grupo22KotlinTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    private lateinit var connectivityObserver: ConnectivityObserver
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            Grupo22KotlinTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    connectivityObserver = NetworkConnectivityObserver(applicationContext)
                    navController= rememberNavController()
                    RootNavGraph(navController = navController)

                }
            }
        }
    }
}

