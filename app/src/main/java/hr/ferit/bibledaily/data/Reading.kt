package hr.ferit.bibledaily.data

import com.google.firebase.firestore.PropertyName

data class Reading(
    var id: String = "",
    @PropertyName("isFavourited")
    val isFavourited: Boolean = false,
    val number: String = "",
    val mainThought: String = "",
    val text: String = ""
)
