package com.nyahonk.rxweather.ui.search_screen

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.nyahonk.rxweather.R
import com.nyahonk.rxweather.ui.main_screen.MainScreenViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment: Fragment(R.layout.fragment_search) {

    private lateinit var editText: EditText
    private lateinit var searchButton: Button

    private val viewModel: MainScreenViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(view) {
            editText = findViewById(R.id.fragment_search_edit_text)
            searchButton = findViewById(R.id.fragment_search_button)
        }

        editText.setText(viewModel.cityName)

        searchButton.setOnClickListener {
            viewModel.cityName = editText.text.toString()
            viewModel.requestData()
            findNavController().navigate(R.id.action_SearchFragment_to_MainFragment)
        }
    }
}