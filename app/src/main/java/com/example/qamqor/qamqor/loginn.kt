package com.example.qamqor.qamqor

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.qamqor.R
import com.example.qamqor.ui.theme.Pk4
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
@Composable
fun SignUpPage(onNavigateToMainScreen: (MainScreendataobject) -> Unit, onNavigateToSignIn: () -> Unit) {
    val auth = remember { Firebase.auth }
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    val confirmPasswordState = remember { mutableStateOf("") }
    val errorState = remember { mutableStateOf("") }
    val isPasswordVisible = remember { mutableStateOf(false) }
    val isRememberMeChecked = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(listOf(Color(0xFF4CAF50), Color.White))) // Gradient background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),  // Add more padding
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
//            Image(
//                painter = painterResource(id = R.drawable.logo),
//                contentDescription = "Login Logo",
//                modifier = Modifier
//                    .size(120.dp)
//                    .clip(RoundedCornerShape(20.dp))
//            )

            Spacer(modifier = Modifier.height(16.dp))

            // Title
            Text(
                text = "Welcome Back!",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF2B2B2B)
                ),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Card for the SignUp Form
            Card(
                modifier = Modifier.fillMaxWidth(), // Adds shadow for a more modern feel
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 4.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White // Background color
                )
            ) {
                Column(
                    modifier = Modifier
                        .padding(24.dp) // Padding inside the card
                        .fillMaxWidth()
                ) {
                    // Email Field
                    RoundedCornerTextField(
                        text = emailState.value,
                        label = "Email",
                        onTextChange = { emailState.value = it }
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // Password Field
                    RoundedCornerTextField(
                        text = passwordState.value,
                        label = "Password",
                        onTextChange = { passwordState.value = it },
                        isPasswordVisible = isPasswordVisible.value,
                        onPasswordVisibilityToggle = { isPasswordVisible.value = it }
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // Confirm Password Field
                    RoundedCornerTextField(
                        text = confirmPasswordState.value,
                        label = "Confirm Password",
                        onTextChange = { confirmPasswordState.value = it },
                        isPasswordVisible = isPasswordVisible.value,
                        onPasswordVisibilityToggle = { isPasswordVisible.value = it }
                    )

                    // Error Message
                    if (errorState.value.isNotEmpty()) {
                        Text(
                            text = errorState.value,
                            color = Color.Red,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Sign Up Button
                    Button(
                        onClick = {
                            signUp(
                                auth,
                                emailState.value,
                                passwordState.value,
                                confirmPasswordState.value,
                                onSuccess = { userData ->
                                    onNavigateToMainScreen(userData)
                                },
                                onFailure = { error ->
                                    errorState.value = error
                                }
                            )
                        },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp), // Rounded corners
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
                        contentPadding = PaddingValues(vertical = 16.dp) // More padding
                    ) {
                        Text("Sign Up", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Navigate to Login Page
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Already have an account?",
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Login",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF4CAF50),
                            modifier = Modifier.clickable {
                                onNavigateToSignIn()
                                // Navigate to Login
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun RoundedCornerTextField(
    text: String,
    label: String,
    onTextChange: (String) -> Unit,
    isPasswordVisible: Boolean = false,
    onPasswordVisibilityToggle: (Boolean) -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    TextField(
        value = text,
        onValueChange = { onTextChange(it) },
        label = { Text(text = label) },
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            if (label == "Password" || label == "Confirm Password") {
                IconButton(onClick = { onPasswordVisibilityToggle(!isPasswordVisible) }) {
                    val iconRes = if (isPasswordVisible) R.drawable.coz else R.drawable.coz
                    Icon(
                        painter = painterResource(id = iconRes),
                        contentDescription = "Toggle Password Visibility"
                    )
                }

            }
        },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.Gray.copy(alpha = 0.3f), RoundedCornerShape(12.dp)) // Rounded border
            .padding(16.dp),
        keyboardActions = KeyboardActions(
            onDone = {
                keyboardController?.hide()
            }
        ),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = if (label == "Password" || label == "Confirm Password") KeyboardType.Password else KeyboardType.Email
        )
    )
}

fun signUp(
    auth: FirebaseAuth,
    email: String,
    password: String,
    confirmPassword: String,
    onSuccess: (MainScreendataobject) -> Unit,
    onFailure: (String) -> Unit
) {
    if (email.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
        onFailure("Email and password cannot be empty")
        return
    }

    if (password != confirmPassword) {
        onFailure("Passwords do not match")
        return
    }

    auth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                onSuccess(
                    MainScreendataobject(
                        task.result.user?.uid ?: "",
                        task.result.user?.email ?: ""
                    )
                )
            } else {
                onFailure(task.exception?.message ?: "Unknown error")
            }
        }
}
