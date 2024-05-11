package screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import repositories.GasStationInfoProvider

@Composable
fun registrationTestScreen(onNavigate: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().background(Color.White)) {
        Text("Регистрация пробы",
            modifier = Modifier.padding(0.dp, 20.dp, 0.dp,0.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 26.sp)
        Spacer(modifier = Modifier.padding(20.dp))
        showEditFields(GasStationInfoProvider.registrationFieldInfo, onNavigate)
    }
}

@Composable
fun showEditFields(listFields: MutableList<String>, onNavigate: () -> Unit) {
    var field1 by remember { mutableStateOf("") }
    var field2 by remember { mutableStateOf("") }
    var field3 by remember { mutableStateOf("") }
    var field4 by remember { mutableStateOf("") }
    var field5 by remember { mutableStateOf("") }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Шифр пробы:",
                modifier = Modifier.padding(0.dp, 0.dp, 15.dp, 0.dp).width(200.dp),
                fontSize = 18.sp,)
            OutlinedTextField(
                value = field1,
                onValueChange = {field1 = it},
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color.Black,
                    cursorColor = Color.Black
                ),
            )
        }
        Spacer(modifier = Modifier.padding(15.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Дата и время отбора: ",
                modifier = Modifier.padding(0.dp, 0.dp, 15.dp, 0.dp).width(200.dp),
                fontSize = 18.sp,)
            OutlinedTextField(
                value = field2,
                onValueChange = {field2 = it},
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color.Black,
                    cursorColor = Color.Black
                ),
            )
        }
        Spacer(modifier = Modifier.padding(15.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Дата и время поставки: ",
                modifier = Modifier.padding(0.dp, 0.dp, 15.dp, 0.dp).width(200.dp),
                fontSize = 18.sp,)
            OutlinedTextField(
                value = field3,
                onValueChange = {field3 = it},
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color.Black,
                    cursorColor = Color.Black
                ),
            )
        }
        Spacer(modifier = Modifier.padding(15.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Объем пробы: ",
                modifier = Modifier.padding(0.dp, 0.dp, 15.dp, 0.dp).width(200.dp),
                fontSize = 18.sp,)
            OutlinedTextField(
                value = field4,
                onValueChange = {field4 = it},
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color.Black,
                    cursorColor = Color.Black
                ),
            )
        }
        Spacer(modifier = Modifier.padding(15.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Объект исследования: ",
                modifier = Modifier.padding(0.dp, 0.dp, 15.dp, 0.dp).width(200.dp),
                fontSize = 18.sp,)
            OutlinedTextField(
                value = field5,
                onValueChange = {field5 = it},
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color.Black,
                    cursorColor = Color.Black
                ),
            )
        }
        Spacer(modifier = Modifier.padding(30.dp))
        Row(horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {
            saveDeleteButtons("Сохранить", onNavigate)
            Spacer(modifier = Modifier.padding(10.dp))
            saveDeleteButtons("Отменить", onNavigate)
        }
    }
}

@Composable
fun saveDeleteButtons(text: String, onNavigate: () -> Unit) {
    OutlinedButton(
        onClick = { if (text == "Сохранить") {
            onNavigate()
            GasStationInfoProvider.setTestStatus(true)
        } else
            onNavigate()},
        enabled = true,
        modifier = Modifier.size(150.dp, 50.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.Black,
            backgroundColor = Color.White
        ),
        border = BorderStroke(1.dp, Color.Black)
    ) {
        Text(text)
    }
}
