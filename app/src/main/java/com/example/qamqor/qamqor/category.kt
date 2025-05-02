package com.example.qamqor.qamqor

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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


val categoryImages = mapOf(
    "Nature" to listOf("Forest", "Mountain", "Lake"),
    "Architecture" to listOf("Castle", "Skyscraper", "Bridge"),
    "Animals" to listOf("Lion", "Elephant", "Dolphin"),
    "Technology" to listOf("Robot", "Space Shuttle", "Smartphone")
)

@Composable
fun CategoryListPage(navController: NavController) {


    val categories =
        listOf("Nature", "Architecture", "Animals", "Technology")

    LazyColumn {
        items(categories) { category ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { navController.navigate("categoryDetail/$category") },
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFF6200EE) // Background color
                )
            ) {
                Text(
                    text = category,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(16.dp),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
// Define a data class for category content
data class CategoryContent(
    val title: String,
    val imageId: Int, // Store image resource ID
    val description: String // You can add more fields if necessary
)

// Define the content for each category
val categoryData = mapOf(
    "Nature" to CategoryContent(
        title = "Nature",
        imageId = R.drawable.ima, // Replace with your actual image resource ID
        description = "Explore the beauty of nature including forests, mountains, and lakes."
    ),
    "Animals" to CategoryContent(
        title = "Animals",
        imageId = R.drawable.logo, // Replace with your actual image resource ID
        description = "Discover a variety of animals from lions to dolphins."
    ),
    "Animals" to CategoryContent(
        title = "Animals",
        imageId = R.drawable.ima, // Replace with your actual image resource ID
        description = "Discover a variety of animals from lions to dolphins."
    ),

    // Add more categories as needed
)

@Composable
fun CategoryDetailPage(navController: NavController, categoryId: String) {
    // Fetch the category content from the map
    val categoryContent = categoryData[categoryId]

    // Check if category content exists, else display a fallback message
    if (categoryContent != null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            // Display the image
            Image(
                painter = painterResource(id = categoryContent.imageId),
                contentDescription = categoryContent.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(bottom = 16.dp)
            )

            // Display the title
            Text(
                text = categoryContent.title,
                fontSize = 24.sp,
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                textAlign = TextAlign.Start
            )

            // Display the description
            Text(
                text = categoryContent.description,
                fontSize = 18.sp,
                color = Color.Gray,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                textAlign = TextAlign.Start
            )

            // You can add more content or images related to the category here
        }
    } else {
        // Fallback in case no category content is found
        Text(text = "Category not found", fontSize = 20.sp)
    }
}

@Composable
fun ImageDetailPage(navController: NavController, imageId: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Details of $imageId",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Button(
            onClick = { navController.popBackStack() }, // Navigate back to category detail
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ima),
                contentDescription = "Project Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(bottom = 16.dp)
            )

            Text(
                text = "Project",
                fontSize = 24.sp,
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                textAlign = TextAlign.Start
            )
            Text("Back to Images")
        }
    }
}
