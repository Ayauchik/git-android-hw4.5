package com.example.hw45.firstpage

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
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


@Composable
fun ButtonWithText(
    number: String,
    onClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        modifier = modifier
            .padding(4.dp)
            .size(width = 88.dp, height = 44.dp),
        onClick = { onClick(number) },
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(width = 2.dp, Color(173, 216, 230)),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
    ) {
        Text(text = number, color = Color(173, 216, 230), fontSize = 20.sp)
    }
}


private var enteredText by mutableStateOf("")
private var topTextColor by mutableStateOf(Color(0xff277da1))

@Composable
fun PinCodeScreen() {

    val password = "1234"
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
                ThirdColumn(password = password, onClick = onClick)
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
fun ThirdColumn(password: String, onClick: (String) -> Unit) {
    Column(modifier = Modifier.padding(vertical = 16.dp)) {
        ButtonWithText(number = "3", onClick = onClick)
        ButtonWithText(number = "6", onClick = onClick)
        ButtonWithText(number = "9", onClick = onClick)
        ButtonWithText(number = "OK", onClick = {
            topTextColor = if (enteredText == password) {
                Color(0xff38b000)
            } else {
                Color(0xffce4257)
            }

        })
    }
}