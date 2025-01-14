package com.example.jetpackcomposeprac

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeprac.ui.theme.JetpackComposePracTheme

class SurfaceActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePracTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    SurfaceEx("Android")
                }
            }
        }
    }
}

@Composable
fun SurfaceEx(name: String) {
    Column {
        // step1 : Surface에 elevation을 설정하기
        Surface(
            modifier = Modifier.padding(5.dp),
            shadowElevation = 10.dp
        ) {
            Text(
                text = "Hello $name",
                modifier = Modifier.padding(8.dp)
            )
        }

        // step2 : border의 값 설정
        Surface(
            border = BorderStroke(width = 2.dp, color = Color.Magenta),
            modifier = Modifier.padding(5.dp),
            shadowElevation = 10.dp
        ) {
            Text(
                text = "Hello $name",
                modifier = Modifier.padding(8.dp)
            )
        }

        // step3 : Surface의 shape 설정
        Surface(
            border = BorderStroke(width = 2.dp, color = Color.Magenta),
            modifier = Modifier.padding(5.dp),
            shadowElevation = 10.dp,
            shape = CircleShape
        ) {
            Text(
                text = "Hello $name",
                modifier = Modifier.padding(8.dp)
            )
        }
        
        // step4 : color 지정
        // MaterialTheme.colors에서 primary, error,
        // background, surface, secondary 등을 지정
        // contentColor가 자동으로 선택
        Surface(
            border = BorderStroke(width = 2.dp, color = Color.Magenta),
            modifier = Modifier.padding(5.dp),
            shadowElevation = 10.dp,
            shape = CircleShape,
            color = MaterialTheme.colorScheme.error
            // surface의 color에 따라 content color가 자동으로 선택됨
            // error의 경우 content color가 onError가 됨
        ) {
            Text(
                text = "Hello $name",
                modifier = Modifier.padding(8.dp)
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposePracTheme {
        SurfaceEx("Android")
    }
}