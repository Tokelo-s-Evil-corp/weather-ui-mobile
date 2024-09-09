package com.example.reboot.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HourlyCard(
   time: String,
   icon: String,
   temperature: String
){
   
   OutlinedCard (
      shape = RoundedCornerShape(30.dp),
      modifier = Modifier.size(height = 100.dp, width = 50.dp)
   ){
      Column (
         modifier = Modifier.fillMaxSize(),
         horizontalAlignment = Alignment.CenterHorizontally,
         verticalArrangement = Arrangement.SpaceEvenly
      ){
         Text(text = time, fontSize = 14.sp)
         Text(text = icon, fontSize = 14.sp)
         Text(text = temperature, fontSize = 14.sp)
      }
   }

}