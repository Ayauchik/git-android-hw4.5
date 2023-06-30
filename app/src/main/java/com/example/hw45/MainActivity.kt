package com.example.hw45

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hw45.data.Routes
import com.example.hw45.domain.PinCodeScreen
//import com.example.hw45.firstpage.PinCodeScreenNav
import com.example.hw45.domain.AuthScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            //PinCodeScreen()`
            val navController = rememberNavController()
            Box(modifier = Modifier.fillMaxSize()){
                NavHost(navController = navController, startDestination = "/"){
                    composable(Routes.first){ PinCodeScreen(navController = navController) }
                    composable(Routes.second) { AuthScreen() }
                }
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


