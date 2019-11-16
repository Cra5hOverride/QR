package buu.informatics.s59160965.qrcodescanner.screens.qrcodescan


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import buu.informatics.s59160965.qrcodescanner.R

/**
 * A simple [Fragment] subclass.
 */
class qrcodescanFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_qrcodescan, container, false)
    }


}
