package com.jct.renthabesha

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.jct.renthabesha.ui.screens.AddLocationScreen
import com.jct.renthabesha.ui.screens.CompleteProfileScreen
import com.jct.renthabesha.ui.theme.RentHabeshaTheme
import com.jct.renthabesha.ui.screens.LoginScreen
import com.jct.renthabesha.ui.screens.SignupScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RentHabeshaTheme {

                LoginScreen()
//                SignupScreen()
//                AddLocationScreen()
//                CompleteProfileScreen()

            }
        }
    }
}

