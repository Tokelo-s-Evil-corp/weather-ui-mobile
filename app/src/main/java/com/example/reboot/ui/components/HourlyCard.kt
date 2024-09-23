package com.example.reboot.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HourlyCard(
   time: String,
   icon: Int,
   temperature: String
){
   
   OutlinedCard (
      shape = RoundedCornerShape(30.dp),
      modifier = Modifier.size(height = 136.dp, width = 52.dp)

   ){
      Column (
         modifier = Modifier.fillMaxSize()
            .padding(4.dp),
         horizontalAlignment = Alignment.CenterHorizontally,
         verticalArrangement = Arrangement.SpaceEvenly
      ){
         Text(text = time, fontSize = 10.sp)
         Image(painter = painterResource(id = icon), contentDescription = "", Modifier.size(28.dp))
         Text(text = temperature, fontSize = 12.sp)
      }
   }

}