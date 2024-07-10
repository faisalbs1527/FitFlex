package com.example.fitflex.presentation.explore

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.fitflex.ui.theme.FitFlexTheme

@Composable
fun ExploreScreen() {
    ExploreScreenSkeleton()
}

@Composable
fun ExploreScreenSkeleton() {
    TODO("Not yet implemented")
}

@Preview(showBackground = true)
@Composable
private fun ShowExploreScreen() {
    FitFlexTheme {
        ExploreScreenSkeleton()
    }
}
