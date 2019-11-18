package buu.informatics.s59160965.qrcodescanner.screens.history

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import buu.informatics.s59160965.qrcodescanner.database.HistoryDatabaseDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class HistoryViewModel (val database: HistoryDatabaseDao, application: Application) : AndroidViewModel(application) {
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    val historys = database.getHistory()
    init {
        Log.i("history",historys.toString())
    }
}