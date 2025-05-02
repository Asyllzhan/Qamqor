package com.example.qamqor.qamqor

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.qamqor.R
 // Import for card icon

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.filled.CheckCircle

@Composable
fun AnimalsCategoryPage(navController: NavController) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.size(48.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.Black
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Project Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(75.dp)
                        .padding(bottom = 16.dp)
                )
            }
            Text(
                text = "Projects",
                fontSize = 24.sp,
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
                textAlign = TextAlign.Start
            )
            Row {
                detailpagee(navController, "Project 1", "270₸", " собрано из 200,000₸", R.drawable.ima, "This is a detailed description of Project 1")
                detailpagee(navController, "Project 2", "270₸", " собрано из 200,000₸", R.drawable.target, "This is a detailed description of Project 2")
            }
            Row {
                detailpagee(navController, "Project 1", "270₸", " собрано из 200,000₸", R.drawable.imm1, "This is a detailed description of Project 1")
                detailpagee(navController, "Project 2", "270₸", " собрано из 200,000₸", R.drawable.imm2, "This is a detailed description of Project 2")
            }
            Row {
                detailpagee(navController, "Project 1", "270₸", " собрано из 200,000₸", R.drawable.imm3, "This is a detailed description of Project 1")
                detailpagee(navController, "Project 2", "270₸", " собрано из 200,000₸", R.drawable.ima, "This is a detailed description of Project 2")
            }
            Row {
                detailpagee(navController, "Project 1", "270₸", " собрано из 200,000₸", R.drawable.ima, "This is a detailed description of Project 1")
                detailpagee(navController, "Project 2", "270₸", " собрано из 200,000₸", R.drawable.target, "This is a detailed description of Project 2")
            }
            Row {
                detailpagee(navController, "Project 1", "270₸", " собрано из 200,000₸", R.drawable.ima, "This is a detailed description of Project 1")
                detailpagee(navController, "Project 2", "270₸", " собрано из 200,000₸", R.drawable.target, "This is a detailed description of Project 2")
            }
            Row {
                detailpagee(navController, "Project 1", "270₸", " собрано из 200,000₸", R.drawable.imm1, "This is a detailed description of Project 1")
                detailpagee(navController, "Project 2", "270₸", " собрано из 200,000₸", R.drawable.imm2, "This is a detailed description of Project 2")
            }
            Row {
                detailpagee(navController, "Project 1", "270₸", " собрано из 200,000₸", R.drawable.imm3, "This is a detailed description of Project 1")
                detailpagee(navController, "Project 2", "270₸", " собрано из 200,000₸", R.drawable.ima, "This is a detailed description of Project 2")
            }
            Row {
                detailpagee(navController, "Project 1", "270₸", " собрано из 200,000₸", R.drawable.ima, "This is a detailed description of Project 1")
                detailpagee(navController, "Project 2", "270₸", " собрано из 200,000₸", R.drawable.target, "This is a detailed description of Project 2") }
        }
    }
}

