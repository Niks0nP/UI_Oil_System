package mainscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.ButtonInfo
import repositories.ButtonInfoProvider

@Composable
fun mainScreen(
    onNavigate: () -> Unit
) {
    val backgroundColor = Color(142, 248, 216, 255)

    Column(
        modifier = Modifier.background(backgroundColor)
    ) {
        topInfoAboutPerson(
            onNavigate = onNavigate
        )
        Spacer(modifier = Modifier.padding(10.dp))
        menuButtons()
    }

}

@Composable
fun topInfoAboutPerson(
    onNavigate: () -> Unit,
) {
    Row {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier
                    .padding(20.dp, 0.dp, 0.dp, 0.dp)
            ) {
                Text("Дата: 13.08.2024")
                Text("Время: 12:47:54")
                Text("Объект: АЗС Лукойл 256-Б")
                Text("Лаборатория № 256-Б-1")
            }
            Spacer(modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 5.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier
                    .padding(20.dp, 0.dp, 0.dp, 5.dp)
            ) {
                Text("Вход выполнен: Семенов А.Г., лаборант")
                Text("RFID метка сотрудника: R-1927156")
            }
        }

        Column(verticalArrangement = Arrangement.Center) {
            IconButton(
                onClick = onNavigate,
                modifier = Modifier.padding(0.dp, 5.dp, 16.dp, 0.dp)
            ) {
                Icon(
                    painter = painterResource(resourcePath = "exit_icon.svg"),
                    contentDescription = "Close",
                    modifier = Modifier
                        .size(24.dp)
                )
            }
        }
    }
    Divider(color = Color.LightGray, thickness = 1.dp)
}

@Composable
fun menuButtons() {
    val items = remember { ButtonInfoProvider.buttonsInfo }
    Row(horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.padding(20.dp, 0.dp, 0.dp, 0.dp)) {
        items.forEach {
            menuButtonItem(it)
        }
    }
}

@Composable
fun menuButtonItem(buttonInfo: ButtonInfo) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(130.dp, 80.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
    ) {
        Column {
            Image(
                painter = painterResource(buttonInfo.imageBtn),
                contentDescription = "Image Button",
                modifier = Modifier.size(50.dp, 50.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = buttonInfo.nameBtn,
                fontSize = 12.sp
            )
        }

    }
}
