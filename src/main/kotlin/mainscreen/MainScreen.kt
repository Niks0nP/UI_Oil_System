package mainscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun mainScreen(
    onNavigate: () -> Unit
) {
    val backgroundColor = Color(142, 248, 216, 255)

    topInfoAboutPerson(
        onNavigate = onNavigate,
        backgroundColor
    )
}

@Composable
fun topInfoAboutPerson(
    onNavigate: () -> Unit,
    background: Color
) {
    Column(
        modifier = Modifier
            .background(background)
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 0.dp, 0.dp, 0.dp)
        ) {
            Text("Дата: 13.08.2024")
            Text("Время: 12:47:54")
            Text("Объект: АЗС Лукойл 256-Б")
            Text("Лаборатория № 256-Б-1",
                modifier = Modifier.weight(1f))
            IconButton(
                onClick = onNavigate,

            ) {
                Icon(
                    painter = painterResource(resourcePath = "exit_icon.svg"),
                    contentDescription = "Close",
                    modifier = Modifier
                        .size(24.dp)

                )
            }
        }
        Row(horizontalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 0.dp, 0.dp, 5.dp)
        ) {
            Text("Вход выполнен: Семенов А.Г., лаборант")
            Text("RFID метка сотрудника: R-1927156")
        }
    }
}

@Composable
fun menuButtons() {

}
