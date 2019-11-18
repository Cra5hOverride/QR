package buu.informatics.s59160965.qrcodescanner.screens.qrcodescan

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QrcodescanViewModel : ViewModel() {
    private val _datadecode = MutableLiveData<Int>()
    val datadecode: LiveData<Int>
        get() = _datadecode
}