package com.example.navigationtutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationtutorial.ui.theme.NavigationTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "first"
    )
    {
        composable("first")
        {
            FirstScreen {myName->
                navController.navigate("second/$myName")
            }
        }
        composable("second/{myName}")
        {val name = it.arguments?.getString("myName")?:"no name"
            SecondScreen(name,
                navigateToFirstScreen = { navController.navigate("first") },
                navigateToThirdScreen = {navController.navigate("third")}
            )
        }
        composable("third")
        {
            ThirdScreen {
                navController.navigate("first")
            }
        }

    }
}