@Composable
fun detailpagee(
    navController: NavController,
    projectName: String,
    cost: String,
    title: String,
    imageResId: Int,
    description: String // Add a detailed description parameter
) {
    Card(
        shape = RoundedCornerShape(16.dp), // Rounded corners
        elevation = CardDefaults.cardElevation(8.dp), // Adds shadow
        modifier = Modifier
            .padding(4.dp)
            .clickable {
                navController.navigate("projectDetail/$projectName/$imageResId/$cost/$title/$description")
            }
    ) {
        Column(
            modifier = Modifier
                .width(200.dp)
                .background(MaterialTheme.colorScheme.surface) // Optional: add background color
                .padding(12.dp)
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = projectName,
                modifier = Modifier
                    .fillMaxWidth() // Adjust to match the container width
                    .height(120.dp) // Fixed height for all images
                    .clip(RoundedCornerShape(12.dp)) // Rounded corners
                    .background(Color.Gray) // Placeholder color for transparency
                    .aspectRatio(16f / 9f), // Optional: Maintain a consistent aspect ratio
                contentScale = ContentScale.Crop // Crops the image to fill the size without distortion
            )
            Spacer(modifier = Modifier.height(8.dp)) // Add space between image and text

            Text(
                text = projectName,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(4.dp)) // Add space between texts

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween // Align items with space between
            ) {
                Text(
                    text = cost,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF4DFF00) // Highlighted color
                )
                Text(
                    text = title,
                    fontSize = 13.sp,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f) // Slightly transparent
                )
            }
        }
    }
}
//a@gmail.com
@Composable
fun ProjectDetailPage(
    navController: NavController,
    projectName: String,
    imageResId: Int,
    cost: String,
    title: String,
    description: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5)) // Light background for modern look
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Back button at the top-left
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .align(Alignment.Start)
                .size(40.dp)
                .background(Color.White, shape = CircleShape)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color.Black
            )
        }

        // Content card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White // Set your desired color here
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            )

        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = imageResId),
                    contentDescription = projectName,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(16.dp))
                )

                Text(
                    text = projectName,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 16.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = cost,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color(0xFF4CAF50)
                    )
                    Text(
                        text = " • $title",
                        fontSize = 16.sp,
                        color = Color.Gray,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = description,
                    fontSize = 16.sp,
                    color = Color.DarkGray,
                    lineHeight = 22.sp
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Pay Now button with gradient effect
                Button(
                    onClick = { navController.navigate("paymentForm/$projectName") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2B802B) // Example modern color
                    ),
                    shape = RoundedCornerShape(28.dp),
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 8.dp
                    )
                ) {
                    Text(
                        text = "Pay Now",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        }
    }
}
@Composable
fun PaymentFormPage(navController: NavController, projectName: String) {
    var amount by remember { mutableStateOf("") }
    var cardNumber by remember { mutableStateOf("") }
    var expiryDate by remember { mutableStateOf("") }
    var cvc by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0F0F0))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier.padding(end = 8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Black
                )
            }
            Text(
                text = "Payment for $projectName",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF333333)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                OutlinedTextField(
                    value = amount,
                    onValueChange = { amount = it },
                    label = { Text("Amount") },
                    leadingIcon = { Icon(Icons.Default.Settings, contentDescription = "Amount") },  // Updated icon
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp)
                )

                OutlinedTextField(
                    value = cardNumber,
                    onValueChange = { cardNumber = it },
                    label = { Text("Card Number") },
                    leadingIcon = { Icon(Icons.Default.Add, contentDescription = "Card") },  // Updated icon
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    OutlinedTextField(
                        value = expiryDate,
                        onValueChange = { expiryDate = it },
                        label = { Text("Expiry Date") },
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(8.dp)
                    )

                    OutlinedTextField(
                        value = cvc,
                        onValueChange = { cvc = it },
                        label = { Text("CVC") },
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(8.dp),
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.NumberPassword)
                    )
                }

                Button(
                    onClick = { navController.navigate("receipt/$projectName/$amount") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("Pay Now", color = Color.White, fontSize = 18.sp)
                }
            }
        }
    }
}


@Composable
fun ReceiptPage(navController: NavController, projectName: String, amount: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0F0F0))  // Soft gray background
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        // Receipt Card
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(24.dp)
            ) {
                // Success Icon
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = "Success",
                    tint = Color(0xFF4CAF50),  // Green for success
                    modifier = Modifier.size(80.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))

                // Success Text
                Text(
                    text = "Payment Successful!",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF333333),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Project and Amount Details
                Text(
                    text = "Project: $projectName",
                    fontSize = 18.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "Amount Paid: $amount",
                    fontSize = 18.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Back Button
                Button(
                    onClick = { navController.popBackStack() },
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2B802B)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)

                ) {
                    Text(
                        text = "Back to Project",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        }
    }
}
