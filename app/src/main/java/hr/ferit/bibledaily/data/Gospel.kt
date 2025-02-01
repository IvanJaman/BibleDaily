package hr.ferit.bibledaily.data

import com.google.firebase.firestore.PropertyName

data class Gospel(
    var id: String = "",
    @PropertyName("isFavourited")
    val isFavourited: Boolean = false,
    val number: String = "",
    val mainThought: String = "",
    val text: String = ""
) {
}
