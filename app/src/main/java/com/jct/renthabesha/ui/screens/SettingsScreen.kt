package com.jct.renthabesha.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import com.jct.renthabesha.ui.theme.RentHabeshaTheme

class SettingsScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RentHabeshaTheme {
                MySettingsScreen()
            }
        }
    }
}

@Composable
fun MySettingsScreen() {
    val configuration = LocalConfiguration.current
//    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
    val horizontalPadding = if (screenWidth < 360.dp) 16.dp else 24.dp
    var selectedTab by remember { mutableIntStateOf(0) }
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                selectedTab = selectedTab,
                onTabSelected = { tabIndex ->
                    selectedTab = tabIndex
                }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(vertical = 20.dp, horizontal = horizontalPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            when (selectedTab) {
                0 -> HomeScreen()
                1 -> OrdersScreen()
                2 -> ProfileScreen()
            }
            TopBar(
                text =  "Settings",
                onClick = { /* handle back press */ }
            )
            Spacer(modifier = Modifier.height(16.dp))

            Spacer(modifier = Modifier.height(24.dp))
            SettingItem(ImageVector.vectorResource(id =  com.jct.renthabesha.R.drawable.notification_icon), "Notification Settings")
            SettingItem(ImageVector.vectorResource(id =  com.jct.renthabesha.R.drawable.baseline_lock_24), "Password Manager")
            SettingItem(ImageVector.vectorResource(id =  com.jct.renthabesha.R.drawable.delete_account_icon), "Delete Account")
        }
    }
}

@Composable
fun SettingItem(icon: ImageVector, title: String, showDivider: Boolean = true) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /* Handle click */ }
            .padding(vertical = 16.dp, horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(icon, contentDescription = title)
        Spacer(modifier = Modifier.width(16.dp))
        Text(title, fontSize = 20.sp,modifier = Modifier.weight(1f))

        Icon(
            modifier = Modifier.size(38.dp),
            painter = painterResource(id =  com.jct.renthabesha.R.drawable.baseline_chevron_right_24), contentDescription = "Go",
            tint = Color(0xFFb2c2bc)
        )
    }
}