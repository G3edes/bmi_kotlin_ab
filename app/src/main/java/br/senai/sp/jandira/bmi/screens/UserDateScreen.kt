package br.senai.sp.jandira.bmi.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable

fun UserDateScreen(modifier: Modifier=Modifier){
    Box(
        modifier = Modifier
    ){
        Row (
            modifier=Modifier
                .fillMaxWidth()

        ){  }
    }
}
@Preview(showSystemUi = true)
@Composable
private fun UserScreenPreview() {
    UserDateScreen()
}