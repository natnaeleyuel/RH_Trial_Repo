package com.jct.renthabesha.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.jct.renthabesha.ui.screens.components.TextField
import com.jct.renthabesha.R
import com.jct.renthabesha.ui.theme.Brand
import com.jct.renthabesha.ui.theme.Poppins
import com.jct.renthabesha.ui.theme.TextStrong

@Composable
fun CompleteProfileScreen(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(horizontal = 30.dp, vertical = 100.dp),
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.complete_profile),
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(25.dp))

            Column(
                modifier = Modifier.fillMaxSize()
            ){

                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    textValue = "",
                    label = stringResource(id = R.string.phone_number),
                    placeholder = stringResource(id = R.string.phone_number)
                );

                Spacer(modifier = Modifier.height(25.dp));

                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    textValue = "",
                    label = stringResource(id = R.string.gender),
                    placeholder = stringResource(id = R.string.gender)
                );

                Spacer(modifier = Modifier.height(25.dp));

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Brand,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(size = 30.dp)
                ) {
                    Text(text = stringResource(id = R.string.complete_profile_button),
                        style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium)
                    )
                }
            }
        }
    }
}














