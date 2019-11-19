package buu.informatics.s59160965.qrcodescanner.screens.history

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import buu.informatics.s59160965.qrcodescanner.database.History
import buu.informatics.s59160965.qrcodescanner.database.HistoryDatabaseDao
import kotlinx.coroutines.*

class HistoryViewModel (val database: HistoryDatabaseDao, application: Application) : AndroidViewModel(application) {
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private var Hist = MutableLiveData<History?>()
    val historys = database.getHistory()
    init {
        Log.i("history",historys.toString())

    }


    fun clearDatabase(){
        uiScope.launch {
            clear()
        }
    }
    private suspend fun clear() {
        withContext(Dispatchers.IO) {
            database.clear()
        }
    }
}