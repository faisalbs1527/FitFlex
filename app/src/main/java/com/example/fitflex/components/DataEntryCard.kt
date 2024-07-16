package com.example.fitflex.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fitflex.ui.theme.FitFlexTheme
import com.example.fitflex.ui.theme.Font_LatoBold
import com.example.fitflex.ui.theme.black
import com.example.fitflex.ui.theme.gray
import com.example.fitflex.ui.theme.lightGreen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun DataEntryCard(
    isTimer: Boolean = false,
    amountData: String = "30",
    remaining: String = "15",
    curTime: Int = 500,
    burn: String = "60 Cal"
) {

    var isRunning by remember {
        mutableStateOf(false)
    }
    var currSeconds by remember {
        mutableIntStateOf(curTime)
    }
    val scope = rememberCoroutineScope()

    LaunchedEffect(isRunning) {
        if (isRunning) {
            while (true) {
                delay(1000)
                currSeconds++
            }
        }
    }

    var isDialogVisible by remember { mutableStateOf(false) }
    var remAmount by remember {
        mutableIntStateOf(remaining.toInt())
    }

    Column(
        modifier = Modifier
            .padding(top = 40.dp, start = 20.dp, end = 20.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Remaining",
            fontSize = 14.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight(800),
            color = Color.White.copy(.6f),
            modifier = Modifier.padding(top = 20.dp)
        )
        Text(
            text = if (isTimer) formatTime(currSeconds) else remAmount.toString(),
            fontSize = 40.sp,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight(800),
            color = Color.White,
            modifier = Modifier.padding(vertical = 4.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ContentBox(
                title = if (isTimer) "Time" else "Amount",
                text = amountData
            )
            Box(
                modifier = Modifier
                    .size(45.dp)
                    .background(
                        color = lightGreen,
                        shape = CircleShape
                    )
                    .clickable {
                        scope.launch {
                            if (isTimer) {
                                isRunning = !isRunning
                            } else {
                                isDialogVisible = true
                            }
                        }
                    },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = if (isTimer) {
                        if (isRunning) Icons.Filled.Pause else Icons.Filled.PlayArrow
                    } else Icons.Filled.Add,
                    contentDescription = "",
                    tint = black
                )
            }
            ContentBox(
                title = "Burn",
                text = burn
            )
        }

    }
    if (isDialogVisible) {
        Dialog { inputNumber ->
            isDialogVisible = false
            if (inputNumber.isNotEmpty()) {
                remAmount -= (inputNumber.toInt())
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Show() {
    FitFlexTheme {
        val amountData = "20 Min"
        val burn = "60 Cal"
        val remaining = "15"

        DataEntryCard(
            isTimer = true,
            amountData = amountData,
            remaining = remaining,
            burn = burn
        )
    }
}

@Composable
fun ContentBox(
    title: String,
    text: String
) {
    Column(
        modifier = Modifier
            .background(
                color = gray.copy(.2f),
                shape = RoundedCornerShape(46.dp)
            )
            .padding(vertical = 20.dp, horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontSize = 14.sp,
            fontFamily = Font_LatoBold,
            fontWeight = FontWeight(800),
            color = Color.White.copy(0.7f)
        )
        Text(
            text = text,
            fontSize = 18.sp,
            fontFamily = Font_LatoBold,
            fontWeight = FontWeight(800),
            color = Color.White
        )
    }
}

@Composable
fun Dialog(
    onDismiss: (inputNumber: String) -> Unit
) {

    var numberInput by remember { mutableStateOf("") }
    AlertDialog(
        onDismissRequest = { onDismiss(numberInput) },
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Add Amount",
                    fontSize = 24.sp,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight(800),
                    color = Color.Black
                )
            }
        },
        text = {
            OutlinedTextField(
                value = numberInput,
                onValueChange = { numberInput = it },
                label = { Text(text = "Amount") },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                singleLine = true
            )
        },
        confirmButton = {
            Button(
                onClick = {
                    onDismiss(numberInput)
                }
            ) {
                Text("OK")
            }
        },
        dismissButton = {
            Button(
                onClick = { onDismiss("") }
            ) {
                Text("Cancel")
            }
        }
    )
}

@SuppressLint("DefaultLocale")
fun formatTime(seconds: Int): String {
    val minutes = seconds / 60
    val remainingSeconds = seconds % 60
    return String.format("%02d:%02d", minutes, remainingSeconds)
}