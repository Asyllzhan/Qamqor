package com.example.qamqor.qamqor

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.toRoute
import com.example.qamqor.R
import com.example.qamqor.ui.theme.ProfilePage
import java.net.URLDecoder
import java.nio.charset.StandardCharsets
//a@gmail.com
@Composable
fun BottomNavBar(navController: NavController) {
    val items = listOf(
        NavigationItems.Home,
        NavigationItems.Project,
        NavigationItems.Chat,
        NavigationItems.Profile
    )
    NavigationBar(containerColor = Color.White) {
        val navBackStackEntry = navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry.value?.destination?.route
        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon), // Use painterResource to load drawable
                        contentDescription = item.title
                    )
                },
                label = { Text(text = item.title) },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.popBackStack(navController.graph.startDestinationId, false)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

@Composable
fun SetupNavigationn(navController: NavHostController) {

    NavHost(navController, startDestination = NavigationItems.Home.route) {
        composable(NavigationItems.Home.route) {
            MainnPage(navController)
        }
//        composable(NavigationItems.Search.route) {
//            projectpage()
//        }
        composable(NavigationItems.Chat.route){
            HelpRequestPage(navController)
        }
        composable(NavigationItems.Profile.route) {
            ProfilePage(navController)
        }
        composable("about_us") { AboutUsPage(navController) }

        composable(NavigationItems.Project.route) {
            ProjectPageeee(navController) }


        composable("Nature") { NatureCategoryPage(navController) }
        composable("Animals") { AnimalsCategoryPage(navController) }
        composable("Study") { TechnologyCategoryPage(navController) }

        composable(
            route = "projectDetail/{projectName}/{imageResId}/{cost}/{title}/{description}",
            arguments = listOf(
                navArgument("projectName") { type = NavType.StringType },
                navArgument("imageResId") { type = NavType.IntType },
                navArgument("description") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val projectName = backStackEntry.arguments?.getString("projectName") ?: "No Name"
            val imageResId =
                backStackEntry.arguments?.getInt("imageResId") ?: R.drawable.suret
            val cost = backStackEntry.arguments?.getString("cost") ?: "No Cost"
            val title = backStackEntry.arguments?.getString("title") ?: "No Title"
            val description = backStackEntry.arguments?.getString("description") ?: "No Description"
            ProjectDetailPage(navController, projectName, imageResId,cost,title, description)
        }
        composable("paymentForm/{projectName}") { backStackEntry ->
            PaymentFormPage(
                navController,
                projectName = backStackEntry.arguments?.getString("projectName") ?: ""
            )
        }
//a@gmail.com

        composable("receipt/{projectName}/{amount}") { backStackEntry ->
            ReceiptPage(
                navController,
                projectName = backStackEntry.arguments?.getString("projectName") ?: "",
                amount = backStackEntry.arguments?.getString("amount") ?: ""
            )
        }

        composable(
            route = "news/{title}/{description}/{imageResId}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("description") { type = NavType.StringType },
                navArgument("imageResId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val encodedTitle = backStackEntry.arguments?.getString("title") ?: "No Title"
            val encodedDescription = backStackEntry.arguments?.getString("description") ?: "No Description"
            val imageResId = backStackEntry.arguments?.getInt("imageResId") ?: R.drawable.suret


            val title = URLDecoder.decode(encodedTitle, StandardCharsets.UTF_8.toString())
            val description = URLDecoder.decode(encodedDescription, StandardCharsets.UTF_8.toString())


            NewsPage(navController, title, description, imageResId)
        }


    }
}

@Composable
fun ChatScreen() {
    Text(text = "ChatPage")
}

@Composable
fun SearchScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Search Screen")
    }
}

@Composable
fun ProfileScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Profile Screen")
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavBar(navController)
        }
    )
    { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            SetupNavigationn(navController = navController)
        }
    }
}

