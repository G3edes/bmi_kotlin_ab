package br.senai.sp.jandira.bmi.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.bmi.R

@Composable

fun BMIResultScreen(modifier: Modifier=Modifier) {
    Box() {
        Box(
            modifier = Modifier
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(
                                Color(0xFF3C0F4E),
                                Color(0xFFB3D9FF),
                                Color(0xFFB3D9FF),
                            )
                        )/*0xFFB3D9FF*/
                    )
                    .height(100.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier
                        .padding(top = 55.dp, bottom = 55.dp),
                    text = stringResource(R.string.yourbmi),
                    color = Color.White,
                    fontSize = 40.sp,
                )
                Card(
                    modifier = Modifier
                        .fillMaxSize(),
                    shape = RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp),
                    colors = CardDefaults.cardColors(Color.White),

                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Card(
                            modifier=Modifier
                            .size(160.dp)
                            .padding(10.dp),
                            shape = CircleShape,
                            border = BorderStroke(5.dp, Color(0xFF3C0F4E)),
                            colors = CardDefaults.cardColors(Color.White),
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                            ) {
                                Text(
                                    text = stringResource(R.string.value),
                                    color = Color(0xFF3C0F4E),
                                    fontSize = 40.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }

                        }
                        Text(
                            text = stringResource(R.string.youhave),
                            fontSize = 25.sp
                        )
                        Card(
                            modifier=Modifier
                                .padding(16.dp),
                            colors = CardDefaults.cardColors(Color(0xFF580B77)),
                        ) {
                            Row (
                                modifier=Modifier
                                    .padding(20.dp)
                                    .width(300.dp),
                                horizontalArrangement = Arrangement.SpaceEvenly,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                )
                                {
                                    Text(
                                        text = stringResource(R.string.age),
                                        color = Color.White,
                                        fontSize = 15.sp,
                                    )
                                    Text(
                                        text = stringResource(R.string.age50),
                                        color = Color.White,
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                                Divider(
                                    modifier = Modifier
                                        .height(50.dp)
                                        .width(1.dp)

                                )
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                )
                                {
                                    Text(
                                        text = stringResource(R.string.weight),
                                        color = Color.White,
                                        fontSize = 15.sp,
                                    )
                                    Text(
                                        text = stringResource(R.string.weight97),
                                        color = Color.White,
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold
                                    )

                                }
                                Divider(
                                    modifier = Modifier
                                        .height(50.dp)
                                        .width(1.dp),
                                )
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                )
                                {
                                    Text(
                                        text = stringResource(R.string.height),
                                        color = Color.White,
                                        fontSize = 15.sp,
                                    )
                                    Text(
                                        text = stringResource(R.string.height178),
                                        color = Color.White,
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                        }
                        Column (
                            modifier=Modifier
                                .background(Color.Black)
                                .height(290.dp)
                                .width(350.dp)
                        ){  }
                        Divider(
                            modifier = Modifier
                                .width(300.dp)
                                .height(3.dp)
                        )
                        Button(onClick = {} ,
                            modifier=Modifier
                                .padding(top=20.dp),
                            shape = RoundedCornerShape(20.dp),
                            colors = ButtonDefaults.buttonColors(Color(color = 0xFF3C0F4E),)
                        ) {
                            Text(
                                modifier = Modifier,
                                text = stringResource(R.string.newcalc),

                                )
                        }
                    }
                }
            }
        }
    }
}



@Preview(showSystemUi = true)
@Composable
private fun BMIResultScreenPreview() {
    BMIResultScreen()
}