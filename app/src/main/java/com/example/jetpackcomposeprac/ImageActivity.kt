package com.example.jetpackcomposeprac

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposeprac.ui.theme.JetpackComposePracTheme

class ImageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePracTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ImageEx()
                }
            }
        }
    }
}

@Composable
fun ImageEx() {
    Column {
        // step1: Image를 만들어보기
        // painter 항목에 painterResource(id = R.drawable.wall)
        // contentDescription에 엔텔로프 캐년 넣기
        Image(painter = painterResource(id = R.drawable.wall), contentDescription = "엔텔로프 캐년")

        // step2: imageVector에 Icons.Filled.Settings를 설정
        Image(
            imageVector = Icons.Filled.Settings,
            contentDescription = "세팅"
        )

    }
}

@Preview(showBackground = true)
@Composable
fun ImagePreview() {
    JetpackComposePracTheme {
        ImageEx()
    }
}