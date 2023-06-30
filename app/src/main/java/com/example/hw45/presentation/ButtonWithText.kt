package com.example.hw45.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
