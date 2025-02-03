package com.example.jetpackcomposeprac

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposeprac.ui.theme.JetpackComposePracTheme

class TopAppBarActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePracTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopBarEx("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarEx(name: String) {
    Column {
        // step1: TopAppBar를 만들고 title 항목 채우기
        TopAppBar(title = { Text(text = "TopAppBar") })

        // step2: navigationIcon 파라미터 채우기
        // IconButton을 만들고 자식으로 Icon 넣기
        // 아이콘은 Icons.filled.ArrowBack
        // onClick은 비우기
        TopAppBar(
            title = { Text(text = "TopAppBar") },
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "업 네비게이션")
                }
            }
        )

        // step3 : actions를 추가
        // Icons.Filled의 여러 아이콘 이용
        TopAppBar(
            title = { Text(text = "TopAppBar") },
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "업 네비게이션")
                }
            },
            actions = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.Search, contentDescription = "검색")
                }
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.Settings, contentDescription = "설정")
                }
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.AccountBox, contentDescription = "계정")
                }
            }
        )

        Text(text = "Hello $name")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    JetpackComposePracTheme {
        TopBarEx("Android")
    }
}