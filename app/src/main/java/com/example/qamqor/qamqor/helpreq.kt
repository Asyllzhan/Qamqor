package com.example.qamqor.qamqor

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.qamqor.R
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.auth.FirebaseAuth

@Composable
fun HelpRequestPage(navController: NavController) {
    val firestore = FirebaseFirestore.getInstance()
    val auth = FirebaseAuth.getInstance()
    var requestText by remember { mutableStateOf("") }
    var contactInfo by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFFF9F9F9)), // Light background color
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Add an illustrative image
        Image(
            painter = painterResource(id = R.drawable.logo),  // Replace with your image
            contentDescription = "Help Request",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)  // Rounded image
                .background(Color.White)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Title Text
        Text(
            text = "Помощь или Обратная связь",
            style = MaterialTheme.typography.headlineSmall.copy(
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2B802B)
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        // TextFields for request and contact info
        OutlinedTextField(
            value = requestText,
            onValueChange = { requestText = it },
            label = { Text("Опишите вашу просьбу") },
            leadingIcon = { Icon(Icons.Default.Edit, contentDescription = null) },
            modifier = Modifier.fillMaxWidth(),
            singleLine = false
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = contactInfo,
            onValueChange = { contactInfo = it },
            label = { Text("Ваш номер телефона или email") },
            leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                val currentUser = auth.currentUser
                if (currentUser != null && requestText.isNotBlank() && contactInfo.isNotBlank()) {
                    val request = hashMapOf(
                        "userId" to currentUser.uid,
                        "email" to currentUser.email,
                        "requestText" to requestText,
                        "contactInfo" to contactInfo,
                        "timestamp" to System.currentTimeMillis()
                    )

                    firestore.collection("userRequests")
                        .add(request)
                        .addOnSuccessListener { status = "Запрос отправлен!" }
                        .addOnFailureListener { e -> status = "Ошибка: ${e.message}" }
                } else {
                    status = "Заполните все поля!"
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2B802B)),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Отправить запрос", fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Display status message
        if (status.isNotEmpty()) {
            Text(
                text = status,
                color = if (status.contains("отправлен")) Color.Green else Color.Red,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}

//asilzhan.bakytzhan@gmail.com
