package com.example.jetpackcomposeprac

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposeprac.ui.theme.JetpackComposePracTheme

class CheckboxActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePracTheme {
                // A surface container using the 'background' color from the theme

                CheckboxEx()
            }
        }
    }
}

@Composable
fun CheckboxEx() {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            // step1: Checkbox 만들어보기
            // 속성은 false
            Checkbox(checked = false, onCheckedChange = {})

            Text(text = "프로그래머입니까?")
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            // step2: onCheckChanged에서 boolean 값 변수를 바꾸고
            // checked에서 반영해보기
            var checked = false
            Checkbox(
                checked = false,
                onCheckedChange = {
                    checked = !checked
                }
            )

            Text(text = "프로그래머입니까?")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            // step3: boolean 대신 remember { mutableStateOf(false) }를 사용
            var checked = remember { mutableStateOf(false) }
            Checkbox(
                checked = checked.value,
                onCheckedChange = {
                    checked.value = !checked.value
                }
            )

            Text(text = "프로그래머입니까?")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            // step4: delegated properties로 변경(checked가 프로퍼티인것 처럼)
            var checked by remember { mutableStateOf(false) }
            Checkbox(
                checked = checked,
                onCheckedChange = {
                    checked = !checked
                }
            )

            Text(text = "프로그래머입니까?")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            // step5: 비구조화(getter와 setter로 나눠 가져오기)
            val (checked, setChecked) = remember { mutableStateOf(false) }
            Checkbox(
                checked = checked,
                onCheckedChange = setChecked
            )

            Text(text = "프로그래머입니까?",
                modifier = Modifier.clickable {
                    setChecked(!checked)
                })
        }
    }

}

@Preview(showBackground = true)
@Composable
fun CheckboxPreview() {
    JetpackComposePracTheme {
        CheckboxEx()
    }
}