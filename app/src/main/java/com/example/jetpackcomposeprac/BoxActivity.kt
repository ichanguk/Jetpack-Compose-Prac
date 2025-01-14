package com.example.jetpackcomposeprac

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeprac.ui.theme.JetpackComposePracTheme

class BoxActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePracTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BoxEx()
                }
            }
        }
    }
}

@Composable
fun BoxEx() {
    Column {
        Box(modifier = Modifier
            .size(100.dp)
            .border(1.dp, Color.Blue)) {
            Text(text = "Hello World", modifier = Modifier.align(Alignment.Center))
        }

        // step1 : Text 2개를 Box 안에 배치
        Box(modifier = Modifier.size(100.dp)) {
            Text(text = "Hello World", modifier = Modifier.align(Alignment.BottomCenter))
            Text(text = "Jetpack", modifier = Modifier.align(Alignment.TopStart))
            Text(text = "Compose", modifier = Modifier.align(Alignment.CenterEnd))
        }

        // step2 : 2개의 Box를 Box 안에 배치하고 사이즈를 70dp
        Box(modifier = Modifier.size(100.dp)) {
            Box(modifier = Modifier.size(70.dp).background(Color.Cyan).align(Alignment.CenterStart))
            Box(modifier = Modifier.size(70.dp).background(Color.Yellow).align(Alignment.BottomEnd))
        }

        // step 3 : 부모 Box에 modifier 설정을 제거해서 content 사이즈만큼 보여주게
        // 첫 번째 자식 Box의 사이즈를 matchParentSize()로 설정
        // 다음은 fillMaxSize()로 설정
        Box {
            Box(modifier = Modifier.fillMaxSize().background(Color.Cyan).align(Alignment.CenterStart))
            Box(modifier = Modifier.size(70.dp).background(Color.Yellow).align(Alignment.BottomEnd))
        }

    }

}

@Preview(showBackground = true)
@Composable
fun BoxPreview() {
    JetpackComposePracTheme {
        BoxEx()
    }
}