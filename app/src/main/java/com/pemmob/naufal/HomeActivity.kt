package com.pemmob.naufal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.pemmob.naufal.ui.screen.DaftarProdukScreen
import com.pemmob.naufal.ui.theme.NaufalTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NaufalTheme {
                DaftarProdukScreen()
            }
        }
    }
}