package com.jct.renthabesha.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.jct.renthabesha.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.unit.sp
import com.jct.renthabesha.ui.theme.RentHabeshaTheme

class PasswordManagerScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RentHabeshaTheme(){
                ResponsivePasswordManagerScreen()
            }
        }
    }
}

@Composable
fun ResponsivePasswordManagerScreen() {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
    val horizontalPadding = if (screenWidth < 360.dp) 16.dp else 24.dp
    var currentPassword by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    var confirmNewPassword by remember { mutableStateOf("") }

    Scaffold (
        bottomBar = {
            ChangePasswordButton(
                text = "Change",
                onClick = { /* handle button press */ }
            )
        }
    )
    { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(vertical = 20.dp, horizontal = horizontalPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            TopBar(
                text =  "Password Manager",
                onClick = { /* handle back press */ }
            )

            Spacer(modifier = Modifier.height(screenHeight * 0.05f))

            PasswordSection(
                label = "Current Password",
                password = currentPassword,
                onPasswordChange = { currentPassword = it },
                showForgotPassword = true
            )

            Spacer(modifier = Modifier.height(screenHeight * 0.04f))

            PasswordSection(
                label = "New Password",
                password = newPassword,
                onPasswordChange = { newPassword = it }
            )

            Spacer(modifier = Modifier.height(screenHeight * 0.04f))

            PasswordSection(
                label = "Confirm New Password",
                password = confirmNewPassword,
                onPasswordChange = { confirmNewPassword = it }
            )

            Spacer(modifier = Modifier.height(screenHeight * 0.20f))

        }
    }
}

@Composable
fun PasswordSection(
    label: String,
    password: String,
    onPasswordChange: (String) -> Unit,
    showForgotPassword: Boolean = false
) {
    Column(modifier = Modifier
        .fillMaxWidth()
    ) {
        Text(
            text = label,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.align(Alignment.Start)
        )
        Spacer(modifier = Modifier.height(12.dp))
        PasswordField(
            textValue = password,
            onValueChange = onPasswordChange
        )

        if (showForgotPassword) {
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Forgot Password?",
                color = Color(0xFF3B82F6),
                fontSize = 14.sp,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable { /* Forgot password logic */ }
            )
        }
    }
}

@Composable
fun PasswordField(
    textValue: String,
    onValueChange: (String) -> Unit
) {
    var passwordVisible by remember { mutableStateOf(false) }

    TextField(
        value = textValue,
        onValueChange = onValueChange,
        modifier = Modifier
            .border(1.dp, Color.LightGray, RoundedCornerShape(40))
            .fillMaxWidth()
            .height(60.dp),
        visualTransformation = if (passwordVisible) VisualTransformation.None else AsteriskPasswordVisualTransformation(),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        trailingIcon = {
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(
                    painter = painterResource(
                        if (passwordVisible) R.drawable.visibility_icon
                        else R.drawable.baseline_visibility_24
                    ),
                    contentDescription = if (passwordVisible) "Hide password" else "Show password"
                )
            }
        }
    )
}

class AsteriskPasswordVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val out = AnnotatedString("*".repeat(text.text.length))
        return TransformedText(out, OffsetMapping.Identity)
    }
}

@Composable
fun ChangePasswordButton(
    text: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(vertical = 30.dp, horizontal = 20.dp)
    ) {
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981)),
            shape = RoundedCornerShape(50),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)

        ) {
            Text(
                text = text,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}