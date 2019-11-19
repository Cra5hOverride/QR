package buu.informatics.s59160965.qrcodescanner.screens.menu

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MenuViewModel: ViewModel() {

   private val _eventInit = MutableLiveData<Boolean>()
    val eventInit : LiveData<Boolean>
        get() = _eventInit

    private val _name = MutableLiveData<String>()
    val name : LiveData<String>
        get() = _name

  init {
      _name.value = ""
      _eventInit.value = true

  }

    fun setName(name : String){
        _name.value = "Hello : "+name
    }

}