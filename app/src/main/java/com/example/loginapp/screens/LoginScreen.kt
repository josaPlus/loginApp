package com.example.loginapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.loginapp.ui.theme.LoginAppTheme

@Composable
fun LoginScreen(navController : NavController){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp)
            .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
            .background(Color.DarkGray),
        //verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // ICONO DE LOGO
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "LOGO",
            modifier = Modifier
                .padding(top = 40.dp)
                .size(80.dp)
        )

        //LOGIN
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp)
                .clip(RoundedCornerShape(topStart = 40.dp, bottomStart = 40.dp, bottomEnd = 40.dp))
                .background(Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Login",
                style = MaterialTheme.typography.headlineMedium
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .shadow(
                        elevation = 8.dp, // qué tan fuerte es la sombra
                        shape = RoundedCornerShape(40.dp),
                        clip = false // false = que la sombra no se recorte
                    )
                    .clip(RoundedCornerShape(40.dp))
                    .background(Color.White),

            ) {
                Text(
                    text = "Email",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 4.dp)
                )

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    placeholder = { Text("example@email.com") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
            }

        }
    }
}

@Preview(
    showSystemUi = true
)
@Composable
fun LoginScreenPreview(){
    LoginAppTheme {
        val navController = androidx.navigation.compose.rememberNavController()
        LoginScreen(navController = navController)
    }
}