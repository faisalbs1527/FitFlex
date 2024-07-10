package com.example.fitflex.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitflex.ui.theme.Font_Lato
import com.example.fitflex.ui.theme.black
import com.example.fitflex.ui.theme.textBoxColor

@Composable
fun TextBox(
    text: String
) {
    Row(
        modifier = Modifier
            .background(
                color = textBoxColor,
                shape = RoundedCornerShape(3.dp)
            )
            .padding(vertical = 2.dp, horizontal = 4.dp)
    ) {
        Text(
            text = text,
            fontSize = 12.sp,
            fontWeight = FontWeight(400),
            fontFamily = Font_Lato,
            color = black.copy(alpha = .7f)
        )
    }
}