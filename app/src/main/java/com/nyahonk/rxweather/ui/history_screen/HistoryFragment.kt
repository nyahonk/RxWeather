package com.nyahonk.rxweather.ui.history_screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nyahonk.rxweather.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment : Fragment(R.layout.fragment_history) {

    private lateinit var recyclerView: RecyclerView

    private val rvAdapter = HistoryAdapter()

    private val viewModel: HistoryScreenViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.fragment_history_recycler_view)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = rvAdapter
        }

        viewModel.liveData.observe(viewLifecycleOwner) {
            rvAdapter.submitItem(it)
        }
    }

    override fun onDestroyView() {
        recyclerView.adapter = null
        super.onDestroyView()
    }

}