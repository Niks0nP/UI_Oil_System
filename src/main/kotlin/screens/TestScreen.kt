package screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import details.ProjectColors
import repositories.EquipmentInfoProvider
import repositories.TestInfoProvider


@Composable
fun testScreen(onNavigateToMainScreen: () -> Unit) {
    Column {
        Row(horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically) {
            buttonTest("Прервать проверку", ProjectColors.RED_BUTTON, onNavigateToMainScreen)
            Column(modifier = Modifier.weight(1f)) {
                Text(if (TestInfoProvider.isEnabled95.value) "Объект проверки: Бензин АИ-95"
                else if (TestInfoProvider.isEnabled92.value) "Объект проверки: Бензин АИ-92" else "",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(400.dp, 0.dp, 0.dp, 0.dp)
                )
            }
        }
        Spacer(modifier = Modifier.padding(15.dp))
        Column(modifier = Modifier.background(Color.White)) {
            tableTest()
        }
        Row(horizontalArrangement = Arrangement.End,
            modifier = Modifier.padding(0.dp, 16.dp, 16.dp, 0.dp)) {
            buttonTest("Сформировать отчет", ProjectColors.GREEN_BUTTON, onNavigateToMainScreen)
        }
    }
}

@Composable
fun buttonTest(text: String, background: Color, onNavigateToMainScreen: () -> Unit) {
    Button(
        onClick = { if (text == "Прервать проверку") onNavigateToMainScreen()},
        colors = ButtonDefaults.buttonColors(
            backgroundColor = background
        ),
        modifier = Modifier.padding(16.dp, 0.dp, 0.dp, 0.dp).width(250.dp)
    ) {
        Text(text)
    }
}

@Composable
fun tableTest() {

    val testEquipmentInfo = remember { EquipmentInfoProvider.equipmentInfo }
    val column1Weight = 0.04f
    val column2Weight = 0.35f
    val column3Weight = 0.2f
    val column4Weight = 0.1f
    val column5Weight = 0.1f
    val column6Weight = 0.1f
    val column7Weight = 0.1f
    val fontBold = FontWeight.Bold
    val fontNormal = FontWeight.Normal
    val testList = remember { TestInfoProvider.testList[0] }

    LazyColumn {
        item {
            Row {
                Column(modifier = Modifier.weight(column1Weight)) {
                    elementTable("№", fontBold)
                }
                Column(modifier = Modifier.weight(column2Weight)) {
                    elementTable("Наименование оборудования", fontBold)
                }
                Column(modifier = Modifier.weight(column3Weight)) {
                    elementTable("Измеряемая величина", fontBold)
                }
                Column(modifier = Modifier.weight(column4Weight)) {
                    elementTable("Диапазон значений", fontBold)
                }
                Column(modifier = Modifier.weight(column5Weight)) {
                    elementTable("Значение", fontBold)
                }
                Column(modifier = Modifier.weight(column6Weight)) {
                    elementTable("Статус", fontBold)
                }
                Column(modifier = Modifier.weight(column7Weight)) {
                    elementTable("Состояние", fontBold)
                }
            }
        }

        items(testEquipmentInfo) {
            Row {
                Column(modifier = Modifier.weight(column1Weight)) {
                    elementTable(it.id.toString(), fontNormal)
                }
                Column(modifier = Modifier.weight(column2Weight)) {
                    elementTable(it.equipName, fontNormal)
                }
                Column(modifier = Modifier.weight(column3Weight)) {
                    elementTable(it.unitOfMeasure, fontNormal)
                }
                Column(modifier = Modifier.weight(column4Weight)) {
                    elementTable("${it.minValue}-${it.maxValue}", fontNormal)
                }
                Column(modifier = Modifier.weight(column5Weight)) {
                    elementTable(testList.valueTest[it.measurableParameter].toString(), fontNormal)
                }
                Column(modifier = Modifier.weight(column6Weight)) {
                    readyElement(if (testList.valueTest[it.measurableParameter]!! <= it.maxValue &&
                        testList.valueTest[it.measurableParameter]!! >= it.minValue)
                        ProjectColors.GREEN_BUTTON else ProjectColors.RED_BUTTON)
                }
                Column(modifier = Modifier.weight(column7Weight)) {
                    readyElement(ProjectColors.GREEN_BUTTON)
                }
            }
        }
    }
}