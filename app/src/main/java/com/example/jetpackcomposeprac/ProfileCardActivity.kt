package com.example.jetpackcomposeprac

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.jetpackcomposeprac.ui.theme.JetpackComposePracTheme

class ProfileCardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePracTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CardEx(cardData)
                }
            }
        }
    }

    companion object {
        val cardData = CardData(
            imageUri = "https://raw.githubusercontent.com/Fastcampus-Android-Lecture-Project-2023/part4-chapter3/main/part4-chapter3-10/app/src/main/res/drawable-hdpi/wall.jpg",
            imageDescription = "엔텔로프 캐년",
            author = "Dalinaum",
            description = "엔텔로프 캐년은 죽기 전에 꼭 봐야할 절경으로 소개되었습니다."
        )
    }
}

@Composable
fun CardEx(cardData: CardData) {
    val placeHolderColor = Color(0x33000000)
    Column {
        Card(
            elevation = CardDefaults.cardElevation(8.dp),
            modifier = Modifier.padding(4.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(8.dp)
            ) {
                // step1: 'AsyncImage', 'Spacer', 'Column', 'Text'로 레이아웃 만들기
                AsyncImage(
                    model = cardData.imageUri,
                    contentDescription = cardData.imageDescription,
                    modifier = Modifier.size(32.dp),
                    placeholder = ColorPainter(placeHolderColor)
                )
                Spacer(modifier = Modifier.size(8.dp))
                Column {
                    Text(text = cardData.author)
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(text = cardData.description)
                }
            }
        }

        // step2: AsyncImage에는 placeholder를 지정하고
        // contentScale을 ContentScale.Crop으로 설정
        // clip(CircleShape)로 둥근 외양 만들기
        Card(
            elevation = CardDefaults.cardElevation(8.dp),
            modifier = Modifier.padding(4.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(8.dp)
            ) {
                // step1: 'AsyncImage', 'Spacer', 'Column', 'Text'로 레이아웃 만들기
                AsyncImage(
                    model = cardData.imageUri,
                    contentScale = ContentScale.Crop,
                    contentDescription = cardData.imageDescription,
                    modifier = Modifier.size(32.dp)
                        .clip(CircleShape),
                    placeholder = ColorPainter(placeHolderColor)
                )
                Spacer(modifier = Modifier.size(8.dp))
                Column {
                    Text(text = cardData.author)
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(text = cardData.description)
                }
            }
        }
    }



}

data class CardData(
    val imageUri: String,
    val imageDescription: String,
    val author: String,
    val description: String
)

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    JetpackComposePracTheme {
        Row {
            CardEx(cardData = ProfileCardActivity.cardData)
        }
    }
}