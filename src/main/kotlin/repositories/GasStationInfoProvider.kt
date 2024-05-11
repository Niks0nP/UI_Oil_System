package repositories

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import data.GasStationInfo
import data.Person
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Date
import java.text.SimpleDateFormat

object GasStationInfoProvider {

    private val sdf = SimpleDateFormat("dd/MM/yyyy")
    private val timeFormat = SimpleDateFormat("HH:mm:ss")
    private var currentDate: String = sdf.format(Date())
    private var currentTime: String = timeFormat.format(Date())
    private val testStatus = mutableStateOf(false)
    private val statusMenuButtonClick = mutableListOf(false, false)

//    suspend fun gasStationDateTime() {
//        while (true) {
//            currentDate = sdf.format(Date())
//            currentTime = timeFormat.format(Date())
//            Thread.sleep(1000)
//            println(currentTime)
//        }
//
//    }

    val persons = mutableListOf(
        Person(
            id = 1,
            name = "Андрей",
            surname = "Семенов",
            specialization = "лаборант",
            age = 22,
            rfid = 46351638,
            login = "demo",
            password = "1234"
        )
    )

    val gasStationInfo = GasStationInfo(
            nameStation = "АЗС “Лукойл” 256-Б “Липки”",
            nameLaboratory = "255-Б-1",
            address = "ул. Нижегородская 25Б",
            date = currentDate,
            time = currentTime
        )

    val registrationFieldInfo = mutableListOf(
        "Шифр пробы",
        "Дата и время отбора",
        "Дата и время поставки",
        "Объем пробы",
        "Объект исследования"
    )

    fun setTestStatus(status: Boolean) {
        testStatus.value = status
    }

    fun getTestStatus(): Boolean {
        return testStatus.value
    }

    fun setButtonMenuClickRegistration() {
        statusMenuButtonClick[0] = true
        statusMenuButtonClick[1] = false
    }

    fun setButtonMenuClickEquipment() {
        statusMenuButtonClick[0] = false
        statusMenuButtonClick[1] = true
    }

    fun clearButtons() {
        statusMenuButtonClick[0] = false
        statusMenuButtonClick[1] = false
    }

    fun getButtonMenuClick() : MutableList<Boolean> {
        return statusMenuButtonClick
    }

}










