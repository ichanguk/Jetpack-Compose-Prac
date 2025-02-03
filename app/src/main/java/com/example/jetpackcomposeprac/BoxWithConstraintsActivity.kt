package com.example.jetpackcomposeprac

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeprac.ui.theme.JetpackComposePracTheme

class BoxWithConstraintsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePracTheme {
                Outer()
            }
        }
    }
}

@Composable
fun Outer() {
    Column {
        // step2: Inner의 인자로 Modifier.widthIn(min = 100.dp)를 전달
        // heightIn도 전달
        // 각각의 max값도 전달
        Inner(
            modifier = Modifier
                .width(200.dp)
                .height(160.dp)
        )
    }
}

// step1: Inner 인자로 modifier를 전달, 기본 값을 Modifier로 지정
// 파라미터로 받은 modifier를 BoxWithConstraints에 전달
@Composable
private fun Inner(modifier: Modifier = Modifier) {
    BoxWithConstraints(modifier) {
        // step3 : maxHeight가 150dp가 넘을 때만 추가로 텍스트 출력
        if (maxHeight > 150.dp) {
            Text("여기 꽤 길군요!",
                modifier = Modifier.align(Alignment.BottomCenter))
        }
        Text("maxW:$maxWidth maxHeight:$maxHeight minW: $minWidth minH: $minHeight")
    }
}

@Preview(showBackground = true)
@Composable
fun OuterPreview() {
    JetpackComposePracTheme {
        Outer()
    }
}