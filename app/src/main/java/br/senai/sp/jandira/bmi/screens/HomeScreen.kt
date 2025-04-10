package br.senai.sp.jandira.bmi.screens

import android.content.Context
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
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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

    var iserrorstate = remember {
        mutableStateOf(false)
    }

    var nameState = remember {
        mutableStateOf("")
    }

    //abrir ou criar um arquivo SharedPreferences

    val context = LocalContext.current
    val userFile = context
        .getSharedPreferences("userFile", Context.MODE_PRIVATE)

    //colocar o arquivo em modo de edição
    val editor = userFile.edit()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        Color(0xFFB3D9FF),
                        Color(0xFF3C0F4E),
                    )
                )/*0xFFB3D9FF*/
            )
    ) {
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
                modifier = Modifier
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
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    verticalArrangement = (Arrangement.SpaceBetween)
                ) {
                    Column(
                        modifier = Modifier
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
                        OutlinedTextField(
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Email,
                                capitalization = KeyboardCapitalization.Words,
                            ),
                            isError = iserrorstate.value,
                            supportingText = {
                                if (iserrorstate.value) {
                                    Text(
                                        text = stringResource(R.string.errorname)
                                    )


                                }
                            },
                            trailingIcon = {
                                if (iserrorstate.value){
                                    Icon(
                                        imageVector = Icons.Default.Error,
                                        contentDescription = "",
                                        tint= Color.Red
                                    )
                                }
                            },
                            value = nameState.value,
                            onValueChange = {
                                nameState.value = it
                            },
                            label = { Text("Digite algo...") },
                            modifier = Modifier
                                .padding(top = 15.dp)
                                .fillMaxWidth()
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = (Alignment.End)
                    ) {
                        Button(
                            onClick = {
                                if (nameState.value.isEmpty()) {
                                    iserrorstate.value = true
                                } else {
                                    editor.putString("user_name", nameState.value)
                                    editor.apply()
                                    navegacao.navigate("dados")
                                }
                            },
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

/*@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}*/