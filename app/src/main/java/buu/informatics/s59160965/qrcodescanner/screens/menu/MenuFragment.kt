package buu.informatics.s59160965.qrcodescanner.screens.menu


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import buu.informatics.s59160965.qrcodescanner.R
import buu.informatics.s59160965.qrcodescanner.databinding.FragmentMenuBinding
import kotlinx.android.synthetic.main.fragment_menu.*
import buu.informatics.s59160965.qrcodescanner.screens.menu.MenuFragment as MenuFragment1

/**
 * A simple [Fragment] subclass.
 */
class MenuFragment : Fragment() {
    private lateinit var binding: FragmentMenuBinding
    private lateinit var viewModel: MenuViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val args =  MenuFragmentArgs.fromBundle(arguments!!)
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentMenuBinding>(inflater,
            R.layout.fragment_menu, container, false
        )

        viewModel = ViewModelProviders.of(this).get(MenuViewModel::class.java)
        binding.menuViewModel = viewModel
        binding.lifecycleOwner = this
        viewModel.setName(args.inputName)




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
    override fun onStart() {
        super.onStart()

        Log.i("StartFragment", "OnStart called")
    }

    override fun onResume() {
        super.onResume()

        Log.i("StartFragment", "OnResume called")
    }

    override fun onPause() {
        super.onPause()

        Log.i("StartFragment", "OnPause called")
    }

    override fun onStop() {
        super.onStop()

        Log.i("StartFragment", "OnStop called")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("StartFragment", "OnDestroy called")
    }


}
