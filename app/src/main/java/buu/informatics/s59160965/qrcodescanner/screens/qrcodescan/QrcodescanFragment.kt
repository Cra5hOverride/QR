package buu.informatics.s59160965.qrcodescanner.screens.qrcodescan


import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context.CLIPBOARD_SERVICE
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import buu.informatics.s59160965.qrcodescanner.R
import buu.informatics.s59160965.qrcodescanner.databinding.FragmentQrcodescanBinding
import com.google.zxing.integration.android.IntentIntegrator
import java.util.regex.Pattern


/**
 * A simple [Fragment] subclass.
 */
class QrcodescanFragment : Fragment() {

    private lateinit var binding: FragmentQrcodescanBinding
    private lateinit var viewModel: QrcodescanViewModel
            override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentQrcodescanBinding>(inflater, R.layout.fragment_qrcodescan,container,false)

                viewModel = ViewModelProviders.of(this).get(QrcodescanViewModel::class.java)
                binding.qrcodescanViewModel = viewModel
                binding.lifecycleOwner = this

            binding.scanbutton.setOnClickListener{
                val scanner = IntentIntegrator(activity)
                scanner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
                scanner.setBeepEnabled(false)
                scanner.initiateScan()
            }



        return binding.root
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Log.i("Fragment", "Test Result")
        if (resultCode == Activity.RESULT_OK) {
            val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
            if (result != null) {
                if (result.contents == null) {
                    Toast.makeText(context, "Cancelled", Toast.LENGTH_LONG).show()
                } else {
                    var content = result.contents
//                    Toast.makeText(context, "Scanned: " + content, Toast.LENGTH_LONG).show()
                    copy2clipboard(content)
                    Log.i("Link", "Scanned: " + content)

                }
            } else {
                super.onActivityResult(requestCode, resultCode, data)
            }
        }

    }
    fun copy2clipboard(text: CharSequence){

        val URL_REGEX = "^((https?|ftp)://|(www|ftp)\\.)?[a-z0-9-]+(\\.[a-z0-9-]+)+([/?].*)?$"
        val p = Pattern.compile(URL_REGEX)
        val m = p.matcher(text)
        if(m.find()){
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse(text as String?)
            startActivity(openURL)
        }else{
            val clipboard = activity?.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("copy text", text)
            clipboard.setPrimaryClip(clip)

            Toast.makeText(context, "Text Copied", Toast.LENGTH_SHORT).show()
        }


    }

}
