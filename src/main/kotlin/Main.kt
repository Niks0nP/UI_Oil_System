import androidx.compose.animation.Crossfade
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import details.OilNavType
import kotlinx.coroutines.launch
import screens.mainScreen
import repositories.GasStationInfoProvider


@Composable
@Preview
fun app() {
    MaterialTheme {
        var oilNavType by remember { mutableStateOf(OilNavType.LOGIN) }
        Crossfade(targetState = oilNavType) { value ->
            when (value) {
                OilNavType.LOGIN -> {
                    loginScreen {
                        oilNavType = OilNavType.MAIN_SCREEN
                    }
                }
                OilNavType.MAIN_SCREEN -> mainScreen {
                    oilNavType = OilNavType.LOGIN
                }
            }
        }
    }
}

@Composable
fun loginScreen(
    onNavigate: () -> Unit
) {
    val scaffoldState = rememberScaffoldState()
    val snackBarCoroutineScope = rememberCoroutineScope()
    val login = remember { GasStationInfoProvider.persons[0].login }
    val password = remember { GasStationInfoProvider.persons[0].password }
    val text by remember { mutableStateOf("Войти") }
    var loginTextInput by remember { mutableStateOf("") }
    var passwordTextInput by remember { mutableStateOf("") }

    Scaffold(scaffoldState = scaffoldState) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                text = "Вход в систему",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 10.dp)
            )
            OutlinedTextField(
                value = loginTextInput,
                onValueChange = {loginTextInput = it},
                label = { Text("Логин")},
                modifier = Modifier
                    .padding(0.dp, 0.dp, 0.dp, 5.dp)
            )
            OutlinedTextField(
                value = passwordTextInput,
                onValueChange = {passwordTextInput = it},
                label = { Text("Пароль") },
                modifier = Modifier
                    .padding(0.dp, 0.dp, 0.dp, 20.dp)
            )
            Button(onClick = {
                if (loginTextInput == login && passwordTextInput == password) {
                    onNavigate()
                } else
                    snackBarCoroutineScope.launch{
                        scaffoldState.snackbarHostState.showSnackbar("Неправильный логин или пароль")
                    }
            },
                modifier = Modifier
                    .size(280.dp, 40.dp)) {
                Text(text)
            }
        }
    }
}

fun main() = application {
    Window(
        title = "Система проверки топлива",
        onCloseRequest = ::exitApplication,
        state = WindowState(WindowPlacement.Maximized)
    ) {
        app()
    }
}

