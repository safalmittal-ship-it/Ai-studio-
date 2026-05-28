package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      MyApplicationTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          Box(
              modifier = Modifier
                  .fillMaxSize()
                  .background(MaterialTheme.colorScheme.background)
                  .padding(innerPadding),
              contentAlignment = Alignment.Center
          ) {
            Greeting()
          }
        }
      }
    }
  }
}

@Composable
fun Greeting() {
  var visible by remember { mutableStateOf(false) }
  val alpha by animateFloatAsState(
      targetValue = if (visible) 1f else 0f,
      animationSpec = tween(durationMillis = 2000),
      label = "fade_in"
  )

  LaunchedEffect(Unit) {
      visible = true
  }

  Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier.alpha(alpha)
  ) {
      Text(
          text = "Hello, World!",
          fontSize = 48.sp,
          fontWeight = FontWeight.Light,
          fontFamily = FontFamily.SansSerif,
          letterSpacing = (-1).sp,
          color = MaterialTheme.colorScheme.onBackground
      )
  }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  MyApplicationTheme { Greeting() }
}
