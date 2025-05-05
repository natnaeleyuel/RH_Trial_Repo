package com.jct.renthabesha.core.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jct.renthabesha.core.presentation.ui.screens.components.TextField
import com.jct.renthabesha.R
import com.jct.renthabesha.core.presentation.ui.screens.components.ButtonCompos

@Composable
fun AddLocationScreen(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(horizontal = 30.dp, vertical = 100.dp),
        ) {

            Icon(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                painter = painterResource(id = R.drawable.location_icon),
                contentDescription = "Location Icon"
            );

            Spacer(modifier = Modifier.height(25.dp));

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.your_location_headline),
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(15.dp));

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.add_location_description),
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(40.dp))

            Column(
                modifier = Modifier.fillMaxSize()
            ){

                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    label = stringResource(id = R.string.your_location_label),
                    placeholder = stringResource(id = R.string.location)
                );

                Spacer(modifier = Modifier.height(40.dp));

                ButtonCompos(
                    modifier = Modifier,
                    R.string.add_location
                )
            }
        }
    }
}