@Composable
fun NavigationToHomeP(navController: NavHostController) {
//    val navController = rememberNavController()
//
//    NavHost(navController = navController, startDestination = "projectPage") {
//        composable("projectPage") { ProjectPageeee(navController) }
//        composable("Nature") { NatureCategoryPage(navController) }
//        composable("Animals") { AnimalsCategoryPage(navController) }
//        composable("Technology") { TechnologyCategoryPage(navController) }
//
//        composable(
//            route = "projectDetail/{projectName}/{imageResId}/{cost}/{title}/{description}",
//            arguments = listOf(
//                navArgument("projectName") { type = NavType.StringType },
//                navArgument("imageResId") { type = NavType.IntType },
//                navArgument("description") { type = NavType.StringType }
//            )
//        ) { backStackEntry ->
//            val projectName = backStackEntry.arguments?.getString("projectName") ?: "No Name"
//            val imageResId =
//                backStackEntry.arguments?.getInt("imageResId") ?: R.drawable.suret
//            val cost = backStackEntry.arguments?.getString("cost") ?: "No Cost"
//            val title = backStackEntry.arguments?.getString("title") ?: "No Title"
//            val description = backStackEntry.arguments?.getString("description") ?: "No Description"
//            ProjectDetailPage(navController, projectName, imageResId,cost,title, description)
//        }
//        composable("paymentForm/{projectName}") { backStackEntry ->
//            PaymentFormPage(
//                navController,
//                projectName = backStackEntry.arguments?.getString("projectName") ?: ""
//            )
//        }
//        composable("receipt/{projectName}/{amount}") { backStackEntry ->
//            ReceiptPage(
//                navController,
//                projectName = backStackEntry.arguments?.getString("projectName") ?: "",
//                amount = backStackEntry.arguments?.getString("amount") ?: ""
//            )
//        }
    //}
    //----------------------------------------------------------
//    val navController = rememberNavController()
//
//    NavHost(navController = navController, startDestination = "signIn") {
//
//        composable("signIn") {
//            login(navController = navController, onNavigateToMainScreen =
//            { navData -> navController.navigate(navData)// Pass the navController here
//            })
//        }
//
//        composable("signUp") {
//            signpage(navController = navController, onNavigateToMainScreen =
//            { navData -> navController.navigate(navData)// Pass the navController here
//            }) }
//        composable("mainScreen") {
//            MainScreen()
//        }
//    }




//    NavHost(navController = navController, startDestination = "categories") {
//        composable("categories") {
//            CategoryListPage(navController)
//        }
//        composable("categoryDetail/{categoryId}") { backStackEntry ->
//            val categoryId = backStackEntry.arguments?.getString("categoryId")
//            CategoryDetailPage(navController, categoryId ?: "")
//        }
//        composable("imageDetail/{imageId}") { backStackEntry ->
//            val imageId = backStackEntry.arguments?.getString("imageId")
//            ImageDetailPage(navController, imageId ?: "")
//        }
//    }


    val navController = rememberNavController()

    // Define the navigation graph
    NavHost(navController = navController, startDestination = "login") {
        // Login screen
        composable("login") {
            login(onNavigateToMainScreen = { navData ->
                    // Navigate to the main screen after successful login
                    navController.navigate("main")},
                onNavigateToSignUp = {
                    // Navigate to Sign Up screen
                    navController.navigate("signup")
            })
        }
        // Sign Up screen
        composable("signup") {
            SignUpPage(onNavigateToMainScreen = { userData ->
                // Navigate to the main screen after successful sign-up
                navController.navigate("main") },
                onNavigateToSignIn = {
                    // Navigate to Sign Up screen
                    navController.navigate("login")
                })
        }
        // Main screen
        composable("main") {
            // Your main screen composable
            MainScreen()
        }
    }
//    NavHost(navController, startDestination = loginscreenObjebt) {
//        composable<loginscreenObjebt> {
//            login { navData ->
//                navController.navigate(navData)
//
//            }
//        }
//        composable<MainScreendataobject> { navEntry ->
//            val navData = navEntry.toRoute<MainScreendataobject>()
//            MainScreen()
//        }
//        composable("signup") {
//            SignUpPage(onNavigateToMainScreen = {navData ->
//                navController.navigate(navData)
//            })
//        }
//    }
}
//asilzhan.bakytzhan.gmail.com