package com.pemmob.naufal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pemmob.naufal.ui.screen.DaftarProdukScreen
import com.pemmob.naufal.ui.screen.DetailProductScreen
import com.pemmob.naufal.ui.screen.HubungiKamiScreen
import com.pemmob.naufal.ui.theme.NaufalTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NaufalTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "daftar_produk"
                    ) {
                        // 1. Rute Halaman Utama (Daftar Produk)
                        composable(route = "daftar_produk") {
                            DaftarProdukScreen(navController = navController)
                        }

                        // 2. Rute Halaman Detail Produk (Menerima Parameter ID)
                        composable(
                            route = "detail/{productId}",
                            arguments = listOf(navArgument("productId") { type = NavType.IntType })
                        ) { backStackEntry ->
                            // Menangkap productId dari URL route
                            val productId = backStackEntry.arguments?.getInt("productId") ?: 0

                            DetailProductScreen(
                                productId = productId,
                                navController = navController
                            )
                        }

                        composable(route = "hubungi_kami") {
                            HubungiKamiScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}