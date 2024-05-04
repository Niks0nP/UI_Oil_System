package repositories

import data.EquipmentInfo

object EquipmentInfoProvider {

    val equipmentInfo = mutableListOf(
        EquipmentInfo(
            id = 1,
            equipName = "IIOT Анализатор давления",
            description = "Параметр, опеределяемый данной установкой, оказывает наибольшее влияние на работу топлива в двигателях внутреннего сгорания. Высокое давление насыщенных паров облегчает запуск двигателя в холодных условиях, но вместе с этим, может привести к образованию пробок в магистралях питания.",
            measurableParameter = "Уровень давления насыщенных паров бензина",
            unitOfMeasure = "кПа",
            minValue = 93.0,
            maxValue = 93.1,
            readyTest = true,
            specialDocument = "ГОСТ 1756–2000",
        ),
        EquipmentInfo(
            id = 2,
            equipName = "IIOT Анализатор фракционного состава топлива",
            description = "Фракционный состав является основным показателем испаряемости бензинов и во многом определяет их важнейшие эксплуатационные свойства.",
            measurableParameter = "Фракционный состав бензина",
            unitOfMeasure = "Град",
            minValue = 52.0,
            maxValue = 54.0,
            readyTest = true,
            specialDocument = "ГОСТ 2177–66",
        ),
        EquipmentInfo(
            id = 3,
            equipName = "IIOT Октанометр",
            description = "В нашей лаборатории октановое число определяется с помощью исследовательского метода. Метод заключается в исследовании топлива по отношению к эталонному.",
            measurableParameter = "Октановое число",
            unitOfMeasure = "ОН",
            minValue = 95.0,
            maxValue = 95.0,
            readyTest = true,
            specialDocument = "ГОСТ 8226–2015",
        ),
        EquipmentInfo(
            id = 4,
            equipName = "IIOT Аппарат определения плотности бензина",
            description = "Данная проверка определяет плотность бензина",
            measurableParameter = "Плотность бензина",
            unitOfMeasure = "кг/м^3",
            minValue = 740.0,
            maxValue = 770.0,
            readyTest = true,
            specialDocument = "ГОСТ 3900–2022",
        ),
        EquipmentInfo(
            id = 5,
            equipName = "IIOT Анализатор серы в топливе",
            description = "Пробирку с реактивом вносят в аппарат, который анализирует содержание серы",
            measurableParameter = "Процентное содержание серы",
            unitOfMeasure = "%",
            minValue = 0.015,
            maxValue = 5.000,
            readyTest = false,
            specialDocument = "ГОСТ Р 51947–2002",
        ),
        EquipmentInfo(
            id = 6,
            equipName = "IIOT Анализатор содержания воды в топливе",
            description = "В установку вносится пробирка, в которой осуществляется проверка на количество содержания воды в топливе",
            measurableParameter = "Процентное содержание воды",
            unitOfMeasure = "%",
            minValue = 0.0,
            maxValue = 3.0,
            readyTest = true,
            specialDocument = "ГОСТ Р 54281–2010",
        ),
        EquipmentInfo(
            id = 7,
            equipName = "IIOT Аппарат определения предельной температуры фильтруемости топлива",
            description = "Определение минимальной температуры горючего вещества, при которой в условиях испытания над его поверхностью образуется смесь паров и газов с воздухом, способная вспыхивать в воздухе",
            measurableParameter = "Температура вспышки в закрытом тигле",
            unitOfMeasure = "Град",
            minValue = 95.0,
            maxValue = 104.0,
            readyTest = true,
            specialDocument = "ГОСТ 6356–75",
        )
    )
}