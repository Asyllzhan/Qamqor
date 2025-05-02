package com.example.qamqor.qamqor


import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.qamqor.R
import com.example.qamqor.ui.theme.Pk4
import com.example.qamqor.ui.theme.QamqorTheme
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth


@Preview(showBackground = true)
@Composable
fun GreetingPrevieew() {}
//   // login(
//        onNavigateToMainScreen = {
//            Log.d("Login", "Navigate to main screen")
//        }
//    )
//}
@Composable
fun login(onNavigateToMainScreen: (MainScreendataobject) -> Unit, onNavigateToSignUp: () -> Unit) {
    val auth = Firebase.auth
    var errorState by remember { mutableStateOf("") }
    var emailState by remember { mutableStateOf("") }
    var passwordState by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var rememberMeChecked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(listOf(Color(0xFF4CAF50), Color.White))) // Light background
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
//        Card(
//            modifier = Modifier.fillMaxWidth(), // Adds shadow for a more modern feel
//            shape = RoundedCornerShape(16.dp),
//            elevation = CardDefaults.cardElevation(
//                defaultElevation = 4.dp
//            ),
//            colors = CardDefaults.cardColors(
//                containerColor = Color.White // Background color
//            )
//        ) {
            // Logo or Image
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Login Logo",
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(20.dp))
            )

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

            Spacer(modifier = Modifier.height(8.dp))

            // Email Field
            RoundedCornerTextField(
                text = emailState,
                label = "Email",
                onTextChange = { emailState = it },
                leadingIcon = Icons.Default.Email // Add icon for email
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Password Field with Show/Hide
            RoundedCornerTextField(
                text = passwordState,
                label = "Password",
                onTextChange = { passwordState = it },
                isPassword = true,
                passwordVisible = passwordVisible,
                onPasswordToggle = { passwordVisible = !passwordVisible }
            )

            // Remember Me Checkbox
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                Checkbox(
                    checked = rememberMeChecked,
                    onCheckedChange = { rememberMeChecked = it },
                    colors = CheckboxDefaults.colors(checkedColor = Color(0xFF4D81E7))
                )
                Text(
                    text = "Remember Me",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Error message display
            if (errorState.isNotEmpty()) {
                Text(
                    text = errorState,
                    color = Color.Red,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Login Button
            Button(
                onClick = {
                    singnIn(
                        auth,
                        emailState,
                        passwordState,
                        onInSuccess = { navData ->
                            onNavigateToMainScreen(navData)
                        },
                        onInFailure = { error ->
                            errorState = error
                        }
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
            ) {
                Text("Sign In")
            }

            // Sign Up Navigation
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Don't have an account?",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Sign Up",
                    color = Color(0xFF4CAF50),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable {
                        onNavigateToSignUp()
                        // Navigate to Sign Up
                    }
                )
            //}
        }
    }
}

@Composable
fun RoundedCornerTextField(
    text: String,
    label: String,
    onTextChange: (String) -> Unit,
    leadingIcon: ImageVector? = null,
    isPassword: Boolean = false,
    passwordVisible: Boolean = false,
    onPasswordToggle: (() -> Unit)? = null
) {
    val keyboardOptions = if (isPassword) {
        KeyboardOptions(keyboardType = KeyboardType.Password)
    } else {
        KeyboardOptions(keyboardType = KeyboardType.Email)
    }

    TextField(
        value = text,
        onValueChange = onTextChange,
        label = { Text(label, color = Color.Gray) },
        singleLine = true,
        visualTransformation = if (isPassword && !passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
        leadingIcon = leadingIcon?.let {
            {
                Icon(imageVector = it, contentDescription = null, tint = Color.Gray)
            }
        },
        trailingIcon = if (isPassword) {
            {
                IconButton(onClick = { onPasswordToggle?.invoke() }) {
                    Icon(
                        imageVector = if (passwordVisible) {
                            ImageVector.vectorResource(id = R.drawable.coz) // Custom vector drawable
                        } else {
                            ImageVector.vectorResource(id = R.drawable.coz) // Another vector drawable
                        },
                        contentDescription = "Toggle Password Visibility"
                    )
                }
            }
        } else null,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .border(0.dp, Color.LightGray, RoundedCornerShape(12.dp)),
           // .background(Color.White),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        keyboardOptions = keyboardOptions,
        keyboardActions = KeyboardActions.Default
    )
}

@Composable
fun loginButton(
    text: String,
    onClick: () -> Unit,
){
    Button(onClick = {onClick()},
        modifier = Modifier.fillMaxWidth(0.5f),
        colors = ButtonDefaults.buttonColors(
            containerColor = Pk4,
        )
    ){
        Text(text = text)
    }
}

fun singnUp(
    auth: FirebaseAuth,
    email: String,
    password: String,
    onSuccess: (MainScreendataobject) -> Unit,
    onFailure: (String) -> Unit,) {
    if(email.isBlank() || password.isBlank()){
        onFailure("Email and password cannot be empty")
        return
    }
    auth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                onSuccess(
                    MainScreendataobject(
                        task.result.user?.uid!!,
                        task.result.user?.email!!
                    )
                )
            }}
        .addOnFailureListener {
            onFailure(it.message ?: "Unknown error")
        }
}


fun singnIn(
    auth: FirebaseAuth,
    email: String,
    password: String,
    onInSuccess: (MainScreendataobject) -> Unit,
    onInFailure: (String) -> Unit,) {
    if(email.isBlank() || password.isBlank()){
        onInFailure("Email and password cannot be empty")
        return
    }
    auth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                onInSuccess(
                    MainScreendataobject(
                        task.result.user?.uid!!,
                        task.result.user?.email!!
                    )
                )
            }
        }
        .addOnFailureListener {
            onInFailure(it.message ?: "Unknown error")
        }
}
//zsgfx@gmail.com