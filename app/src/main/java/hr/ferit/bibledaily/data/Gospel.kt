package hr.ferit.bibledaily.data

data class Gospel(
    var id: String = "",
    val isFavourited: Boolean = false,
    val number: String = "",
    val mainThought: String = "",
    val text: String = ""
)
