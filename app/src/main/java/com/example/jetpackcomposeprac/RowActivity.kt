package com.example.jetpackcomposeprac

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeprac.ui.theme.JetpackComposePracTheme

class RowActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePracTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RowEx()
                }
            }
        }
    }
}

@Composable
fun RowEx() {
    Column {
        // step1 : 각 Text의 modifier에 align 설정
        // Alignment.Top, CenterVertically, Bottom을 지정
        Row(modifier = Modifier.height(40.dp)) {
            Text(text = "첫 번째!", modifier = Modifier.align(Alignment.Top))
            Text(text = "두 번째!", modifier = Modifier.align(Alignment.CenterVertically))
            Text(text = "세 번째!", modifier = Modifier.align(Alignment.Bottom))
        }

        // step2 : Row에 verticalAlignment를 설정
        Row(
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier.height(40.dp)
        ) {
            Text(text = "첫 번째!", modifier = Modifier.align(Alignment.Top))
            Text(text = "두 번째!")
            Text(text = "세 번째!")
        }

        // step3 : Row의 width를 200dp 정도로 설정
        // Row에 horizontalArrangement에 Arrangement.Center 설정
        // Start, End, SpaceAround, SpaceBetween, SpaceEvenly도 설정

        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .width(200.dp)
                .height(40.dp)
        ) {
            Text(text = "첫 번째!", modifier = Modifier.align(Alignment.Top))
            Text(text = "두 번째!")
            Text(text = "세 번째!")
        }

        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .width(200.dp)
                .height(40.dp)
        ) {
            Text(text = "첫 번째!", modifier = Modifier.align(Alignment.Top))
            Text(text = "두 번째!")
            Text(text = "세 번째!")
        }

        // step4 : horizontalArrangement를 제거하고 각 text에 Modifier.weight를 설정
        Row(
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .width(200.dp)
                .height(40.dp)
        ) {
            Text(text = "첫 번째!", modifier = Modifier
                .align(Alignment.Top)
                .weight(1f))
            Text(text = "두 번째!", modifier = Modifier.weight(3f))
            Text(text = "세 번째!", modifier = Modifier.weight(3f))
        }

        // step5 : Text 대신 Icon 넣기
        Row(
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .width(200.dp)
                .height(40.dp)
        ) {
            Text(text = "첫 번째!",
                textAlign = TextAlign.Center,
                modifier = Modifier
                .align(Alignment.Top)
                .weight(1f))
            Icon(imageVector = Icons.Filled.Add, contentDescription = "add")
            Text(text = "두 번째!", modifier = Modifier.weight(1f))
            Text(text = "세 번째!", modifier = Modifier.weight(1f))
        }

    }
}

@Preview(showBackground = true)
@Composable
fun RowExPreview() {
    JetpackComposePracTheme {
        RowEx()
    }
}