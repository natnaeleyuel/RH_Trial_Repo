package com.jct.renthabesha.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import androidx.compose.ui.tooling.preview.Preview
import androidx. compose. ui. graphics. drawscope. Stroke
import androidx. compose. ui. graphics. PaintingStyle. Companion. Stroke

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddClothingScreen() {
    var clothingName by remember { mutableStateOf("") }
    var categoryExpanded by remember { mutableStateOf(false) }
    var selectedCategory by remember { mutableStateOf("Category") }
    var rentalPeriodExpanded by remember { mutableStateOf(false) }
    var selectedRentalPeriod by remember { mutableStateOf("Rental Period") }
    var aboutClothing by remember { mutableStateOf("") }
    var careInstruction by remember { mutableStateOf("") }

    val categories = listOf("Cultural", "Formal", "Casual", "Wedding")
    val rentalPeriods = listOf("1 day", "3 days", "1 week", "1 month")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        // Top App Bar
        Row(verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = { /* Back */ }) {
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .background(Color(0xFFF2F2F2), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            }
            Spacer(Modifier.width(8.dp))
            Text("Add Clothing", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Dashed Add Image Box
        DashedImageBox(onClick = { /* Handle image picker */ })

        Spacer(modifier = Modifier.height(16.dp))

        // Name Field
        Text("Name", fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
        Spacer(modifier = Modifier.height(6.dp))
        OutlinedTextField(
            value = clothingName,
            onValueChange = { clothingName = it },
            placeholder = { Text("Clothing Name") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = textFieldColors()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Category & Rental Period
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text("Category", fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                Spacer(modifier = Modifier.height(6.dp))
                ExposedDropdownMenuBox(
                    expanded = categoryExpanded,
                    onExpandedChange = { categoryExpanded = !categoryExpanded }
                ) {
                    OutlinedTextField(
                        value = selectedCategory,
                        onValueChange = {},
                        readOnly = true,
                        placeholder = { Text("Category") },
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = categoryExpanded)
                        },
                        modifier = Modifier.menuAnchor().fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        colors = textFieldColors()
                    )
                    ExposedDropdownMenu(
                        expanded = categoryExpanded,
                        onDismissRequest = { categoryExpanded = false }
                    ) {
                        categories.forEach {
                            DropdownMenuItem(
                                text = { Text(it) },
                                onClick = {
                                    selectedCategory = it
                                    categoryExpanded = false
                                }
                            )
                        }
                    }
                }
            }

            Column(modifier = Modifier.weight(1f)) {
                Text("Rental Period", fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                Spacer(modifier = Modifier.height(6.dp))
                ExposedDropdownMenuBox(
                    expanded = rentalPeriodExpanded,
                    onExpandedChange = { rentalPeriodExpanded = !rentalPeriodExpanded }
                ) {
                    OutlinedTextField(
                        value = selectedRentalPeriod,
                        onValueChange = {},
                        readOnly = true,
                        placeholder = { Text("Rental Period") },
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = rentalPeriodExpanded)
                        },
                        modifier = Modifier.menuAnchor().fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        colors = textFieldColors()
                    )
                    ExposedDropdownMenu(
                        expanded = rentalPeriodExpanded,
                        onDismissRequest = { rentalPeriodExpanded = false }
                    ) {
                        rentalPeriods.forEach {
                            DropdownMenuItem(
                                text = { Text(it) },
                                onClick = {
                                    selectedRentalPeriod = it
                                    rentalPeriodExpanded = false
                                }
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // About Clothing
        Text("About Clothing", fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
        Spacer(modifier = Modifier.height(6.dp))
        OutlinedTextField(
            value = aboutClothing,
            onValueChange = { aboutClothing = it },
            placeholder = { Text("Describe the clothing, design details") },
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            shape = RoundedCornerShape(16.dp),
            colors = textFieldColors()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Care Instructions
        Text("Care Instruction", fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
        Spacer(modifier = Modifier.height(6.dp))
        OutlinedTextField(
            value = careInstruction,
            onValueChange = { careInstruction = it },
            placeholder = { Text("Care Instruction") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = textFieldColors()
        )

        Spacer(modifier = Modifier.height(42.dp))

        // Add Button

            Button(
                onClick = { /* Submit */ },
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00C853)),
                shape = RoundedCornerShape(50)
            ) {
                Text("Add", color = Color.White, fontSize = 16.sp)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
    }

@Composable
fun DashedImageBox(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .padding(1.dp)
            .background(Color.White)
            .drawWithContent {
                drawContent()
                drawRoundRect(
                    color = Color(0xFF00C853),
                    style = Stroke(width = 3f, pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f))),
                    cornerRadius = CornerRadius(20f, 20f)
                )
            }
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(Icons.Default.Image, contentDescription = "Add Image", tint = Color(0xFF00C853))
            Text("Tap to Add Image", color = Color(0xFF00C853))
        }
    }
}

@Composable
private fun textFieldColors(): TextFieldColors = OutlinedTextFieldDefaults.colors(
    unfocusedBorderColor = Color(0xFFB2DFDB),
    focusedBorderColor = Color(0xFF00C853),
    cursorColor = Color(0xFF00C853),
    unfocusedTextColor = Color.Black,
    focusedTextColor = Color.Black,
    unfocusedPlaceholderColor = Color.Gray,
    focusedPlaceholderColor = Color.Gray
)

@Preview(showBackground = true)
@Composable
fun PreviewAddClothingScreen() {
    MaterialTheme {
        AddClothingScreen()
    }
}
