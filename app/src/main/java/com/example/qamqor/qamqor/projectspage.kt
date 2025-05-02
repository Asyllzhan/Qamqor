package com.example.qamqor.qamqor

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.qamqor.R
import com.example.qamqor.ui.theme.QamqorTheme


@Preview(showBackground = true)
@Composable
fun GreetingPrevieww() {
    projectpage()
}

@Composable
fun projectpage(){
    val categories = listOf("Образование", "Медицина", "Экология", "Социальное развитие")


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ima),
            contentDescription = "Project Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(bottom = 16.dp),
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

        // Description of the product
        Text(
            text = "Description of the first product",
            fontSize = 20.sp,
            color = Color.Gray,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            textAlign = TextAlign.Start
        )

        // Amount raised text
        Text(
            text = "270₸ собрано из 200,000₸",
            fontSize = 20.sp,
            color = Color(0xFF4DFF00),
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            textAlign = TextAlign.Start
        )
    }
   /* Image(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = "imm",
        modifier = Modifier
            .width(410.dp)
            .height(206.dp)
    )

    Text(
        text = "Projects",
        fontSize = 32.sp,
        color = Color(0xFF245924),
        modifier = Modifier
           // .align(Alignment.TopCenter) // Выровнять текст по верхнему краю и центру
            .padding(top = 20.dp), // Добавляем отступ сверху
        textAlign = TextAlign.Center // Центрируем текст по горизонтали
    )*/

    LazyRow(
        modifier = Modifier.padding(vertical = 8.dp)
    ) {
        items(categories) { category ->
            CategoryItem(category)
        }
    }
}


@Composable
fun CategoryItem(category: String) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .height(50.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF6200EE) // Background color
        )
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = category,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}