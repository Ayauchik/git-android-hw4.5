package com.example.hw45.domain

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hw45.data.Routes
import com.example.hw45.presentation.ButtonWithText


private var enteredText by mutableStateOf("")
private var topTextColor by mutableStateOf(Color(0xff277da1))

@Composable
fun PinCodeScreen(navController: NavController) {

    val password = "0000"
    val onClick: (String) -> Unit = { text ->
        if (enteredText.length < 4) {
            enteredText += text
        }
        topTextColor = Color(0xff277da1)
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            TopText(enteredText = enteredText, topTextColor = topTextColor)

            Row {
                FirstColumn(onClick = onClick)
                SecondColumn(onClick = onClick)
                ThirdColumn(password = password, onClick = onClick, navController = navController)
            }
        }
    }
}

@Composable
fun TopText(enteredText: String, topTextColor: Color) {
    Column() {
        Text(
            text = enteredText,
            color = topTextColor,
            modifier = Modifier
                .padding(bottom = 20.dp),
            style = TextStyle(
                fontSize = 45.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif
            )
        )
    }
}

@Composable
fun FirstColumn(onClick: (String) -> Unit) {
    Column(modifier = Modifier.padding(vertical = 16.dp)) {
        ButtonWithText(number = "1", onClick = onClick)
        ButtonWithText(number = "4", onClick = onClick)
        ButtonWithText(number = "7", onClick = onClick)
        ButtonWithText(number = "<", onClick = {
            if (enteredText.isNotEmpty()) {
                enteredText = enteredText.dropLast(1)
                topTextColor = Color(0xff277da1)
            }
        })
    }
}

@Composable
fun SecondColumn(onClick: (String) -> Unit) {
    Column(modifier = Modifier.padding(vertical = 16.dp)) {
        ButtonWithText(number = "2", onClick = onClick)
        ButtonWithText(number = "5", onClick = onClick)
        ButtonWithText(number = "8", onClick = onClick)
        ButtonWithText(number = "0", onClick = onClick)
    }
}

@Composable
fun ThirdColumn(password: String, onClick: (String) -> Unit, navController: NavController) {
    Column(modifier = Modifier.padding(vertical = 16.dp)) {
        ButtonWithText(number = "3", onClick = onClick)
        ButtonWithText(number = "6", onClick = onClick)
        ButtonWithText(number = "9", onClick = onClick)
        ButtonWithText(number = "OK", onClick = {
            if (enteredText == password) {
                topTextColor =  Color(0xff38b000)
                navController.navigate(Routes.second)
            } else {
                topTextColor = Color(0xffce4257)
            }

        })
    }
}