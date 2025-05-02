package com.example.qamqor.qamqor
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.qamqor.R
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
   // MainnPage()
}

@Composable
fun MainnPage(navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp), // Added padding for space below the box
                contentAlignment = Alignment.BottomCenter,
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color(0xFF4D81E7) // Back arrow color
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.ima),
                    contentDescription = "imm",
                    modifier = Modifier
                        .width(410.dp)
                        .height(206.dp)
                )
                Text(
                    text = "Все начинается с \nдоброго намерения",
                    fontSize = 32.sp,
                    color = Color(0xFF245924),
                    modifier = Modifier
                        .align(Alignment.TopCenter) // Выровнять текст по верхнему краю и центру
                        .padding(top = 20.dp), // Добавляем отступ сверху
                    textAlign = TextAlign.Center // Центрируем текст по горизонтали
                )
                Spacer(modifier = Modifier.height(8.dp))
                /*Button(
                    onClick = { /* Add your action here */ },
                    modifier = Modifier
                        .width(112.dp)
                        .padding(16.dp)
                        .height(40.dp),
                    shape = RoundedCornerShape(30.dp),  // Border radius only for top-left corner
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2B802B)  // Background color
                    )
                ) {
                    Text(
                        text = "Хочу помочь",
                        fontSize = 13.sp,
                        color = Color.White,  // Text color
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                }*/ /*Button(
                onClick = {},
                shape = RoundedCornerShape(30.dp),  // Border radius only for top-left corner
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2B802B) // Custom green color
                ),
                modifier = Modifier
                    .padding(16.dp)
                    .height(44.dp)
                    .width(114.dp)
            ) {
                Text(
                    text = "Хочу помочь",
                    color = Color.White,   // Set text color
                    fontSize = 10.sp,      // Increase font size for better readability
                    fontWeight = FontWeight.Bold
                )
            }*/
            }
        }
        item {
            Card(
                modifier = Modifier
                    .padding(vertical = 2.dp, horizontal = 24.dp)
                    .width(361.dp)
                    .height(465.dp),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFF4F4F4) // Background color
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    //.padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // First Text Block (О нас)
                    /*Box(
                        modifier = Modifier
                            //.background(Color(0xFF2B802B))
                            .width(84.dp)
                            .height(38.dp),
                        contentAlignment = Alignment.Center
                    ) {*/
                    Text(
                        text = "О нас",
                        fontSize = 32.sp,  // Slightly smaller font size for the header
                        color = Color(0xFF2B802B),
                        maxLines = 1,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )


                    Spacer(modifier = Modifier.height(15.dp))  // Space between text blocks

                    // Second Text Block
                    Text(
                        text = "В Qamqor мы убеждены, что каждое доброе дело начинается с искреннего намерения. Наша миссия — объединить людей, которые хотят помочь нуждающимся и сделать мир лучше. Мы предлагаем прозрачную и безопасную платформу для благотворительности, поддерживающую разнообразные социальные проекты.\n\nНаши цели:\n- Поддерживать социальные и благотворительные инициативы.\n- Предоставить каждому возможность внести вклад в общество.\n- Обеспечить прозрачность и доверие в каждом проекте.\n\nПрисоединяйтесь к нам и станьте частью мира, полного доброты и заботы!",
                        fontSize = 16.sp,  // Medium text size
                        color = Color.Black,
                        lineHeight = 18.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .width(326.dp)
                        // .height(385.dp)
                        //.padding(bottom = 8.dp)
                        //.padding(horizontal = 16.dp)  // Added horizontal padding for better spacing
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { navController.navigate("about_us") },  // Навигация на "О нас"
                modifier = Modifier
                    .width(118.dp)
                    .height(40.dp),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF2B802B)
                )
            ) {
                Text(
                    text = "Подробнее",
                    fontSize = 13.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.height(25.dp))
            Text(
                text = "Наша команда",
                fontSize = 28.sp,
                color = Color(0xFF2B802B),  // Text color
                //fontWeight = FontWeight.Black,
                textAlign = TextAlign.Center
            )
        }
        item {
            ProductInfoCard(imageResId = R.drawable.adam, adamaty = "Zanggar Dastan")
            ProductInfoCard(imageResId = R.drawable.adam, adamaty = "Elsultan Bagitzhanov")
            ProductInfoCard(imageResId = R.drawable.assyl, adamaty = "Assylzhan Bitore")
            ProductInfoCard(imageResId = R.drawable.nurai, adamaty = "Nuray Kavkayeva")
            ProductInfoCard(imageResId = R.drawable.alfia, adamaty = "Alfiya Beressova")
            Spacer(modifier = Modifier.height(25.dp))
        }
        // Spacer(modifier = Modifier.height())
        item {
            Text(
                text = "Наши программы",
                fontSize = 26.sp,
                color = Color(0xFF2B802B),  // Text color
                //fontWeight = FontWeight.Black,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Наш фонд предлагает широкий спектр \nпрограмм, каждая из которых направлена на \nподдержку и помощь нуждающимся.",
                fontSize = 16.sp,  // Medium text size
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(379.dp)
                //.height(48.dp)
                //.padding(horizontal = 16.dp)  // Added horizontal padding for better spacing
            )
            ProductInfoCar(
                imageResId = R.drawable.imm3,
                adamaty = "Помощь детям",
                title = "Мы оказываем помощь детям, нуждающимся в поддержке и заботе."
            )
            ProductInfoCar(
                imageResId = R.drawable.imm2,
                adamaty = "Забота о пожилых",
                title = "Заботимся о пожилых людях, обеспечивая им комфорт и заботу."
            )
            ProductInfoCar(
                imageResId = R.drawable.imm1,
                adamaty = "Поддержка людей с ограниченными возможностями",
                title = "Мы помогаем людям с ограниченными возможностями улучшить качество жизни."
            )
            ProductInfoCar(
                imageResId = R.drawable.imm3,
                adamaty = "Помощь животным",
                title = "Мы помогаем бездомным животным найти любящие семьи."
            )
        }
        item {
            Text(
                text = "Нововсти",
                fontSize = 26.sp,
                color = Color(0xFF2B802B),  // Text color
                //fontWeight = FontWeight.Black,
                textAlign = TextAlign.Center
            )
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp), // Vertical padding for spacing
                horizontalArrangement = Arrangement.spacedBy(21.dp) // Gap between cards
            ) {
                item {
                    CardGridLazyRow(
                        imageResId = R.drawable.imm3,  // Replace with your dynamic image resource
                        zhanaty = "Благотворительная кампания п...",  // Replace with dynamic data
                        title = "Мы рады сообщить, что наша кампа...", // Replace with dynamic data
                        navController = navController
                    )
                    CardGridLazyRow(
                        imageResId = R.drawable.imm1,  // Replace with your dynamic image resource
                        zhanaty = "Составлен новый график разда...",  // Replace with dynamic data
                        title = "В этом месяце мы обновили график ра...", // Replace with dynamic data
                        navController = navController
                    )
                    CardGridLazyRow(
                        imageResId = R.drawable.imm2,  // Replace with your dynamic image resource
                        zhanaty = "Благодаря вашей помощи мы п...",  // Replace with dynamic data
                        title = "С радостью сообщаем, что благодаря ...", // Replace with dynamic data
                        navController = navController
                    )
                }
            }
        }
    }
}

