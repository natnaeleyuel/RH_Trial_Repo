package com.jct.renthabesha.core.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jct.renthabesha.R
import com.jct.renthabesha.core.presentation.ui.screens.components.ButtonCompos
import com.jct.renthabesha.core.presentation.ui.screens.components.TextField

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
                    label = stringResource(id = R.string.phone_num),
                    placeholder = stringResource(id = R.string.phone_num)
                );

                Spacer(modifier = Modifier.height(25.dp));

                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    label = stringResource(id = R.string.gender),
                    placeholder = stringResource(id = R.string.gender)
                );

                Spacer(modifier = Modifier.height(40.dp));

                ButtonCompos(
                    modifier = Modifier,
                    R.string.complete_profile_butn
                )
            }
        }
    }
}














