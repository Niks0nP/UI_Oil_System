package screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import repositories.EquipmentInfoProvider

@Composable
fun equipmentScreen(onNavigate: () -> Unit) {

    val allEquipmentInfo = remember { EquipmentInfoProvider.equipmentInfo }
    val column1Weight = 0.04f
    val column2Weight = 0.2f
    val column3Weight = 0.2f
    val column4Weight = 0.1f
    val column5Weight = 0.1f
    val column6Weight = 0.1f
    val fontBold = FontWeight.Bold
    val fontNormal = FontWeight.Normal

    Column(modifier = Modifier.fillMaxSize().background(Color.White)) {
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
                        elementTable("Описание", fontBold)
                    }
                    Column(modifier = Modifier.weight(column4Weight)) {
                        elementTable("Диапазон значений", fontBold)
                    }
                    Column(modifier = Modifier.weight(column5Weight)) {
                        elementTable("Единица измерения", fontBold)
                    }
                    Column(modifier = Modifier.weight(column6Weight)) {
                        elementTable("Норм. документ", fontBold)
                    }
                }
            }

            items(allEquipmentInfo) {
                Row {
                    Column(modifier = Modifier.weight(column1Weight)) {
                        elementTableEquipment(it.id.toString(), fontNormal)
                    }
                    Column(modifier = Modifier.weight(column2Weight)) {
                        elementTableEquipment(it.equipName, fontNormal)
                    }
                    Column(modifier = Modifier.weight(column3Weight)) {
                        elementTableEquipment(it.description!!, fontNormal)
                    }
                    Column(modifier = Modifier.weight(column4Weight)) {
                        elementTableEquipment("${it.minValue}-${it.maxValue}", fontNormal)
                    }
                    Column(modifier = Modifier.weight(column5Weight)) {
                        elementTableEquipment(it.unitOfMeasure, fontNormal)
                    }
                    Column(modifier = Modifier.weight(column6Weight)) {
                        elementTableEquipment(it.specialDocument, fontNormal)
                    }
                }
            }
        }
        Row(modifier = Modifier.padding(25.dp, 0.dp, 25.dp, 32.dp).fillMaxSize(),
            verticalAlignment = Alignment.Bottom) {
            outlinedButton("Вернуться на главный экран", onNavigate, 280.dp)
            Text("", modifier = Modifier.weight(1f))
            outlinedButton("Добавить оборудование", onNavigate, 280.dp)
        }
    }
}

@Composable
fun elementTableEquipment(text: String, style: FontWeight) {
    Row {
        Text(
            text = text,
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.LightGray)
                .padding(12.dp, 6.dp, 6.dp, 6.dp)
                .height(70.dp),
            fontWeight = style,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )
    }
}