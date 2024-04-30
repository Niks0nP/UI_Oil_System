import androidx.compose.animation.Crossfade
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import mainscreen.mainScreen


@Composable
@Preview
fun App() {
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

    val text by remember { mutableStateOf("Войти") }
    var loginText by remember { mutableStateOf("") }
    var passwordText by remember { mutableStateOf("") }

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
            value = loginText,
            onValueChange = {loginText = it},
            label = { Text("Логин")},
            modifier = Modifier
                .padding(0.dp, 0.dp, 0.dp, 5.dp)
        )
        OutlinedTextField(
            value = passwordText,
            onValueChange = {passwordText = it},
            label = { Text("Пароль") },
            modifier = Modifier
                .padding(0.dp, 0.dp, 0.dp, 20.dp)
        )
        Button(onClick = {
            onNavigate()
        },
            modifier = Modifier
                .size(280.dp, 40.dp)) {
            Text(text)
        }
    }
}

@Composable
fun changeScreen(oilNavType: OilNavType) {

}

fun main() = application {
    Window(
        title = "Система проверки топлива",
        onCloseRequest = ::exitApplication,
        state = WindowState(WindowPlacement.Maximized)
    ) {
        App()
    }
}

