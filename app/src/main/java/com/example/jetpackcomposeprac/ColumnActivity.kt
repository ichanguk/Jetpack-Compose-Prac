package com.example.jetpackcomposeprac

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeprac.ui.theme.JetpackComposePracTheme

class ColumnActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePracTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ColumnEx()
                }
            }
        }
    }
}

@Composable
fun ColumnEx() {
    Column {
        Column(
            modifier = Modifier.size(100.dp)
        ) {
            Text(text = "첫 번째")
            Text(text = "두 번째")
            Text(text = "세 번째")
        }

        // step1 : horizontalAlignment를 Column에 적용
        Column(
            modifier = Modifier.size(100.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "첫 번째")
            Text(text = "두 번째")
            Text(text = "세 번째")
        }

        // step 2 : Column에 verticalArrangement를 지정
        // SpaceAround, SpaceEvenly, SpaceBetween도 해보기
        Column(
            modifier = Modifier.size(100.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "첫 번째")
            Text(text = "두 번째")
            Text(text = "세 번째")
        }

        // step 3 : Text에 Modifier.align 사용
        Column(
            modifier = Modifier.size(100.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "첫 번째")
            Text(text = "두 번째", modifier = Modifier.align(Alignment.Start))
            Text(text = "세 번째", modifier = Modifier.align(Alignment.End))
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ColumnExPreview() {
    JetpackComposePracTheme {
        ColumnEx()
    }
}