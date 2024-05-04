package repositories

import data.Person

object GasStationInfoProvider {

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

}