package hr.ferit.bibledaily


import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import hr.ferit.bibledaily.data.Gospel

class ReadingViewModel: ViewModel() {
    private val db = Firebase.firestore
    val readingsData = mutableStateListOf<Gospel>()

    init {
        fetchDatabaseData()
    }

    private fun fetchDatabaseData() {
        db.collection("readings")
            .get()
            .addOnSuccessListener { result ->
                for (data in result.documents) {
                    val reading = data.toObject(Gospel::class.java)
                    if (reading != null) {
                        reading.Id = data.id
                        readingsData.add(reading)
                    }
                }
            }
    }
}