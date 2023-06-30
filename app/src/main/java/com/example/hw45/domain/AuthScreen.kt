package com.example.hw45.domain

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hw45.R

@Composable
fun AuthScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_jusan),
            contentDescription = null,
            modifier = Modifier.padding(bottom = 10.dp).size(150.dp),
            contentScale = ContentScale.FillBounds
        )

        Text(text = "Jusan User", modifier = Modifier.padding(top = 20.dp), fontSize = 20.sp)
        Text(text = "User@gmail.com", modifier = Modifier.padding(top = 10.dp, bottom = 10.dp), fontSize = 20.sp)

        PersonalButtons(name = "Поделиться")
        PersonalButtons(name = "Отправить по почте")
        PersonalButtons(name = "Позвонить")
        PersonalButtons(name = "Запустить камеру")
        PersonalButtons(name = "Открыть заметки")


    }
}

@Composable
fun PersonalButtons(name: String) {

    Button(
        modifier = Modifier
            .padding(top = 5.dp).fillMaxWidth(),
        onClick = {},
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(width = 2.dp, Color(173, 216, 230)),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
    ) {
        androidx.compose.material3.Text(text = name, color = Color(173, 216, 230), fontSize = 15.sp)
    }

}