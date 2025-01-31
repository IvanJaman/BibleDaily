package hr.ferit.bibledaily.data

data class Psalm(
    var id: String = "",
    val isFavourited: Boolean = false,
    val number: String = "",
    val chorus: String = "",
    val text: String = ""
)
