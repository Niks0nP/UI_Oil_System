package screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import details.ProjectColors
import repositories.EquipmentInfoProvider

@Composable
fun mainTableAndObject() {

    val equipmentInfo = remember { EquipmentInfoProvider.equipmentInfo }
    val column1Weight = 0.1f
    val column2Weight = 0.7f
    val column3Weight = 0.4f
    val font1Weight = FontWeight.Bold
    val font2Weight = FontWeight.Normal

    Row {
        Column(modifier = Modifier.background(Color.White).weight(0.75f).fillMaxHeight()) {
            LazyColumn {
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
                                readyElement(ProjectColors.GREEN_BUTTON)
                            } else if (readyForTest == false) {
                                readyElement(ProjectColors.RED_BUTTON)
                            }
                        }
                    }
                }
            }
            startTestPanel()
        }
        Column(modifier = Modifier.weight(0.25f)) {
            testingObject()
        }
    }
}

@Composable
fun startTestPanel() {
    Row(horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.Bottom,
        modifier = Modifier.fillMaxSize().padding(0.dp, 0.dp, 20.dp, 10.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(20.dp), verticalAlignment = Alignment.CenterVertically) {

            Text("Нет добавленных проб!")
            OutlinedButton(
                onClick = {},
                enabled = true,
                modifier = Modifier.size(300.dp, 50.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Black,
                    backgroundColor = Color.White
                ),
                border = BorderStroke(1.dp, Color.Black)
            ) {
                Text("Начать испытания")
            }
        }
    }
}

@Composable
fun elementTable(text: String, style: FontWeight) {
    Row {
        Text(
            text = text,
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.LightGray)
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
            .border(1.dp, Color.LightGray)
            .padding(11.dp)
    ) {
        Box(modifier = Modifier
            .clip(CircleShape)
            .background(color)
            .size(13.dp)
            .border(1.dp, Color.Black, shape = CircleShape))
    }
}

@Composable
fun testingObject() {
    val isEnabled1 = remember { mutableStateOf(false) }
    val isEnabled2 = remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxHeight().background(Color.White).border(1.dp, Color.Black)) {
        Text(
            text = "Объект исследования",
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(240, 240, 240, 255))
                .border(1.dp, Color.Black)
                .padding(12.dp)
        )

        buttonObject("Бензин АИ-95", isEnabled1) {
            isEnabled1.value = true
            isEnabled2.value = false
        }
        buttonObject("Бензин АИ-92", isEnabled2) {
            isEnabled1.value = false
            isEnabled2.value = true
        }

        Row(modifier = Modifier.padding(10.dp, 0.dp, 0.dp, 10.dp).fillMaxHeight(),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.Bottom) {

            addDeleteButtons(ProjectColors.GREEN_BUTTON, Icons.Default.Add)
            addDeleteButtons(ProjectColors.RED_BUTTON, Icons.Default.Delete)
        }
    }
}

@Composable
fun buttonObject(text: String, isEnabled: MutableState<Boolean>, onNavigate: () -> Unit) {
    OutlinedButton(
        onClick = onNavigate,
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.Black,
            backgroundColor = Color.White),
        modifier = Modifier.fillMaxWidth().padding(10.dp, 10.dp, 10.dp, 0.dp),
        border = BorderStroke(1.dp, Color.Black)) {

        Row(horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically) {
            if (isEnabled.value) {
                Box(modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.Black)
                    .size(10.dp))
            }
            Text(text)
        }
    }
}

@Composable
fun addDeleteButtons(color: Color, icon: ImageVector) {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(backgroundColor = color),
        modifier = Modifier.clip(CircleShape).size(50.dp)) {
        Icon(imageVector = icon,
            contentDescription = "")
    }
}
