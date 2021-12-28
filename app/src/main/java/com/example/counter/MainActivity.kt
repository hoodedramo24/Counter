package com.example.counter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.counter.ui.theme.CounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column() {
                Title("Counter")
                CountCard()
            }
            
        }
    }
}

@Composable
fun Title (name: String){
    Row(
    ) {
        Text(
            text = "$name",
            style = MaterialTheme.typography.h3
        )
    }
}

@Composable
fun CountCard(){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var count: Int by remember { mutableStateOf(0)}
        Row() {
            Text(
                text = "$count",
                style = MaterialTheme.typography.h1
            )
        }
        Column (){
            Button(onClick = { count++}) {
                Text(text = "Tap to increase")
            }

            if (count > 0) {
                Spacer(modifier = Modifier.size(10.dp))
                Button(onClick = { count-- }) {
                    Text(text = "Tap to decrease")
                }
                Spacer(modifier = Modifier.size(10.dp))
                Button(onClick = {count = 0}){
                    Text(text = "Reset")
                }
            }
        }
    }
}

