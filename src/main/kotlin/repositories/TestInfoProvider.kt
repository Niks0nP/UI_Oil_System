package repositories

import androidx.compose.runtime.mutableStateOf
import data.Test

object TestInfoProvider {

    val isEnabled95 = mutableStateOf(false)
    val isEnabled92 = mutableStateOf(false)

    val testList = mutableListOf(
        Test(
            idTest = 1,
            nameTest = "Проверка бензина",
            fieldType = "Бензин АИ-95",
            volumeTest = 350.1,
            valueTest = mapOf(
                "Уровень давления насыщенных паров бензина" to 93.05,
                "Фракционный состав бензина" to 57.0,
                "Октановое число" to 95.0,
                "Плотность бензина" to 750.0,
                "Процентное содержание серы" to 2.39,
                "Процентное содержание воды" to 1.82,
                "Температура вспышки в закрытом тигле" to 99.0)
        )
    )
}