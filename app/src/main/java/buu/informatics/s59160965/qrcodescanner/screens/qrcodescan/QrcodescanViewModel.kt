package buu.informatics.s59160965.qrcodescanner.screens.qrcodescan

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import buu.informatics.s59160965.qrcodescanner.database.History
import buu.informatics.s59160965.qrcodescanner.database.HistoryDatabaseDao
import kotlinx.coroutines.*
import java.time.LocalDateTime

class QrcodescanViewModel ( val database: HistoryDatabaseDao, application: Application) : AndroidViewModel(application) {
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _datadecode = MutableLiveData<Int>()
    val datadecode: LiveData<Int>
        get() = _datadecode


    @RequiresApi(Build.VERSION_CODES.O)
    fun insertHistory(data: String) {
        uiScope.launch {
            val newHistory = History()
            newHistory.datadecode = data
            newHistory.time = LocalDateTime.now().toString()
            insert(newHistory)
        }
    }


    private suspend fun insert(history: History) {
        withContext(Dispatchers.IO) {
            database.insert(history)
        }
    }
}