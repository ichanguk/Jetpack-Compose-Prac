package com.example.jetpackcomposeprac

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeprac.ui.theme.JetpackComposePracTheme

class ModifierActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePracTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    ModifierExample()
                }
            }
        }
    }
}

@Composable
fun ModifierExample() {
    Column {
        // Step 1 : modifier에 Modifier.fillMaxSize() 사용
        /*
        Button(
            onClick = {},
            modifier = Modifier.fillMaxSize()
        ) {
            Icon(imageVector = Icons.Filled.Search, contentDescription = null)
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Search")
        }
         */

        // Step 2 : fillMaxSize 대신 Modifier.height 설정

        Button(
            onClick = {},
            modifier = Modifier.height(100.dp)
        ) {
            Icon(imageVector = Icons.Filled.Search, contentDescription = null)
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Search")
        }

        // Step 3 : modifier에 height와 width를 같이 설정
        Button(
            onClick = {},
            modifier = Modifier
                .height(100.dp)
                .width(200.dp)
        ) {
            Icon(imageVector = Icons.Filled.Search, contentDescription = null)
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Search")
        }

        // Step 4 : size에 width와 height를 인자로 넣기
        Button(
            onClick = {},
            modifier = Modifier
                .size(200.dp, 100.dp)
        ) {
            Icon(imageVector = Icons.Filled.Search, contentDescription = null)
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Search")
        }

        // Step 5 : background 설정
        Button(
            onClick = {},
            modifier = Modifier
                .size(200.dp, 100.dp)
                .background(Color.Red)
        ) {
            Icon(imageVector = Icons.Filled.Search, contentDescription = null)
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Search")
        }

        /* Step 6 : colors 파라미터에 ButtonDefaults.buttonColors를 넣기
            containerColor와 contentColor 프로퍼티 설정
         */

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta,
                contentColor = Color.Cyan
            ),
            onClick = {},
            modifier = Modifier
                .size(200.dp, 100.dp)
        ) {
            Icon(imageVector = Icons.Filled.Search, contentDescription = null)
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Search")
        }

        // Step 7 : Button의 modifier에 padding을 추가
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta,
                contentColor = Color.Cyan
            ),
            onClick = {},
            modifier = Modifier
                .padding(10.dp)
        ) {
            Icon(imageVector = Icons.Filled.Search, contentDescription = null)
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Search")
        }

        // Step 8 : Button에 enabled를 false로 설정하고 Text의 modifier에 clickable 지정
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta,
                contentColor = Color.Cyan
            ),
            onClick = {},
            enabled = false,
            modifier = Modifier
                .padding(10.dp)
        ) {
            Icon(imageVector = Icons.Filled.Search, contentDescription = null)
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Search",
                modifier = Modifier.clickable {})
        }

        // Step 9: Text의 modifier에 offset을 설정하고 x 파라미터 설정
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta,
                contentColor = Color.Cyan
            ),
            onClick = {},
            modifier = Modifier
                .padding(10.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.Search, contentDescription = null,
                modifier = Modifier.background(Color.Blue)
            )
            Spacer(
                modifier = Modifier
                    .size(ButtonDefaults.IconSpacing)
                    .background(Color.Blue)
            )
            Text(
                text = "Search",
                modifier = Modifier
                    .offset(x = 10.dp)
                    .background(Color.Blue)
            )
        }

    }

}

@Preview(showBackground = true)
@Composable
fun ModifierExamplePreview() {
    JetpackComposePracTheme {
        ModifierExample()
    }
}