package com.example.dogoodmobile.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.dogoodmobile.android.core.presentation.Routes
import com.example.dogoodmobile.android.detail_screen.presentation.AndroidDetailScreenViewModel
import com.example.dogoodmobile.android.detail_screen.presentation.DetailScreen
import com.example.dogoodmobile.android.list_screen.presentation.AndroidVolunteeringListScreenViewModel
import com.example.dogoodmobile.android.list_screen.presentation.VolunteeringListScreen
import com.example.dogoodmobile.android.main_screen.presentation.AndroidMainScreenViewModel
import com.example.dogoodmobile.android.main_screen.presentation.MainScreen
import com.example.dogoodmobile.volunteering.detail.presentation.DetailScreenEvent
import com.example.dogoodmobile.volunteering.list.presentation.ListScreenEvent
import com.example.dogoodmobile.volunteering.main.presentation.MainScreenEvent
import dagger.hilt.android.AndroidEntryPoint

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        com.example.dogoodmobile.android.core.theme.darkColors
    } else {
        com.example.dogoodmobile.android.core.theme.lightColors
    }
    val typography = Typography(
        body1 = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
    )
    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
    )

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DoGoodAppNavHost()
                }
            }
        }
    }
}

@Composable
fun DoGoodAppNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.MAIN_SCREEN
    ) {
        composable(route = Routes.MAIN_SCREEN) {
            val viewModel = hiltViewModel<AndroidMainScreenViewModel>()
            val state by viewModel.state.collectAsState()
            MainScreen(
                state = state,
                onEvent = { event ->
                    when (event) {
                        is MainScreenEvent.ChooseVolunteeringType -> {
                            navController.navigate(Routes.LIST + "/${event.id}")
                        }
                        is MainScreenEvent.ClickFeaturedVolunteeringAd -> {
                            navController.navigate(Routes.DETAIL + "/${event.id}")
                        }
                        else -> viewModel.onEvent(event)
                    }

                }
            )
        }
        composable(
            route = Routes.LIST + "/{typeId}",
            arguments = listOf(
                navArgument("typeId") {
                    type = NavType.StringType
                }
            )
        ) {
            val viewModel = hiltViewModel<AndroidVolunteeringListScreenViewModel>()
            val state by viewModel.state.collectAsState()
            val typeId = it.arguments?.getString("typeId") ?: "1"

            VolunteeringListScreen(
                state = state,
                typeId = typeId,
                onEvent = { event ->
                    when (event) {
                        ListScreenEvent.ClickBackButton -> {
                            navController.navigate(Routes.MAIN_SCREEN)
                        }
                        is ListScreenEvent.ClickVolunteering -> {
                            navController.navigate(Routes.DETAIL + "/${event.id}")
                        }
                        else -> {
                            viewModel.onEvent(event)
                        }
                    }
                }
            )
        }
        composable(
            route = Routes.DETAIL + "/{detailId}",
            arguments = listOf(
                navArgument("detailId") {
                    type = NavType.StringType
                }
            )
        ) {
            val viewModel = hiltViewModel<AndroidDetailScreenViewModel>()
            val state by viewModel.state.collectAsState()
            val detailId = it.arguments?.getString("detailId") ?: "1"

            DetailScreen(
                state = state,
                volunteeringDetailId = detailId,
                onEvent = { event ->
                    when (event) {
                        is DetailScreenEvent.ClickBackButton -> {
                            navController.navigate(Routes.MAIN_SCREEN)
                        }
                        else -> {
                            viewModel.onEvent(event)
                        }
                    }

                }
            )

        }
    }
}

@Composable
fun Greeting(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        Greeting("Hello, Android!")
    }
}
