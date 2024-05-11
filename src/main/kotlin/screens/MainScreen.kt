package screens

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.ButtonInfo
import details.MainScreenNavType
import details.ProjectColors
import repositories.ButtonInfoProvider
import repositories.GasStationInfoProvider

@Composable
fun mainScreen(
    onNavigate: () -> Unit
) {
    var mainScreenNavType by remember { mutableStateOf(MainScreenNavType.MAIN_SCREEN) }
    var testStatus = GasStationInfoProvider.getTestStatus()


    Column(
        modifier = Modifier.background(ProjectColors.GREEN_BACKGROUND)
    ) {
        topInfoAboutPerson(
            onNavigate = onNavigate
        )
        Spacer(modifier = Modifier.padding(10.dp))
        menuButtons{
            if (GasStationInfoProvider.getButtonMenuClick()[0]) {
                mainScreenNavType = MainScreenNavType.REGISTRATION_SCREEN
            } else
            if (GasStationInfoProvider.getButtonMenuClick()[1]) {
                mainScreenNavType = MainScreenNavType.EQUIPMENT_SCREEN
            }
        }
        Crossfade(targetState = mainScreenNavType) { value ->
            when (value) {
                MainScreenNavType.MAIN_SCREEN -> {
                    Column {
                        Spacer(modifier = Modifier.padding(25.dp))
                        mainTableAndObject(testStatus)
                    }
                }
                MainScreenNavType.REGISTRATION_SCREEN -> {
                    Column {
                        Spacer(modifier = Modifier.padding(25.dp))
                        registrationTestScreen{
                            mainScreenNavType = MainScreenNavType.MAIN_SCREEN
                        }
                    }
                    testStatus = GasStationInfoProvider.getTestStatus()
                    GasStationInfoProvider.clearButtons()
                }
                MainScreenNavType.EQUIPMENT_SCREEN -> {
                    Column {
                        Spacer(modifier = Modifier.padding(25.dp))
                        equipmentScreen{
                            mainScreenNavType = MainScreenNavType.MAIN_SCREEN
                        }
                    }
                    GasStationInfoProvider.clearButtons()
                }
            }
        }

    }
}

@Composable
fun topInfoAboutPerson(
    onNavigate: () -> Unit,
) {
    val person = remember { GasStationInfoProvider.persons[0] }
    val gasStation = remember { GasStationInfoProvider.gasStationInfo }


    Row {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier
                    .padding(20.dp, 0.dp, 0.dp, 0.dp)
            ) {
                Text("Дата: ${gasStation.date};")
                Text("Время: ${gasStation.time};")
                Text("Объект: ${gasStation.nameStation};")
                Text("Лаборатория № ${gasStation.nameLaboratory}")
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
fun menuButtons(onNavigate: () -> Unit) {
    val buttonsInfo = remember { ButtonInfoProvider.buttonsInfo }
    LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.padding(20.dp, 0.dp, 0.dp, 0.dp)) {
        items(buttonsInfo) {
            menuButtonItem(it) {
                onNavigate()
            }
        }
    }
}

@Composable
fun menuButtonItem(buttonInfo: ButtonInfo, onNavigate: () -> Unit) {
    Button(onClick = {
        when (buttonInfo.idBtn) {
            1 -> {
                GasStationInfoProvider.setButtonMenuClickRegistration()
                onNavigate()
            }
            3 -> {
                GasStationInfoProvider.setButtonMenuClickEquipment()
                onNavigate()
            }
        }
    },
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





















