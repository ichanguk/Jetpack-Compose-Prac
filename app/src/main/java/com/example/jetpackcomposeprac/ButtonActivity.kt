package com.example.jetpackcomposeprac

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
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

class ButtonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePracTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    ButtonExample(onButtonClicked = {
                        Toast.makeText(this, "Send clicked.", Toast.LENGTH_SHORT).show()
                    })
                }
            }
        }
    }
}

@Composable
fun ButtonExample(onButtonClicked: () -> Unit) {
    Column {
        // Step 1 : Button을 클릭했을 때 Toast를 출력하게 만들기
        Button(onClick = onButtonClicked) {
            Text(text = "Send")
        }

        /* Step 2 : Icon을 Text 앞에 추가하기
            imageVector에는 Icons.Filled.Send를 넣고
            contentDescription에는 null 넣기
         */

        Button(onClick = onButtonClicked) {
            Icon(imageVector = Icons.Filled.Send, contentDescription = null)
            Text(text = "Send")
        }

        /*
            Step3 : 아이콘과 텍스트 사이에 Spacer넣기
            modifier에 Modifier.size를 넣고 사이즈를 ButtonDefaults.IconSpacing을 지정
         */
        Button(onClick = onButtonClicked) {
            Icon(imageVector = Icons.Filled.Send, contentDescription = null)
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Send")
        }

        // Step4 : enabled를 false로
        Button(
            onClick = onButtonClicked,
            enabled = false
        ) {
            Icon(imageVector = Icons.Filled.Send, contentDescription = null)
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Send")
        }

        // Step5 : border에 BorderStroke를 설정
        Button(
            onClick = onButtonClicked,
            border = BorderStroke(10.dp, Color.Magenta)
        ) {
            Icon(imageVector = Icons.Filled.Send, contentDescription = null)
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Send")
        }

        // Step6 : shape를 CircleShape로 지정
        Button(
            onClick = onButtonClicked,
            border = BorderStroke(10.dp, Color.Magenta),
            shape = CircleShape
        ) {
            Icon(imageVector = Icons.Filled.Send, contentDescription = null)
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Send")
        }

        // Step7 : contentPadding에 PaddingValues 설정
        Button(
            onClick = onButtonClicked,
            border = BorderStroke(10.dp, Color.Magenta),
            shape = CircleShape,
            contentPadding = PaddingValues(20.dp)
        ) {
            Icon(imageVector = Icons.Filled.Send, contentDescription = null)
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Send")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ButtonExamplePreview() {
    JetpackComposePracTheme {
        ButtonExample(onButtonClicked = {})
    }
}