package com.example.cs501_i2_q3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cs501_i2_q3.ui.theme.CS501_I2_Q3Theme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CS501_I2_Q3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainLayout(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable fun MainLayout(modifier: Modifier = Modifier) {
    var index by remember { mutableStateOf(Random.nextInt(5)) }
    val facts = arrayOf(
        "The earth is not flat.",
        "Earth is 4.54 billion years old.",
        "You can’t fold a piece of A4 paper more than eight times.",
        "A horse normally has more than one horsepower.",
        "The longest English word is 189,819 letters long."
    )
    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(20.dp))
        Label(
            text = facts[index]
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedButton(onClick = {index = (index + Random.nextInt(4) + 1) % 5}) { // math to avoid repeating a fact
            Text(text = "Next Fact", fontSize = 24.sp)
        }
    }
}

@Composable
fun Label(text: String) {
    Text(
        text = text,
        fontSize = 24.sp,
        color = Color.hsl(Random.nextInt(360).toFloat(), 0.5f, 0.4f),
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        fontFamily = FontFamily.Monospace,
        lineHeight = 32.sp
    )
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    CS501_I2_Q3Theme {
        MainLayout()
    }
}