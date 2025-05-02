package com.example.qamqor.qamqor

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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


@Composable
fun NatureCategoryPage(navController: NavController) {
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
fun TechnologyCategoryPage(navController: NavController) {
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
