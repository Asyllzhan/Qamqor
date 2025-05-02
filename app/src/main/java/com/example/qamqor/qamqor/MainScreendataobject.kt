package com.example.qamqor.qamqor


import kotlinx.serialization.Serializable

@Serializable
data class MainScreendataobject(
    val uid: String = "",
    val email: String = ""
)
