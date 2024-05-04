package mainscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.ButtonInfo
import repositories.ButtonInfoProvider
import repositories.EquipmentInfoProvider
import repositories.GasStationInfoProvider

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

@Composable
fun mainTableAndObject() {

    val equipmentInfo = remember { EquipmentInfoProvider.equipmentInfo }
    val column1Weight = 0.1f
    val column2Weight = 0.7f
    val column3Weight = 0.4f
    val font1Weight = FontWeight.Bold
    val font2Weight = FontWeight.Normal

    LazyColumn(modifier = Modifier.background(Color.White)) {
        item {
            Row {
                Column(modifier = Modifier.weight(column1Weight)) {
                    elementTable("№", font1Weight)
                }
                Column(modifier = Modifier.weight(column2Weight)) {
                    elementTable("Измеряемый параметр", font1Weight)
                }
                Column(modifier = Modifier.weight(column3Weight)) {
                    elementTable("Готовность к проверке", font1Weight)
                }
            }
        }
        items(equipmentInfo) {
            val id = it.id
            val text = it.measurableParameter
            val readyForTest = it.readyTest
            Row {
                Column(modifier = Modifier.weight(column1Weight)) {
                    elementTable(id.toString(), font2Weight)
                }
                Column(modifier = Modifier.weight(column2Weight)) {
                    elementTable(text, font2Weight)
                }
                Column(modifier = Modifier.weight(column3Weight)) {
                    if (readyForTest == true) {
                        readyElement(Color.Green)
                    } else if (readyForTest == false) {
                        readyElement(Color.Red)
                    }
                }
            }
        }
    }
}

@Composable
fun elementTable(
    text: String,
    style: FontWeight
) {
    Row {
        Text(
            text = text,
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.Black)
                .padding(12.dp, 6.dp, 6.dp, 6.dp),
            fontWeight = style
        )
    }
}

@Composable
fun readyElement(color: Color) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.Black)
            .padding(12.dp)
    ) {
        Box(modifier = Modifier
            .clip(CircleShape)
            .background(color)
            .size(12.dp))
    }
}

@Composable
fun objectTesting() {

}



















