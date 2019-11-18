package buu.informatics.s59160965.qrcodescanner.screens.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private val _eventClick = MutableLiveData<Boolean>()
    val eventClick : LiveData<Boolean>
        get() = _eventClick

    init{
        _eventClick.value = false
    }

    fun click(){
        Log.i("Test","CLICK")
        _eventClick.value = true
    }

}