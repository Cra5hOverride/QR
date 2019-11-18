package buu.informatics.s59160965.qrcodescanner.screens.qrcodescan

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import buu.informatics.s59160965.qrcodescanner.database.HistoryDatabaseDao


class QrcodescanViewModelFactory(
    private val dataSource: HistoryDatabaseDao,
    private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(QrcodescanViewModel::class.java)) {
            return QrcodescanViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}