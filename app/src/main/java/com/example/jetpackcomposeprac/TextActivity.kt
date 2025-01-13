package com.example.jetpackcomposeprac

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeprac.ui.theme.JetpackComposePracTheme

class TextActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePracTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TextExample("Android")
                }
            }
        }
    }
}

@Composable
fun TextExample(name: String, modifier: Modifier = Modifier) {
    Column {
        Text(text = "Hello $name")

        // step1 : 빨간 색상 지정
        Text(color = Color.Red, text = "Hello $name")

        // step2 : Color 객체를 이용해 해쉬값으로 색상 전달 (ARGB 순)
        Text(color = Color(0xffff9944), text = "Hello $name")

        // step3: fontSize 파라미터에 30.sp를 전달
        Text(color = Color.Red, text = "Hello $name", fontSize = 30.sp)

        // step4 : fontWeight에 FontWeight.Bold를 전달
        Text(
            color = Color.Red,
            text = "Hello $name",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        // step5 : fontFamily에 FontFamily.Cursive를 전달
        Text(
            color = Color.Red,
            text = "Hello $name",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive
        )

        // step6 : letterSpacing에 2.sp 지정
        Text(
            color = Color.Red,
            text = "Hello $name",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            letterSpacing = 2.sp
        )

        // step 7: maxLines를 2로 지정하고 문자열 추가
        Text(
            color = Color.Red,
            text = "Hello $name\nHello $name 2\nHello $name 3",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            letterSpacing = 2.sp,
            maxLines = 2
        )

        // Step 8: textDecoration에 TextDecoration.Underline 추가
        Text(
            color = Color.Red,
            text = "Hello $name\nHello $name 2\nHello $name 3",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            letterSpacing = 2.sp,
            maxLines = 2,
            textDecoration = TextDecoration.Underline
        )

        // Step 9: textAlign을 TextAlign.Center로 지정
        Text(
            modifier = Modifier.width(200.dp),
            color = Color.Red,
            text = "Hello $name\nHello $name 2\nHello $name 3",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive,
            letterSpacing = 2.sp,
            maxLines = 2,
            textDecoration = TextDecoration.Underline,
            textAlign = TextAlign.Center
        )

    }

}

@Preview(showBackground = true)
@Composable
fun TextExamplePreview() {
    JetpackComposePracTheme {
        TextExample("Android")
    }
}