package com.example.testproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testproject.ui.theme.TestProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UserInfoScreen() // This is to call the Composable
                }
            }
        }
    }
}

@Composable
fun UserInfoScreen(modifier: Modifier = Modifier) {
    // display message
    var message by remember { mutableStateOf("Abidul Islam\nAbidul26@bu.edu") }

    Column(
        modifier = modifier
            .fillMaxSize() // takes up the whole screen
            .padding(16.dp), // Added some padding around the content
        verticalArrangement = Arrangement.Center, // Centers the content vertically
        horizontalAlignment = Alignment.CenterHorizontally // Centers thr content horizontally
    ) {
        // To display my name and BU email
        Text(
            text = message,
            style = MaterialTheme.typography.headlineSmall, // styling
            modifier = Modifier.padding(bottom = 24.dp) // to add space below the text
        )

        // Adding a Button that changes the displayed message when clicked.
        Button(onClick = {
            // Action to perform when the button is clicked
            message = "Difference Display Message."
        }) {
            Text("Change Message")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestProjectTheme {
        UserInfoScreen()
    }
}