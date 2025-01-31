package hr.ferit.bibledaily

import android.util.Log
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
}