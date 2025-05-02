package com.example.qamqor.qamqor


import com.example.qamqor.R

sealed class NavigationItems(val route: String, val icon: Int, val title: String){
    data object Home: NavigationItems("home", R.drawable.home, "Home")
    data object Project: NavigationItems("projects",  R.drawable.projj, "Projects")
    data object Chat: NavigationItems("chat", R.drawable.chhh, "Chat")
    data object Profile: NavigationItems("profile", R.drawable.per, "Profile")
}
//a@gmail.com