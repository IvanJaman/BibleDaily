package hr.ferit.bibledaily.data

import com.google.firebase.firestore.PropertyName

data class Psalm(
    var id: String = "",
    @PropertyName("isFavourited")
    val isFavourited: Boolean = false,
    val number: String = "",
    val chorus: String = "",
    val text: String = ""
)
