package tw.edu.pu.a123

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tw.edu.pu.a123.ui.theme._123Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _123Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "黃鎰弘",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
//    var x:Int = 0
//    var x by remember { mutableStateOf(0) }
    var x = remember { mutableStateOf(0) }
    Column{
        Row {
            Button(
            onClick = {
                x.value = 0
            }

        ) {
            Text("歸零")
            Image(
                painter = painterResource(id = R.drawable.star),
                contentDescription = "star照片",
                alpha = 0.9f,
                modifier = modifier.size(15.dp)
            )


        }
            Button(
                onClick = {
                    x.value = x.value*2
                }

            ) {
                Text("雙倍")
                Image(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = "star照片",
                    alpha = 0.9f,
                    modifier = modifier.size(15.dp)
                )


            }

        }

       /* Text(text = x.toString(),
            fontSize = 50.sp,
            modifier = Modifier.clickable { x++ }

            )*/
        Text(text = x.value.toString(),
            fontSize = 50.sp,
            modifier = Modifier.clickable { x.value++ }

        )
    Row {
        Text(
        text = stringResource(R.string.author),
        fontFamily = FontFamily(Font(R.font.kai)),
        fontSize = 30.sp,
        color = Color.Cyan,
        modifier = modifier
    )

        Image(
            painter = painterResource(id = R.drawable.dog),
            contentDescription = "狗照片",
            alpha = 0.9f,
            modifier = modifier.clip(CircleShape)
        ) }
        Box(    modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.dog),
                contentDescription = "狗照片",
                alpha = 0.9f,
                modifier = modifier
            )
        }

}
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    _123Theme {
        Greeting("Android")
    }
}