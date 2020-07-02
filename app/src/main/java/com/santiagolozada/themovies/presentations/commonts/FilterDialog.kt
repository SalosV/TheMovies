package com.santiagolozada.themovies.presentations.commonts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.santiagolozada.themovies.R
import com.santiagolozada.themovies.databinding.FilterDialogBinding

class FilterDialog : DialogFragment() {

    private lateinit var searchListener: SelectItemListener
    private lateinit var binding: FilterDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        searchListener = parentFragment as SelectItemListener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = run {

        binding = DataBindingUtil.inflate(
            LayoutInflater.from(inflater.context),
            R.layout.filter_dialog,
            container,
            false
        )

        onClicks()

        binding.root
    }

    private fun onClicks() {
        binding.bnClose.setOnClickListener {
            dismiss()
        }

        binding.filterRadioGroup.setOnCheckedChangeListener { group, checkedId ->

            when (checkedId) {
                R.id.populary_radio -> {
                    searchListener.selectItem(getString(R.string.populary))
                }
                R.id.rated_radio -> {
                    searchListener.selectItem(getString(R.string.top_rated))
                }
            }
            dismiss()
        }
    }

    interface SelectItemListener {
        fun selectItem(item: String)
    }
}