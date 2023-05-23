package com.tripbook.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import android.content.Context.INPUT_METHOD_SERVICE

abstract class BaseFragment<B: ViewDataBinding>(
    @LayoutRes private val layoutResId: Int
): Fragment() {

    private var _binding: B? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, layoutResId, container, false)

        binding.root.setOnClickListener{
            hideKeyboard()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        init()
    }

    protected abstract fun init()

    private fun hideKeyboard(){
        if(activity != null && requireActivity().currentFocus != null){
            val inputManager = requireActivity().getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(requireActivity().currentFocus?.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }
    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}