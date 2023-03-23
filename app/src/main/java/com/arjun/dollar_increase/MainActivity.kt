package com.arjun.dollar_increase

import android.os.Bundle
import android.service.autofill.OnClickAction
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arjun.dollar_increase.ui.theme.Dollar_increaseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Dollarcounter()
        }
    }
}

@Composable
fun Dollarcounter() {
    val counter = remember {
        mutableStateOf(1)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "$${counter.value * 100}", style = MaterialTheme.typography.body1)
        Spacer(modifier = Modifier.height(90.dp))
        Custombutton {
            counter.value++
        }
        Spacer(modifier = Modifier.height(35.dp))
        Custombutton2 {
            counter.value--
        }
    }
}

@Composable
fun Custombutton(onclick: () -> Unit) {
    Card(
        modifier = Modifier
            .size(100.dp)
            .clickable {
                onclick.invoke()
            },
        shape = CircleShape,
        backgroundColor = Color.Yellow
    ) {
        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Center
        ) {
            Text(
                text = "Tap",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 20.sp, fontWeight = FontWeight.Bold
                ),
//            modifier = Modifier
//                .align(Center)
            )
        }
    }
}

@Composable
fun Custombutton2(count:()->Unit) {
    Card(
        modifier = Modifier
            .size(90.dp)
            .clip(CircleShape)
            .clickable {
                count.invoke()
            },
        backgroundColor = Color.Red
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Center) {
            Text(
                text = "Tap",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            )

        }

    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Dollar_increaseTheme {
        Dollarcounter()
    }
}