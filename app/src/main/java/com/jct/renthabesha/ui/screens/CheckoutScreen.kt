package com.jct.renthabesha.ui.screens




import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jct.renthabesha.R
import com.jct.renthabesha.ui.screens.components.ButtonCompos
import com.jct.renthabesha.ui.theme.RentHabeshaTheme


data class Order(
    val imageRes: Int,
    val title: String,
    val price: String,
    val quantity: Int
)
@Composable
fun CheckoutScreen() {
    val orders = listOf(
        Order(R.drawable.img_nine, "Ethiopian Suit", "ETB 2,000", 2),
        Order(R.drawable.img_twenty_one, "Habesha Kemis", "ETB 2,500", 1),
        Order(R.drawable.img_eight, "Ethiopian Suit", "ETB 1,500", 1),
        Order(R.drawable.img_twelve, "Netela", "ETB 1,500", 1)
    )

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(bottom = 118.dp,top=59.dp) // Space for fixed button
                .padding(horizontal = 15.dp)
        ) {
            // Header Section
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /* Handle back */ }) {
                    Icon(
                        painter = painterResource(R.drawable.arrow_left_icon),
                        contentDescription = "Back",
                        modifier = Modifier.size(24.dp)
                    )
                }
                Text(
                    text = "Checkout",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            // Shipping Address
            Column {
                Text(
                    text = "Shipping Address",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        painter = painterResource(R.drawable.location_icon),
                        contentDescription = null,
                        tint = Color(0xFF19B579),
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text("Home", style = MaterialTheme.typography.titleMedium)
                        Text(
                            "Addis Ababa, 4killo",
                            style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray)
                        )
                    }
                    Text(
                        "Change",
                        style = MaterialTheme.typography.bodyMedium.copy(color = Color(0xFF19B579))
                    )
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            // Order List
            Text(
                "Order List",
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(5.dp))

            // Order Items - Inlined implementation
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))

            ) {
                orders.forEachIndexed { index, order ->
                    if (index > 0) {
                        Divider(
                            color = Color.LightGray,
                            thickness = 1.dp,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier)
                    }
                    // Inlined order item implementation
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(order.imageRes),
                            contentDescription = null,
                            modifier = Modifier
                                .width(90.dp).height(100.dp)
                                .clip(RoundedCornerShape(8.dp)),
                            contentScale = ContentScale.Crop
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                order.title,
                                style = MaterialTheme.typography.titleMedium.copy(
                                    fontWeight = FontWeight.Bold
                                )
                            )
                            Spacer(modifier = Modifier.height(3.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(26.dp)
                            ) {
                                Text("Tolat Price", style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray))
                                Text(order.price, style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold))
                            }
                            Spacer(modifier = Modifier.height(2.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(66.dp)
                            ) {
                                Text("Quantity", style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray))
                                Text(order.quantity.toString(), style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold))
                            }
                        }
                    }


                }
            }
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
                    text = R.string.continue_to_payment
                ) }
        }
    }
}
