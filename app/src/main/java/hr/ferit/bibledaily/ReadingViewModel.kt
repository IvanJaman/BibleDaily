package hr.ferit.bibledaily

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import hr.ferit.bibledaily.data.Reading

class ReadingViewModel: ViewModel() {
    private val db = Firebase.firestore
    val readingsData = mutableStateListOf<Reading>()

    init {
        fetchDatabaseData()
    }

    private fun fetchDatabaseData() {
        db.collection("readings")
            .get()
            .addOnSuccessListener { result ->
                for (data in result.documents) {
                    val reading = data.toObject(Reading::class.java)
                    if (reading != null) {
                        reading.id = data.id
                        readingsData.add(reading)
                    }
                }
            }
    }

    fun updateReading(reading: Reading) {
        db.collection("readings")
            .document(reading.id)
            .set(reading)
    }

    fun fetchFavouritedReadings() {
        db.collection("readings")
            .whereEqualTo("isFavourited", true)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    readingsData.clear()
                    task.result?.documents?.forEach { document ->
                        val reading = document.toObject(Reading::class.java)
                        if (reading != null) {
                            reading.id = document.id
                            readingsData.add(reading)
                        }
                    }
                }
            }
    }
}