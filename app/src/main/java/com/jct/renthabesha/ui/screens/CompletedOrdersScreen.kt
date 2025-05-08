package com.jct.renthabesha.ui.screens


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jct.renthabesha.R
import com.jct.renthabesha.ui.theme.RentHabeshaTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompletedOrdersScreen(
    onBackClick: () -> Unit,
    onActiveOrdersClick: () -> Unit = {},
    onShopNowClick: () -> Unit = {}
) {
    var selectedTabIndex by remember { mutableStateOf(1) } // Default to Completed tab

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "My Orders",
                        modifier = Modifier
                            .width(200.dp).padding(start=60.dp),

                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBackClick,
                        modifier = Modifier.padding(start=17.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.arrow_left_icon),
                            contentDescription = "Back",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                ),
                modifier = Modifier.padding(top=60.dp)
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            TabRow(
                selectedTabIndex = selectedTabIndex,
                containerColor = MaterialTheme.colorScheme.surface,
                indicator = { tabPositions ->
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .wrapContentSize(Alignment.BottomStart)
                            .padding(start = tabPositions[selectedTabIndex].left + (tabPositions[selectedTabIndex].width / 2) - 60.dp)
                    ) {
                        Box(
                            Modifier
                                .width(120.dp)
                                .height(3.dp)
                                .background(
                                    color = if (selectedTabIndex == 1) Color(0xFF19B579) else Color.Black,
                                    shape = RoundedCornerShape(2.dp)
                                )
                        )
                    }
                }
            ) {
                Tab(
                    selected = selectedTabIndex == 0,
                    onClick = { selectedTabIndex = 0 },
                    text = {
                        Text(
                            "Active",
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black
                        )
                    }
                )
                Tab(
                    selected = selectedTabIndex == 1,
                    onClick = { selectedTabIndex = 1 },
                    text = {
                        Text(
                            stringResource(R.string.Completed),
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF19B579)
                        )
                    }
                )
            }

            when (selectedTabIndex) {
                0 -> ActiveOrdersPlaceholder(onClick = onActiveOrdersClick)
                1 -> CompletedOrdersEmptyState(onClick = onShopNowClick)
            }
        }
    }
}

@Composable
private fun CompletedOrdersEmptyState(onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 172.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = R.drawable.truck_icon),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
            modifier = Modifier
                .width(100.dp)
                .height(80.dp)
        )

        Spacer(modifier = Modifier.height(26.dp))

        Text(
            text = "No completed order!",
            style = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
        )

        Box(modifier = Modifier.fillMaxSize()) {
            Surface(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .width(311.dp)
                    .height(60.dp)
                    .padding(bottom = 29.dp),
                shape = RoundedCornerShape(55.dp),
                color = Color.White,
                border = BorderStroke(1.6.dp, Color(0xFF19B579))
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { /* Home */ }) {
                        Icon(
                            painter = painterResource(R.drawable.home_icon),
                            contentDescription = "",
                            modifier = Modifier.size(22.dp)
                        )
                    }
                    IconButton(onClick = { /* Orders */ }) {
                        Icon(
                            painter = painterResource(R.drawable.order_icon),
                            contentDescription = "",
                            modifier = Modifier.size(22.dp)
                        )
                    }
                    IconButton(onClick = { /* Profile or other */ }) {
                        Icon(
                            painter = painterResource(R.drawable.profile_icon),
                            contentDescription = "",
                            modifier = Modifier.size(22.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ActiveOrdersPlaceholder(onClick: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Active orders screen would appear here")
    }
}



