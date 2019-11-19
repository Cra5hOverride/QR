package buu.informatics.s59160965.qrcodescanner.screens.history


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import buu.informatics.s59160965.qrcodescanner.R
import buu.informatics.s59160965.qrcodescanner.database.HistoryDatabase
import buu.informatics.s59160965.qrcodescanner.databinding.FragmentHistoryBinding

/**
 * A simple [Fragment] subclass.
 */
class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    private lateinit var viewModel : HistoryViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate<FragmentHistoryBinding>(inflater, R.layout.fragment_history,container,false)
        val application = requireNotNull(this.activity).application
        val dataSource = HistoryDatabase.getInstance(application).HistoryDatabaseDao
        val viewModelFactory = HistoryViewModelFactory(dataSource, application)

        viewModel = ViewModelProviders.of(this,viewModelFactory).get(HistoryViewModel::class.java)
        binding.historyViewModel = viewModel
        binding.lifecycleOwner = this

        val adapter = HistoryAdapter()
        binding.historyList.adapter = adapter

        val historyViewModel = ViewModelProviders.of(this,
            viewModelFactory)
            .get(HistoryViewModel::class.java)

        historyViewModel.historys.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.data = it
            }
        })


        binding.historyViewModel = historyViewModel
        binding.lifecycleOwner = this



        return return binding.root
    }


}
