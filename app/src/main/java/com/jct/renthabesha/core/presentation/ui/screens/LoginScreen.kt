package com.jct.renthabesha.core.presentation.ui.screens

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.jct.renthabesha.R
import com.jct.renthabesha.core.presentation.ui.screens.components.ButtonCompos
import com.jct.renthabesha.core.presentation.ui.screens.components.TextField
import com.jct.renthabesha.core.presentation.ui.theme.Brand
import com.jct.renthabesha.core.presentation.ui.theme.Poppins
import com.jct.renthabesha.core.presentation.ui.theme.TextStrong

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(horizontal = 30.dp, vertical = 100.dp),
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.sign_in),
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(40.dp))

            Column(
                modifier = Modifier.fillMaxSize()
            ){

                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    label = stringResource(id = R.string.email),
                    placeholder = stringResource(id = R.string.email)
                );

                Spacer(modifier = Modifier.height(25.dp));

                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    label = stringResource(id = R.string.password),
                    placeholder = stringResource(id = R.string.password)
                );

                Spacer(modifier = Modifier.height(40.dp));

                ButtonCompos(
                    modifier = Modifier,
                    R.string.sign_in
                )

                Spacer(modifier = Modifier.height(25.dp))

                Box(
                    modifier = Modifier.fillMaxHeight(0.8f)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.TopCenter
                ){
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = if (isSystemInDarkTheme()) Color.White else TextStrong,
                                    fontStyle = MaterialTheme.typography.bodyLarge.fontStyle,
                                    fontFamily = Poppins,
                                    fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                                    fontWeight = MaterialTheme.typography.bodyLarge.fontWeight
                                )
                            ){
                                append("Don't have an account? ")
                            }

                            withStyle(
                                style = SpanStyle(
                                    color = Brand,
                                    fontStyle = MaterialTheme.typography.bodyLarge.fontStyle,
                                    fontFamily = Poppins,
                                    fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                                    fontWeight = MaterialTheme.typography.bodyLarge.fontWeight,
                                    textDecoration = TextDecoration.Underline
                                )
                            ){
                                append("Sign Up")
                            }
                        }
                    )
                }
            }
        }
    }
}














