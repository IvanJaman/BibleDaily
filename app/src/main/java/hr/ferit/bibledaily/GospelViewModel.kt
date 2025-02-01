package hr.ferit.bibledaily

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import hr.ferit.bibledaily.data.Gospel

class GospelViewModel: ViewModel() {
    private val db = Firebase.firestore
    val gospelsData = mutableStateListOf<Gospel>()

    init {
        fetchDatabaseData()
    }

    private fun fetchDatabaseData() {
        db.collection("gospels")
            .get()
            .addOnSuccessListener { result ->
                for (data in result.documents) {
                    val gospel = data.toObject(Gospel::class.java)
                    if (gospel != null) {
                        gospel.id = data.id
                        gospelsData.add(gospel)
                    }
                }
            }
    }

    fun updateGospel(gospel: Gospel) {
        db.collection("gospels")
            .document(gospel.id)
            .set(gospel)
    }

    fun fetchFavouritedGospels() {
        db.collection("gospels")
            .whereEqualTo("isFavourited", true)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    gospelsData.clear()
                    task.result?.documents?.forEach { document ->
                        val gospel = document.toObject(Gospel::class.java)
                        if (gospel != null) {
                            gospel.id = document.id
                            gospelsData.add(gospel)
                        }
                    }
                }
            }
    }
}