package com.jct.renthabesha.ui.screens


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign

import androidx.compose.ui.unit.dp
import com.jct.renthabesha.R
import com.jct.renthabesha.ui.screens.components.ButtonCompos
import com.jct.renthabesha.ui.theme.RentHabeshaTheme

@Composable
fun AddClothingScreen() {

    var name by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var rentalPeriod by remember { mutableStateOf("") }
    var about by remember { mutableStateOf("") }
    var careInstructions by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier

                .verticalScroll(rememberScrollState())
                .padding(start = 38.dp,end=47.dp, top = 59.dp,bottom=119.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(
                    onClick = { },
                    modifier = Modifier.size(40.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_left_icon),
                        contentDescription = "Back",
                        tint = Color.Black
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Add Clothing",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )
            }

            OutlinedButton(
                onClick = { },
                modifier = Modifier
                    .height(136.dp)
                    .fillMaxWidth()
                    .background(Color(0xFFEDFBF6)),
                border = BorderStroke(1.dp, Color(0xFF19B579)),
                shape = RoundedCornerShape(5.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.add_icon),
                        contentDescription = "Add Image",
                        tint = Color.Gray,
                        modifier = Modifier.size(width = 33.dp, height = 27.dp)
                    )
                    Text("Add Image", color = Color(0xFF19B57E))
                }
            }

            Spacer(modifier = Modifier.height(3.dp))

            Text("Name", style = MaterialTheme.typography.labelMedium)
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                placeholder = { Text("Clothing Name", style = MaterialTheme.typography.bodySmall) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),

                )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(22.dp)
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text("Category", style = MaterialTheme.typography.labelMedium)
                    Row {
                        OutlinedTextField(
                            value = category,
                            onValueChange = { category = it },
                            placeholder = {
                                Text(
                                    "Category",
                                    style = MaterialTheme.typography.bodySmall
                                )
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 12.dp),
                            shape = RoundedCornerShape(12.dp),
                            trailingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.arrow_down_icon), // Replace with your actual icon
                                    contentDescription = "Select category",
                                    modifier = Modifier
                                        .padding(start = 11.dp) // 👈 Left padding
                                        .size(24.dp)
                                        .clickable {
                                            // Handle icon click
                                        }
                                )
                            }
                        )


                    }
                }
                Column(modifier = Modifier.weight(1f)) {
                    Text("Rental Period", style = MaterialTheme.typography.labelMedium)
                    OutlinedTextField(
                        value = rentalPeriod,
                        onValueChange = { rentalPeriod = it },
                        placeholder = {
                            Text(
                                "Rental Period",
                                style = MaterialTheme.typography.bodySmall
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp),
                        shape = RoundedCornerShape(10.dp),
                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.arrow_down_icon), // Replace with your actual icon
                                contentDescription = "Select category",
                                modifier = Modifier
                                    // 👈 Left padding
                                    .size(24.dp)
                                    .clickable {
                                        // Handle icon click
                                    }
                            )
                        }
                    )
                    Spacer(modifier = Modifier.width(12.dp))

                }
            }

            Text("About Clothing", style = MaterialTheme.typography.labelMedium)
            OutlinedTextField(
                value = about,
                onValueChange = { about = it },
                placeholder = {
                    Text(
                        "Describe the clothing, design details",
                        style = MaterialTheme.typography.bodySmall
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                shape = RoundedCornerShape(10.dp),
                maxLines = 5
            )

            Text("Care Instruction", style = MaterialTheme.typography.labelMedium)
            OutlinedTextField(
                value = careInstructions,
                onValueChange = { careInstructions = it },
                placeholder = {
                    Text(
                        "Care instruction",
                        style = MaterialTheme.typography.bodySmall
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                shape = RoundedCornerShape(8.dp)

            )
        }

        Surface(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(118.dp),
            shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp),
            color = Color.White,
            border = BorderStroke(2.dp, Color.LightGray)
        ) {
            // Box with padding to constrain button size
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                contentAlignment = Alignment.Center
            ) {


                ButtonCompos(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .width(299.dp)
                        .height(50.dp),
                    text = R.string.sign_up)
            }
        }
    }
}


