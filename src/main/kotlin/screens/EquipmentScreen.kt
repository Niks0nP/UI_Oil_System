package screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun equipmentScreen(onNavigate: () -> Unit) {
    Column {
        Button(
            onClick = { onNavigate() }
        ) {
            Text("Назад")
        }
    }
}