@Composable
fun ProductInfoCard(imageResId: Int, adamaty: String) {
    val imageResId = painterResource(id = imageResId)
    Card(
        modifier = Modifier
            .width(240.dp)
            .height(324.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp), // Border radius
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        border = BorderStroke(1.dp, Color(0xFFD9D9D9)), // Border color
        colors = CardDefaults.cardColors(containerColor = Color.White) // Background color
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            // Image Section
            Box(
                modifier = Modifier
                    .width(208.dp)
                    .height(247.dp)
                    .background(Color(0xFFE3E3E3)) // Background for the placeholder image
                // .align(Alignment.Center) // Ensures the image is centered within the Box
            ) {
                Image(
                    painter = imageResId,
                    contentDescription = "News Image",
                    modifier = Modifier
                        .fillMaxSize() // Ensures the image takes up the entire space of the Box
                        .align(Alignment.Center), // Centers the image within the Box
                    contentScale = ContentScale.Crop // Use ContentScale.Crop to make the image fill the space while maintaining the aspect ratio
                )
            }
            Spacer(modifier = Modifier.height(16.dp)) // Space between image and text
            Text(
                text = adamaty,
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(208.dp)
                    .height(22.dp)
            )
        }
    }
}


@Composable
fun ProductInfoCar(imageResId: Int, adamaty: String, title: String) {
    val imageResId = painterResource(id = imageResId)
    Card(
        modifier = Modifier
            .width(240.dp)
            // .height(385.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp), // Border radius
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        border = BorderStroke(1.dp, Color(0xFFD9D9D9)), // Border color
        colors = CardDefaults.cardColors(containerColor = Color.White) // Background color
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            // Image Section
            Box(
                modifier = Modifier
                    .width(208.dp)
                    .height(247.dp)
                    .background(Color(0xFFE3E3E3)) // Background for the placeholder image
                // .align(Alignment.Center) // Ensures the image is centered within the Box
            ) {
                Image(
                    painter = imageResId,
                    contentDescription = "News Image",
                    modifier = Modifier
                        .fillMaxSize() // Ensures the image takes up the entire space of the Box
                        .align(Alignment.Center), // Centers the image within the Box
                    contentScale = ContentScale.Crop // Use ContentScale.Crop to make the image fill the space while maintaining the aspect ratio
                )
            }
            Spacer(modifier = Modifier.height(16.dp)) // Space between image and text
            Text(
                text = adamaty,
                fontSize = 18.sp,
                color = Color(0xFF2B802B),
                fontWeight = FontWeight.Bold,
                //textAlign = TextAlign.Start,
                modifier = Modifier
                    .width(208.dp)
                //.height(66.dp)
            )
            Text(
                text = title,
                fontSize = 15.sp,  // Medium text size
                color = Color(0xFF757575),
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .width(208.dp)
                // .height(60.dp)
            )
        }
    }
}
@Composable
fun CardGridLazyRow(
    imageResId: Int,
    zhanaty: String,
    title: String,
    navController: NavController
) {
    //val imageResId = painterResource(id = imageResId)
    val encodedTitle = URLEncoder.encode(title, StandardCharsets.UTF_8.toString())
    val encodedDescription = URLEncoder.encode(zhanaty, StandardCharsets.UTF_8.toString())

    Card(
        modifier = Modifier
            .clickable {
                // Navigate to NewsPage with the necessary arguments
                navController.navigate("news/$encodedTitle/$encodedDescription/$imageResId")
            }
            .width(240.dp)
            // .height(385.dp)
            .padding(8.dp),

        shape = RoundedCornerShape(8.dp), // Border radius
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        border = BorderStroke(1.dp, Color(0xFFD9D9D9)), // Border color
        colors = CardDefaults.cardColors(containerColor = Color.White) // Background color
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)

        ) {
            // Image Section  a@gmail.com
            Box(
                modifier = Modifier
                    .width(208.dp)
                    .height(247.dp)
                    .background(Color(0xFFE3E3E3)) // Background for the placeholder image
                   // .align(Alignment.Center) // Ensures the image is centered within the Box
            ) {
                Image(
                    painter = painterResource(id = imageResId),
                    contentDescription = "News Image",
                    modifier = Modifier
                        .fillMaxSize() // Ensures the image takes up the entire space of the Box
                        .align(Alignment.Center), // Centers the image within the Box
                    contentScale = ContentScale.Crop // Use ContentScale.Crop to make the image fill the space while maintaining the aspect ratio
                )
            }
            Spacer(modifier = Modifier.height(16.dp)) // Space between image and text
            Text(
                text = zhanaty,
                fontSize = 18.sp,
                color = Color(0xFF2B802B),
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                //textAlign = TextAlign.Start,
                modifier = Modifier
                    .width(208.dp)
            )
            Text(
                text = title,
                fontSize = 15.sp,  // Medium text size
                color = Color(0xFF757575),
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .width(208.dp)
                // .height(60.dp)
            )
        }
    }
}


