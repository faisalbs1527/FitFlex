package com.example.fitflex.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fitflex.ui.theme.FitFlexTheme
import com.example.fitflex.ui.theme.black
import com.example.fitflex.utils.NavItems

@Composable
fun NavBar(
    content: @Composable RowScope.() -> Unit
) {
    Surface {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(color = black, shape = RoundedCornerShape(32.dp)),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            content = content
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Show() {
    FitFlexTheme {
        val items = listOf(
            NavItems.Home,
            NavItems.Explore,
            NavItems.Statistic,
            NavItems.Profile,
        )
        val selectedItem = remember {
            mutableStateOf(0)
        }
        NavBar() {
            items.forEach {
                NavBarItem(
                    onClick = {
                        selectedItem.value = it.no
                    },
                    navItems = it,
                    selected = selectedItem.value == it.no
                )
            }
        }
    }
}
