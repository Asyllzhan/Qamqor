package com.example.qamqor.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.example.qamqor.R
import com.example.qamqor.qamqor.detailpagee

@Composable
fun VideoPlayer(videoResId: Int) {
    val context = LocalContext.current
    val uri = "android.resource://${context.packageName}/$videoResId"
    val player = remember { ExoPlayer.Builder(context).build().apply {
        setMediaItem(MediaItem.fromUri(uri))
        prepare()
        playWhenReady = true
    }}

    AndroidView(
        factory = { ctx ->
            PlayerView(ctx).apply {
                this.player = player
            }
        },
        modifier = Modifier.fillMaxWidth().height(170.dp)

            .clip(RoundedCornerShape(16.dp))
            .background(Color.Black),

    )
}
@Composable
fun ProfilePage(navController: NavController) {
    var showVideo by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(vertical = 16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(R.drawable.suret),
            contentDescription = "QAMQOR",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .border(4.dp, Color.Gray, CircleShape)
        )

        Spacer(modifier = Modifier.height(16.dp))


        Text(
            text = "QAMQOR",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Text(
            text = "Total Donations: \$500",
            fontSize = 18.sp,
            color = Color.Gray,
            modifier = Modifier.padding(vertical = 4.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Your Donation Projects",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            textAlign = TextAlign.Center
        )

        Row() {
            detailpagee(navController, "Project 1", "200,000₸", " собрано ", R.drawable.ima, "This is a detailed description of Project 1")
            detailpagee(navController, "Project 2", "270₸", " собрано из 200,000₸", R.drawable.imm1, "This is a detailed description of Project 2")
        }
        Spacer(modifier = Modifier.height(32.dp))


        Row(
            modifier = Modifier
                .fillMaxWidth()

        ) {

            Button(
                onClick = { showVideo = !showVideo },
                modifier = Modifier
                    .weight(1f)
                    .height(56.dp)
                    .padding(8.dp)
                    .clip(RoundedCornerShape(12.dp)),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2B802B))
            ) {
                Text("Show Donation Results Video", textAlign = TextAlign.Center, color = Color.White)
            }
        }


        if (showVideo) {
            Spacer(modifier = Modifier.height(16.dp))
            VideoPlayer(videoResId = R.raw.video)
        }
    }
}

//a@gmail.com
//
//@Composable
//fun UserProfilePage(navController: NavController) {
//    var showVideo by remember { mutableStateOf(false) }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        // Информация о пожертвованиях пользователя
//        Text(
//            text = "Ваши пожертвования:",
//            style = MaterialTheme.typography.headlineMedium
//        )
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Пример информации о донате
//        Text(
//            text = "Проект: 'Помощь детям'\nСумма: 5000₸",
//            style = MaterialTheme.typography.bodyLarge
//        )
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Кнопка для воспроизведения видео
//        Button(
//            onClick = { showVideo = !showVideo },
//            modifier = Modifier.padding(8.dp)
//        ) {
//            Text(text = if (showVideo) "Скрыть видео" else "Показать видео")
//        }
//
//        // Видео-плеер
//        if (showVideo) {
//            VideoPlayer(videoUrl = "https://www.example.com/video.mp4")
//        }
//    }
//}
//
//@Composable
//fun VideoPlayer(videoUrl: String) {
//    val context = LocalContext.current
//    val exoPlayer = remember {
//        ExoPlayer.Builder(context).build().apply {
//            setMediaItem(MediaItem.fromUri(videoUrl))
//            prepare()
//            playWhenReady = true // Автовоспроизведение
//        }
//    }
//
//    DisposableEffect(
//        AndroidView(
//            factory = { context ->
//                PlayerView(context).apply {
//                    player = exoPlayer
//                }
//            },
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(200.dp)
//        )
//    ) {
//        onDispose {
//            exoPlayer.release() // Очистка ресурсов
//        }
//    }
//}
