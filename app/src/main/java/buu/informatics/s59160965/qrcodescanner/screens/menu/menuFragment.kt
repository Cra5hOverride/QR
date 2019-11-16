package buu.informatics.s59160965.qrcodescanner.screens.menu


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import buu.informatics.s59160965.qrcodescanner.R
import buu.informatics.s59160965.qrcodescanner.databinding.FragmentMenuBinding

/**
 * A simple [Fragment] subclass.
 */
class menuFragment : Fragment() {
    private lateinit var binding: FragmentMenuBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentMenuBinding>(inflater,
            R.layout.fragment_menu, container, false
        )
        binding.apply {
            scanbutton.setOnClickListener {
                findNavController()
                    .navigate(R.id.action_menuFragment_to_qrcodescanFragment)
            }
            historybutton.setOnClickListener {
                findNavController()
                    .navigate(R.id.action_menuFragment_to_historyFragment)
            }
        }
        return binding.root
    }

}
