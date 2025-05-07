package com.jct.renthabesha.core.presentation.ui.screens

//import kotlin.jvm.java
//import android.content.Intent
//import android.os.Bundle
//import android.os.Handler
//import android.os.Looper
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jct.renthabesha.R


//class SplashActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        // After 2.5s navigate to IntroActivity
//        Handler(Looper.getMainLooper()).postDelayed({
//            startActivity(Intent(this, WelcomeScreen()::class.java))
//            finish()
//        }, 2500)
//
//        setContent {
//            RentHabeshaTheme {
//                SplashScreen()
//            }
//        }
//    }
//}
@Preview
@Composable
fun SplashScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) { Image(
            painter = painterResource(id = R.drawable.img_eighteen),
            contentDescription = "RentHabesha Logo",
            modifier = Modifier
                .size(64.dp)
                .border(
                    BorderStroke(2.dp, Color(0xFF00A86B)),
                    shape = CircleShape
                )
                .padding(4.dp)
                .clip(CircleShape)
        )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "RentHabesha.",
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
        }
    }
}


