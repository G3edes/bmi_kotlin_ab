package br.senai.sp.jandira.bmi.screens

import android.content.Context
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.bmi.R
import br.senai.sp.jandira.bmi.calcs.bmiCalculate
import br.senai.sp.jandira.bmi.model.BmiStatus
import br.senai.sp.jandira.bmi.screens.components.BmiLevel
import br.senai.sp.jandira.bmi.utils.convertNumberToLocale
import java.util.Locale

@Composable

fun BMIResultScreen(navegacao: NavHostController?) {

    val context = LocalContext.current
    val userFile = context
        .getSharedPreferences("userFile", Context.MODE_PRIVATE)


    val userAge = userFile.getInt("user_age", 0)
    val userWeight = userFile.getFloat("user_weight", 0.0f)
    val userHeight = userFile.getFloat("user_height", 0.0f)

    val bmi = bmiCalculate(userWeight.toInt(), userHeight.toDouble())
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
                            border = BorderStroke(
                                width=5.dp,
                                color = bmi.bmiColor),
                            colors = CardDefaults.cardColors(Color.White),
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center,
                            ) {
                                Text(
                                    text = String.format(
                                        Locale.getDefault(),
                                        "%.1f",
                                        bmi.bmi.second
                                    ),
                                    color = Color(0xFF3C0F4E),
                                    fontSize = 40.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }

                        }
                        Text(
                            text = "${bmi.bmiStatus}",
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
                                        text = "$userAge",
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
                                        text = "${userWeight}Kg",
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
                                        text = "${userHeight}cm",
                                        color = Color.White,
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                        }
                        Column (
                            modifier=Modifier
                                .height(290.dp)
                                .width(350.dp)
                        ){
                            BmiLevel(
                                bulletColor = colorResource(R.color.light_blue),
                                leftText = stringResource(R.string.underweight),
                                rightText = "<${convertNumberToLocale(18.5)}",
                                isFilled = if (bmi.bmiStatus == BmiStatus.UNDER_WEIGHT) true else false
                            )
                            BmiLevel(bulletColor = colorResource(R.color.light_green), leftText = stringResource(R.string.underweight), rightText = "<${convertNumberToLocale(18.5)}", isFilled = if (bmi.bmiStatus== BmiStatus.NORMAL) true else false)
                            BmiLevel(bulletColor = colorResource(R.color.yellow), leftText = stringResource(R.string.underweight), rightText = "<${convertNumberToLocale(18.5)}", isFilled = if (bmi.bmiStatus== BmiStatus.OBESITY_1) true else false)
                            BmiLevel(bulletColor = colorResource(R.color.light_orange), leftText = stringResource(R.string.underweight), rightText = "<${convertNumberToLocale(18.5)}", isFilled = if (bmi.bmiStatus== BmiStatus.OBESITY_2) true else false)
                            BmiLevel(bulletColor = colorResource(R.color.dark_orange), leftText = stringResource(R.string.underweight), rightText = "<${convertNumberToLocale(18.5)}", isFilled = if (bmi.bmiStatus== BmiStatus.OBESITY_3) true else false)
                            BmiLevel(bulletColor = colorResource(R.color.red), leftText = stringResource(R.string.underweight), rightText = "<${convertNumberToLocale(18.5)}", isFilled = if (bmi.bmiStatus== BmiStatus.OVER_WEIGHT) true else false)

                        }
                        Divider(
                            modifier = Modifier
                                .width(300.dp)
                                .height(3.dp)
                        )
                        Button(onClick = {
                            navegacao!!.navigate("dados")
                        },
                            modifier=Modifier
                                .padding(top=20.dp),
                            shape = RoundedCornerShape(20.dp),
                            colors = ButtonDefaults.buttonColors(Color(color = 0xFF3C0F4E),)
                        ) {
                            Text(
                                modifier = Modifier,
                                text = stringResource(R.string.newcalc),
                                color = Color.White
                                )
                        }
                    }
                }
            }
        }
    }
}



/*@Preview(showSystemUi = true)
@Composable
private fun BMIResultScreenPreview() {
    BMIResultScreen(null)
}*/