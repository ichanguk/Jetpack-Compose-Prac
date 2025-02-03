package com.example.jetpackcomposeprac

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import com.example.jetpackcomposeprac.ui.theme.JetpackComposePracTheme

class NetworkImageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePracTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CoilEx()
                }
            }
        }
    }
}

@Composable
fun CoilEx() {
    // step1: gradle에 coil 의존성 추가
    // step2: manifest에서 INTERNET permission 추가

    // step3: rememberImagePainter를 이용해 Image의 painter 설정(deprecate됨)
    val painter = rememberImagePainter(data = "https://raw.githubusercontent.com/Fastcampus-Android-Lecture-Project-2023/part4-chapter3/main/part4-chapter3-10/app/src/main/res/drawable-hdpi/wall.jpg")
    Image(painter = painter, contentDescription = "엔텔로프 캐년")

    // step4: AsyncImage 이용, model에 주소 넣기
    Column {
        AsyncImage(model = "https://raw.githubusercontent.com/Fastcampus-Android-Lecture-Project-2023/part4-chapter3/main/part4-chapter3-10/app/src/main/res/drawable-hdpi/wall.jpg", contentDescription = "엔텔로프 캐년")
        AsyncImage(model = "https://raw.githubusercontent.com/Fastcampus-Android-Lecture-Project-2023/part4-chapter3/main/part4-chapter3-10/app/src/main/res/drawable-hdpi/wall.jpg", contentDescription = "엔텔로프 캐년")
    }
}

@Preview(showBackground = true)
@Composable
fun CoilPreview() {
    JetpackComposePracTheme {
        CoilEx()
    }
}