package br.senai.sp.jandira.bmi.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.bmi.R
@Composable
fun HomeScreen(navegacao: NavHostController) {

    var nameState = remember {
        mutableStateOf("Senai")
    }

    Box(
        modifier=Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        Color(0xFFB3D9FF),
                        Color(0xFF3C0F4E),
                    )
                )/*0xFFB3D9FF*/
            )
    ){
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            Image(
                modifier = Modifier
                    .padding(top = 80.dp),
                painter = painterResource(
                    R.drawable.excercise
                ),
                contentDescription = stringResource(
                    R.string.logo
                )
            )
            Text(
                text = stringResource(
                    R.string.welcome
                ),
                color = Color(color = 0xFF3C0F4E),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
            Card(
                modifier=Modifier
                    .fillMaxWidth()
                    .height(500.dp),
                shape = RoundedCornerShape(
                    topStart = 40.dp,
                    topEnd = 40.dp,
                ),
                colors = CardDefaults
                    .cardColors(
                        containerColor = Color.White
                    )
            ){
                Column(
                    modifier=Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                        verticalArrangement = (Arrangement.SpaceBetween)
                ) {
                    Column(
                        modifier=Modifier
                            .padding(20.dp)
                    ) {
                        Text(
                            text = stringResource(
                                R.string.your_name
                            ),
                            color = Color(color = 0xFF3C0F4E),
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold
                        )
                        TextField(
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Email,
                                capitalization = KeyboardCapitalization.Words,
                            ),
                            trailingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Email,
                                    contentDescription =  "",
                                    tint = Color(0xFF3C0F4E)
                                )
                            },
                            value = nameState.value,
                            onValueChange = {
                                nameState.value= it
                            },
                            label = { Text("Digite algo...")},
                            modifier = Modifier
                                .padding(top = 15.dp)
                        )
                    }
                    Column(
                        modifier=Modifier
                            .fillMaxWidth(),
                            horizontalAlignment = (Alignment.End)
                    ){
                        Button(onClick = {
                            navegacao.navigate("dados")
                        } ,
                            shape = RoundedCornerShape(8.dp)
                        )
                        {
                            Text(
                                text = stringResource(R.string.next)
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
private fun HomeScreenPreview() {
    //HomeScreen(navegacao)
}