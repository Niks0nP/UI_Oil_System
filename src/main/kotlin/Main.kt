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


@Composable
@Preview
fun App() {
    val text by remember { mutableStateOf("Войти") }
    var loginText by remember { mutableStateOf("") }
    var passwordText by remember { mutableStateOf("") }

    MaterialTheme {
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

            },
                modifier = Modifier
                    .size(280.dp, 40.dp)) {
                Text(text)
            }
        }

    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication,
        state = WindowState(WindowPlacement.Maximized)
    ) {
        App()
    }
}
