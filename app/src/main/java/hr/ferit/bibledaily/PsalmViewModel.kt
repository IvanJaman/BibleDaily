package hr.ferit.bibledaily

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import hr.ferit.bibledaily.data.Psalm

class PsalmViewModel: ViewModel() {
    private val db = Firebase.firestore
    val psalmsData = mutableStateListOf<Psalm>()

    init {
        fetchDatabaseData()
    }

    private fun fetchDatabaseData() {
        db.collection("psalms")
            .get()
            .addOnSuccessListener { result ->
                for (data in result.documents) {
                    val psalm = data.toObject(Psalm::class.java)
                    if (psalm != null) {
                        psalm.Id = data.id
                        psalmsData.add(psalm)
                    }
                }
            }
    }
}