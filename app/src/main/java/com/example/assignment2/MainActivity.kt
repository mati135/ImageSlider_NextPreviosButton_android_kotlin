package com.example.assignment2

import android.os.Bundle
import android.view.PointerIcon
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment2.ui.theme.Assignment2Theme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalConfiguration

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Assignment2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SlidePicturesApp()
                }
            }
        }
    }
}

@Composable
fun SlidePicturesApp() {
    val picture1 = R.drawable.imgred
    val picture2 = R.drawable.artt2
    val picture3 = R.drawable.imgyellow

    val configuration = LocalConfiguration.current
    val isTablet = configuration.smallestScreenWidthDp >= 600

    val padding = if (isTablet) 64.dp else 16.dp
    val imageSize = if (isTablet) 400.dp else 300.dp
    val buttonText = if (isTablet) "Previous" else "Prev"

    var currentArtwork by remember {
        mutableStateOf(picture1)
    }
//Main Column
    Spacer(modifier = Modifier.height(40.dp))
    Column(
        modifier = Modifier
            .background(Color(0xFFFEFBFF))
            .padding(start = 16.dp, end = 16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        //Box for Img
        Box(
            modifier = Modifier
                .shadow(elevation = 15.dp)

        ) {
            // Image
            Image(
                painter = painterResource(id = currentArtwork),
                contentDescription = null,
                modifier = Modifier.border(30.dp, Color.White)
            )
        }
        Spacer(modifier = Modifier.height(55.dp))
        // Title and Year Text
        Column(
            modifier = Modifier
                .background(Color(0xFFECEBF4))
                .fillMaxWidth()
                .padding(horizontal = 15.dp, vertical = 10.dp)
        ) {
            when (currentArtwork) {
                picture1 -> {
                    Text(
                        text = stringResource(id = R.string.Img1_Title),
                        color = Color.Black,
                        fontSize = 23.sp,
                        textAlign = TextAlign.Justify,
                        modifier = Modifier.padding(end = 15.dp, top = 15.dp)
                    )
                    Text(
                        text = stringResource(R.string.Img1_Year),
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Justify,
                        modifier = Modifier.padding(bottom = 5.dp)
                    )
                }

                picture2 -> {
                    Text(
                        text = stringResource(id = R.string.Img2_Title),
                        color = Color.Black,
                        fontSize = 23.sp,
                        textAlign = TextAlign.Justify,
                        modifier = Modifier.padding(end = 15.dp, top = 15.dp)
                    )
                    Text(
                        text = stringResource(R.string.Img2_Year),
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Justify,
                        modifier = Modifier.padding(bottom = 5.dp)
                    )
                }

                picture3 -> {
                    Text(
                        text = stringResource(id = R.string.Img3_Title),
                        color = Color.Black,
                        fontSize = 23.sp,
                        textAlign = TextAlign.Justify,
                        modifier = Modifier.padding(end = 15.dp, top = 15.dp)
                    )
                    Text(
                        text = stringResource(R.string.Img3_Year),
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Justify,
                        modifier = Modifier.padding(bottom = 5.dp)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(40.dp))
        //ROw for Buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            // Previous Button
            Button(
                onClick = {
                    currentArtwork = when (currentArtwork) {
                        picture1 -> picture3
                        picture2 -> picture1
                        picture3 -> picture2
                        else -> picture1
                    }
                },
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 10.dp,
                    pressedElevation = 20.dp
                ),
                colors = ButtonDefaults.buttonColors(Color.Blue)
            ) {
                Text(text = "Previous", color = Color.White)
            }
            // Next Button
            Button(

                onClick = {
                    currentArtwork = when (currentArtwork) {
                        picture1 -> picture2
                        picture2 -> picture3
                        picture3 -> picture1
                        else -> picture1
                    }
                },
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 10.dp,
                    pressedElevation = 20.dp
                ),

                colors = ButtonDefaults.buttonColors(Color.Blue)
            ) {
                Text(text = "   Next   ", color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Assignment2Theme {
        SlidePicturesApp()
    }
}