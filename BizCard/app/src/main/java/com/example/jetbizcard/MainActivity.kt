package com.example.jetbizcard


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetbizcard.ui.theme.JetBizCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetBizCardTheme {
                    Surface (color = MaterialTheme.colorScheme.background) {
                        CreateBizCard()
                    }
                }
                }
            }
        }

@Composable
fun CreateBizCard() {
    val buttonClickedState = remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Card(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxSize(),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
                contentColor = Color.Black
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                CreateImageProfile()
                HorizontalDivider(thickness = 1.5.dp, color = Color.LightGray)
                CreateInfo()
                Button(onClick = {
                    buttonClickedState.value = !buttonClickedState.value
                }) {
                    Text("Portfolio", style = MaterialTheme.typography.labelSmall)
                }
                if (buttonClickedState.value) {
                    Content()
                }else   {
                    Box { }
                }
            }
        }
    }
}


@Preview
@Composable
fun Content(){

    Box(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .padding(5.dp)
    ){
        Surface(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
            shape = RoundedCornerShape(corner = CornerSize(6.dp)),
            color = Color.White,
            border = BorderStroke(width = 2.dp, color = Color.LightGray)
        ) {
            Portfolio(data = listOf("Project 1",
                "Project 2",
                "Project 3",
                "Project 4",
                "Project 5"))
        }
    }
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn {
    items(data){ item ->
        Card(modifier = Modifier
            .padding(13.dp)
            .fillMaxWidth(),
            shape = RectangleShape,
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
                contentColor = Color.Black
            ),
            elevation = CardDefaults.cardElevation(4.dp)
        ){
            Row(modifier = Modifier
                .padding(8.dp)
                .background(Color.White)
                .padding(7.dp)
            )
            {

                CreateImageProfile(modifier = Modifier.size(100.dp))
                Column(modifier = Modifier
                    .padding(7.dp)
                    .align(alignment = Alignment.CenterVertically)
                ) {
                    Text(text = item, fontWeight = FontWeight.Bold)
                    Text(text = "Great Project", style = MaterialTheme.typography.labelSmall)
                }
            }

        }

    }

    }

}

@Composable
private fun CreateInfo() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "Afonso S.",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.Black
        )
        Text(
            text = "Android compose Programmer",
            modifier = Modifier.padding(3.dp),
            style = MaterialTheme.typography.labelMedium,
            color = Color.Black
        )

        Text(
            text = "@Paulinhoctt",
            modifier = Modifier.padding(3.dp),
            style = MaterialTheme.typography.labelSmall,
            color = Color.Black
        )
    }
}

@Composable
private fun CreateImageProfile(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
    ) {

        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "Profile Image",
            modifier = modifier.size(135.dp),
            contentScale = ContentScale.Crop

        )
    }
}

@Preview(showBackground = true)
@Composable
fun BizCardPreview() {
    JetBizCardTheme {
        CreateBizCard()
    }
}