package screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
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
import details.ProjectColors
import repositories.ButtonInfoProvider
import repositories.GasStationInfoProvider

@Composable
fun mainScreen(
    onNavigate: () -> Unit
) {

    Column(
        modifier = Modifier.background(ProjectColors.GREEN_BACKGROUND)
    ) {
        topInfoAboutPerson(
            onNavigate = onNavigate
        )
        Spacer(modifier = Modifier.padding(10.dp))
        menuButtons()
        Spacer(modifier = Modifier.padding(25.dp))
        mainTableAndObject()
    }
}

@Composable
fun topInfoAboutPerson(
    onNavigate: () -> Unit,
) {
    val person = remember { GasStationInfoProvider.persons[0] }
    Row {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier
                    .padding(20.dp, 0.dp, 0.dp, 0.dp)
            ) {
                Text("Дата: 13.08.2024;")
                Text("Время: 12:47:54;")
                Text("Объект: АЗС Лукойл 256-Б;")
                Text("Лаборатория № 256-Б-1")
            }
            Spacer(modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 5.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier
                    .padding(20.dp, 0.dp, 0.dp, 5.dp)
            ) {
                Text("Вход выполнен: ${person.surname} ${person.name} ${person.specialization};")
                Text("RFID метка сотрудника: R-${person.rfid}")
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
    val buttonsInfo = remember { ButtonInfoProvider.buttonsInfo }
    LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.padding(20.dp, 0.dp, 0.dp, 0.dp)) {
        items(buttonsInfo) {
            menuButtonItem(it)
        }
    }
}

@Composable
fun menuButtonItem(buttonInfo: ButtonInfo) {
    Button(onClick = {},
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White),
        modifier = Modifier.clip(RoundedCornerShape(10.dp)).size(150.dp, 85.dp)) {
        Column {
            Image(
                painter = painterResource(buttonInfo.imageBtn),
                contentDescription = "Image Button",
                modifier = Modifier.size(50.dp, 50.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = buttonInfo.nameBtn,
                fontSize = 11.sp,
                color = Color.Black
            )
        }
    }
}





















