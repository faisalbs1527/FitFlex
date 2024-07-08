package com.example.fitflex.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.fitflex.ui.theme.FitFlexTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    HomeScreenSkeleton()
}

@Composable
fun HomeScreenSkeleton() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "HOME",
            fontSize = MaterialTheme.typography.bodyLarge.fontSize
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ShowHomeScreen() {
    FitFlexTheme {
        HomeScreenSkeleton()
    }
}
