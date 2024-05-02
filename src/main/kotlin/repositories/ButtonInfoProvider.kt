package repositories

import data.ButtonInfo

object ButtonInfoProvider {

    val buttonsInfo = mutableListOf(
        ButtonInfo(
            idBtn = 1,
            nameBtn = "Регистрация проб",
            imageBtn = "registration_test.png"
        ),
        ButtonInfo(
            idBtn = 2,
            nameBtn = "Журнал проверок",
            imageBtn = "list_changes.png"
        ),
        ButtonInfo(
            idBtn = 3,
            nameBtn = "Оборудование",
            imageBtn = "equipment.png"
        ),
        ButtonInfo(
            idBtn = 4,
            nameBtn = "Норм. документы",
            imageBtn = "spec_documents.png"
        ),
        ButtonInfo(
            idBtn = 5,
            nameBtn = "Отчеты",
            imageBtn = "documents.png"
        ),
        ButtonInfo(
            idBtn = 6,
            nameBtn = "Сотрудники",
            imageBtn = "people.png"
        ),
    )
}