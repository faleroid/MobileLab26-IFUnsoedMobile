package com.pemmob.naufal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pemmob.naufal.ui.screen.BasicInfoScreen
import com.pemmob.naufal.ui.screen.HubungiKamiScreen
import com.pemmob.naufal.ui.theme.NaufalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NaufalTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Inisialisasi controller navigasi
                    val navController = rememberNavController()

                    // Setup rute halaman aplikasi
                    NavHost(
                        navController = navController,
                        startDestination = "basic_info"
                    ) {
                        // Layar Pertama: Tentang Jualan
                        composable(route = "basic_info") {
                            BasicInfoScreen(
                                onNavigateToContact = {
                                    navController.navigate("form_screen")
                                }
                            )
                        }

                        // Layar Kedua: Form Hubungi Kami
                        composable(route = "form_screen") {
                            HubungiKamiScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}