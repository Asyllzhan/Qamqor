package com.example.qamqor.qamqor

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.qamqor.R

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.dp

@Composable
fun ProjectPageeee(navController: NavController) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
//        Text(
//            text = "Категории",
//            fontSize = 24.sp,
//            fontWeight = FontWeight.Bold,
//            modifier = Modifier.padding(bottom = 16.dp)
//        )
            Image(
                painter = painterResource(id = R.drawable.logo), // Replace with your logo resource
                contentDescription = "Logo",
                modifier = Modifier.size(200.dp)
            )

       // val categories = listOf("Nature", "Animals", "Technology")

        /*categories.forEach { category ->
            Button(
                onClick = { navController.navigate(category) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)  // Adjust button height
                    .padding(vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2B802B)  // Modern purple color, customize as needed
                ),
                shape = RoundedCornerShape(24.dp),  // Rounded corners
                elevation = ButtonDefaults.buttonElevation(  // Add elevation for shadow effect
                    defaultElevation = 8.dp,
                    pressedElevation = 2.dp
                )
            ) {
                Text(
                    text = category,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White  // White text color for contrast
                )
            }
        }*/
            CategoryDropdownMenu(navController)

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
fun CategoryDropdownMenu(navController: NavController) {
    val categories = listOf("Nature", "Animals", "Study")
    var expanded by remember { mutableStateOf(false) }
    var selectedCategory by remember { mutableStateOf(categories.first()) }

    Column(modifier = Modifier.padding(16.dp)) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = { expanded = true },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2B802B)),
                shape = RoundedCornerShape(24.dp)
            ) {
                Text(
                    text = "Категории",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            // DropdownMenu
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                categories.forEach { category ->
                    DropdownMenuItem(
                        text = {  // Correct parameter usage for recent Compose versions
                            Text(
                                text = category,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color.Black
                            )
                        },
                        onClick = {
                            selectedCategory = category
                            expanded = false
                            navController.navigate(category)
                        }
                    )
                }
            }
        }
    }
}
