package data

data class EquipmentInfo(
    val id: Int,
    val equipName: String,
    val description: String?,
    val measurableParameter: String,
    val unitOfMeasure: String,
    val minValue: Double,
    val maxValue: Double,
    val readyTest: Boolean?,
    val specialDocument: String,
)
