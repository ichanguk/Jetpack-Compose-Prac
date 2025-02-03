package com.example.jetpackcomposeprac

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeprac.ui.theme.JetpackComposePracTheme

class TextFieldActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePracTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TextFieldEx()
                }
            }
        }
    }
}

@Composable
fun TextFieldEx() {
    var name by remember {
        mutableStateOf("Tom")
    }
    Column(modifier = Modifier.padding(16.dp)) {
        // step1: TextField를 Text 위에 만들기
        TextField(value = "Tom", onValueChange = {})

        // step2 : Text에 TextField 입력을 출력하도록
        TextField(value = name, onValueChange = { name = it })

        // step3 : TextField에 label을 추가
        TextField(
            value = name,
            label = {
                Text(text = "이름")
            },
            onValueChange = { name = it }
        )

        // step4 : TextField와 Text 사이에 Spacer 넣기
        TextField(
            value = name,
            label = {
                Text(text = "이름")
            },
            onValueChange = { name = it }
        )
        Spacer(modifier = Modifier.size(8.dp))

        // step5 : TextField를 OutlinedTextField로 변경
        OutlinedTextField(
            value = name,
            label = {
                Text(text = "이름")
            },
            onValueChange = { name = it }
        )
        Spacer(modifier = Modifier.size(8.dp))




        Text(text = "Hello $name")
    }
}

@Preview(showBackground = true)
@Composable
fun TextFieldPreview() {
    JetpackComposePracTheme {
        TextFieldEx()
    }
}