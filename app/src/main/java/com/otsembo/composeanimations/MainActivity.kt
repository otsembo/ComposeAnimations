package com.otsembo.composeanimations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.otsembo.composeanimations.ui.theme.ComposeAnimationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAnimationsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Soccer()
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun Soccer() {

    var visible by remember { mutableStateOf(true) }
    val density = LocalDensity.current

    Column(
        modifier = Modifier.padding(top = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Button(onClick = { visible = !visible }) {
            Text(text = "TOGGLE")
        }

        AnimatedVisibility(
            visible = visible,
            enter = slideInVertically {
                with(density){-1.dp.roundToPx()}
            } + expandVertically() + fadeIn(),
            exit = slideOutVertically{
                with(density){1.dp.roundToPx()}
            } + shrinkVertically() + fadeOut()) {

            Image(
                modifier = Modifier
                    .size(150.dp),
                contentScale = ContentScale.Fit,
                painter = painterResource(id = R.drawable.ic_ball),
                contentDescription = stringResource(id = R.string.soccer) )

        }

    }




}
