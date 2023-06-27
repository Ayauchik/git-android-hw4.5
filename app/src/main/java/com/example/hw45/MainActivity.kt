package com.example.hw45

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import com.example.hw45.firstpage.PinCodeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
            ) {
                PinCodeScreen()
            }
        }
    }
}

/*
@Composable
fun MyApp(onTextPressed: (String) -> Unit) {
    val numberList = listOf("1", "4", "7", "<", "2", "5", "8", "0", "3", "6", "9", "OK")
    val columns = 4
    var enteredText by remember { mutableStateOf("") }
    var textColor by remember { mutableStateOf(Color.Blue) }
    val password = "1234"

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(

        ) {
            Text(
                text = enteredText,
                color = textColor,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 20.dp),
                style = TextStyle(
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif
                )
            )

            repeat(columns) { columnIndex ->
                Row() {
                    repeat(columns) { rowIndex ->
                        val index = rowIndex * columns + columnIndex
                        if (index < numberList.size) {
                            ButtonWithText(
                                number = numberList[index],
                                onClick = { text ->
                                    if (text == "<") {
                                        enteredText = enteredText.dropLast(1)
                                        if (enteredText.length == 3) {
                                            textColor = Color.Blue
                                        }
                                    } else if (text == "OK") {
                                        if (enteredText.length == 4) {
                                            textColor = if (enteredText == password) {
                                                Color.Green
                                            } else {
                                                Color.Red
                                            }
                                        }
                                    } else if (enteredText.length < 4) {
                                        enteredText += text
                                    }
                                },
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}*/


