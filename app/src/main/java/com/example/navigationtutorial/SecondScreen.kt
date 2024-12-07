package com.example.navigationtutorial

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SecondScreen(myName:String,
                 age:String,
                 navigateToFirstScreen:(String) ->Unit,
                 navigateToThirdScreen:()->Unit){


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(text = "Welcome $myName")
        Spacer(modifier = Modifier.height(8.dp))
        Text("Your Age is $age")

        Text(text = "This is the second screen",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic
        )

        Spacer(modifier = Modifier.height(16.dp))



        Button(onClick = { navigateToFirstScreen(myName) },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "First Screen")
        }
        Button(onClick = { navigateToThirdScreen()},
            modifier = Modifier.padding(8.dp)
        ) {
        Text(text = "Third Screen")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SecondPreview(){
    SecondScreen(myName = "Dawg", age = "",{},{})
}