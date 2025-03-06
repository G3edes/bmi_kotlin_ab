package br.senai.sp.jandira.bmi.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.bmi.R

@Composable

fun UserDateScreen(modifier: Modifier=Modifier){
    Box(
        modifier = Modifier
    ){
        Row (
            modifier=Modifier
                .fillMaxWidth()
                .background(Color(0xFFB3D9FF))
                .height(100.dp),
        ){
            Text(
            text = stringResource(R.string.hi),
        )}
        Column(
            modifier=modifier
                .fillMaxSize(),
        ){
        }
        Column(

        ){  }

    }
}
@Preview(showSystemUi = true)
@Composable
private fun UserScreenPreview() {
    UserDateScreen()
}