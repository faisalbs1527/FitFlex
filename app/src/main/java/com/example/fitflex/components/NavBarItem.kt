package com.example.fitflex.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitflex.ui.theme.FitFlexTheme
import com.example.fitflex.ui.theme.Font_Lato
import com.example.fitflex.ui.theme.black
import com.example.fitflex.ui.theme.lightGreen
import com.example.fitflex.utils.NavItems

@Composable
fun RowScope.NavBarItem(
    onClick: () -> Unit,
    selected: Boolean = true,
    navItems: NavItems = NavItems.Explore
) {
    Row(
        modifier = Modifier
            .background(
                color = if (selected) lightGreen else Color.Transparent,
                shape = RoundedCornerShape(20.dp)
            )
            .clickable {
                onClick()
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = navItems.icon, contentDescription = "",
                modifier = Modifier.size(24.dp),
                tint = if (selected) black else Color.White
            )
            AnimatedVisibility(visible = selected) {
                Text(
                    text = navItems.name,
                    fontFamily = Font_Lato,
                    color = black,
                    fontSize = 13.sp,
                    fontWeight = FontWeight(500),
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Show() {
    FitFlexTheme {
//        NavBarItem({})
    }
}