package com.example.reboot.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.reboot.model.DayNightPicture

@Composable
fun StagContainer(
    time: String,
    windDirection: Int,
    windDirectionUnit: String,
    cloudCoverage: Int,
    cloudCoverageUnit: String,
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(410.dp),
        verticalArrangement = Arrangement.Top,

    ) {
        val picChooser = DayNightPicture(time)
        RowPair(
            windDirection,
            windDirectionUnit,
            cloudCoverage,
            cloudCoverageUnit,
        )
        ImmersiveView(picChooser)
    }
}

@Composable
fun ImmersiveView(image: Int){
        Image(painter = painterResource(id = image), contentDescription ="",
            Modifier
                .fillMaxWidth()
                .height(300.dp)
        )
}

@Composable
fun RowPair(
    windDirection: Int,
    windDirectionUnit: String,
    cloudCoverage: Int,
    cloudCoverageUnit: String,
){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        horizontalArrangement = Arrangement.Center
    ){
        OutlinedCard(
            shape = RoundedCornerShape(32.dp),
            modifier = Modifier
                .fillMaxHeight()
                .width(100.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "wind direction", fontSize = 8.sp )
                Text(text = "${windDirection}${windDirectionUnit}", fontSize = 28.sp)
            }
        }

        Spacer(modifier = Modifier.width(20.dp))

        OutlinedCard(
            modifier = Modifier
                .fillMaxHeight()
                .width(100.dp),
            shape = RoundedCornerShape(32.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "cloud coverage", fontSize = 8.sp )
                Text(text = "${cloudCoverage}${cloudCoverageUnit}", fontSize = 28.sp)
            }
        }
    }
}