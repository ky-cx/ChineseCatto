package com.example.chinesecatto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chinesecatto.ui.theme.ChineseCattoTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChineseCattoTheme {

                    Scaffold (Modifier.fillMaxSize()){ innerPadding ->
                        WordInputScreen(modifier = Modifier.padding(innerPadding))
                        }
                }
            }
        }
    }

@Composable
fun WordInputScreen(modifier: Modifier = Modifier) {
    var textState by remember { mutableStateOf("") }

    val wordList = remember { mutableListOf<String>() }


    Column(modifier = modifier.padding(16.dp    )) {
        Text(text = "当前输入：$textState")
        TextField(
            value = textState,
            onValueChange = { nextText -> textState = nextText},
            label = { Text("请输入单词") }
        )
        Button(
            onClick = { 
                if (textState.isNotBlank()){
                    wordList.add(textState)
                    textState = ""
                }
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("添加到词库")
        }
        Text(text = "已录入个数：${wordList.size}", modifier = Modifier.padding(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun ChineseCattoPreview() {
    ChineseCattoTheme {
        WordInputScreen()
    }
}
