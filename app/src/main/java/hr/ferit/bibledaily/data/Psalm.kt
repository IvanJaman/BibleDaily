package hr.ferit.bibledaily.data

import com.google.firebase.firestore.PropertyName
import java.util.Date

data class Psalm(
    var id: String = "",
    @PropertyName("isFavourited")
    val isFavourited: Boolean = false,
    val date: Date = Date(),
    val number: String = "",
    val chorus: String = "",
    val text: String = ""
)
