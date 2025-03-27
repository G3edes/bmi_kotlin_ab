package br.senai.sp.jandira.bmi.screens

import android.content.Context
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Balance
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.bmi.R

@Composable


fun UserDateScreen(navegacao: NavHostController?) {

    val iserrorstate = remember {
        mutableStateOf(false)
    }

    //colocar o arquivo em modo de edição
    var userAge = remember {
        mutableStateOf("")
    }
    var userWeight = remember {
        mutableStateOf("")
    }
    var userHeight = remember {
        mutableStateOf("")
    }

    val context = LocalContext.current
    val userFile = context
        .getSharedPreferences("userFile", Context.MODE_PRIVATE)

    val userName = userFile.getString("user_name", "User name not found!")


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
                text = stringResource(R.string.hi) + ", $userName!",
                color = Color.White,
                fontSize = 50.sp,
            )
            Card(
                modifier = Modifier
                    .fillMaxSize(),
                shape = RoundedCornerShape(topEnd = 20.dp, topStart = 20.dp),
                colors = CardDefaults.cardColors(Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .padding(top = 70.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Card(
                                modifier = Modifier
                                    .size(120.dp),
                                shape = CircleShape
                            ) {
                                Image(
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    painter = painterResource(
                                        R.drawable.perfilmen
                                    ),
                                    contentDescription = stringResource(
                                        R.string.logo
                                    )
                                )
                            }
                            Button(
                                onClick = {},
                                modifier = Modifier
                                    .width(100.dp),
                                shape = RoundedCornerShape(20.dp),
                                colors = ButtonDefaults.buttonColors(Color(color = 0xFF3C0F4E))
                            ) {
                                Text(
                                    modifier = Modifier,
                                    text = stringResource(R.string.male),
                                )
                            }
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Card(
                                modifier = Modifier
                                    .size(120.dp),
                                shape = CircleShape
                            ) {
                                Image(
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    painter = painterResource(
                                        R.drawable.perfilwoman
                                    ),
                                    contentDescription = stringResource(
                                        R.string.logo
                                    )
                                )
                            }
                            Button(
                                onClick = {},
                                modifier = Modifier
                                    .width(100.dp),
                                shape = RoundedCornerShape(20.dp),
                                colors = ButtonDefaults.buttonColors(Color(color = 0xFF3C0F4E))
                            ) {
                                Text(
                                    modifier = Modifier,
                                    text = stringResource(R.string.famale),
                                )
                            }
                        }
                    }
//                  Column(
//                        modifier = Modifier
//                            .fillMaxWidth(),
//                        horizontalAlignment = Alignment.CenterHorizontally
//                    ) {
                    OutlinedTextField(
                        modifier = Modifier
                            .padding(top = 50.dp),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        isError = iserrorstate.value,
                        supportingText = {
                            if (iserrorstate.value) {
                                Text(
                                    text = stringResource(R.string.errorname)
                                )
                            }
                        },
                        value = userAge.value,
                        onValueChange = {
                            userAge.value = it
                        },

                        label = { Text(text = stringResource(R.string.age)) },
                        leadingIcon = {
                            if (iserrorstate.value) {
                                Icon(
                                    imageVector = Icons.Default.Error,
                                    contentDescription = "",
                                    tint = Color.Red
                                )
                                Icon(
                                    imageVector = Icons.Default.DateRange,
                                    contentDescription = "",
                                    tint = (Color(color = 0xFF3C0F4E))
                                )
                            }
                        }
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .padding(top = 40.dp),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Next
                        ),
                        isError = iserrorstate.value,
                        supportingText = {
                            if (iserrorstate.value) {
                                Text(
                                    text = stringResource(R.string.errorname)
                                )
                            }
                        },
                        value = userWeight.value,
                        onValueChange = {
                            userWeight.value = it
                        },
                        label = { Text(text = stringResource(R.string.weight)) },
                        leadingIcon = {
                            if (iserrorstate.value) {
                                Icon(
                                    imageVector = Icons.Default.Error,
                                    contentDescription = "",
                                    tint = Color.Red
                                )
                                Icon(
                                    imageVector = Icons.Default.Balance,
                                    contentDescription = "",
                                    tint = (Color(color = 0xFF3C0F4E))
                                )
                            }
                        }
                    )
                    OutlinedTextField(
                        modifier = Modifier
                            .padding(top = 40.dp),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Done
                        ),
                        isError = iserrorstate.value,
                        supportingText = {
                            if (iserrorstate.value) {
                                Text(
                                    text = stringResource(R.string.errorname)
                                )
                            }
                        },
                        value = userHeight.value,
                        onValueChange = {
                            userHeight.value = it
                        },
                        label = { Text(text = stringResource(R.string.height)) },
                        leadingIcon = {
                            if (iserrorstate.value) {
                                Icon(
                                    imageVector = Icons.Default.Error,
                                    contentDescription = "",
                                    tint = Color.Red
                                )
                                Icon(
                                    imageVector = Icons.Default.Height,
                                    contentDescription = "",
                                    tint = (Color(color = 0xFF3C0F4E))
                                )
                            }
                        }
                    )

                    Button(
                        onClick = {
                            if (userAge.value.isEmpty() || userHeight.value.isEmpty() || userWeight.value.isEmpty()) {
                                iserrorstate.value=true
                            }else {
                                val editor = userFile.edit()
                                editor.putInt("user_age", userAge.value.toInt())
                                editor.putFloat("user_weight", userWeight.value.toFloat())
                                editor.putFloat("user_height", userHeight.value.toFloat())
                                editor.apply()
                                navegacao!!.navigate("resultado")
                            }
                        },
                        modifier = Modifier
                            .padding(top = 50.dp),
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonDefaults.buttonColors(Color(color = 0xFF3C0F4E))
                    ) {
                        Text(
                            modifier = Modifier,
                            text = stringResource(R.string.calculate),

                            )
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun UserScreenPreview() {
    UserDateScreen(null)
}