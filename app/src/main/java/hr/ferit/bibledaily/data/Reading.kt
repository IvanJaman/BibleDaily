package hr.ferit.bibledaily.data

import com.google.firebase.firestore.PropertyName
import java.util.Date

data class Reading(
    var id: String = "",
    @PropertyName("isFavourited")
    val isFavourited: Boolean = false,
    val date: Date = Date(),
    val number: String = "",
    val mainThought: String = "",
    val text: String = ""
)
