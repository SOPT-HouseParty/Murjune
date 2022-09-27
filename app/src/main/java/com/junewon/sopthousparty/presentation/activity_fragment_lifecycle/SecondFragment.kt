package com.junewon.sopthousparty.presentation.activity_fragment_lifecycle

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.junewon.sopthousparty.databinding.FragmentSecondBinding
import timber.log.Timber

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding ?: error("binding에 null이 들어갔어요")

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Timber.tag("fragment").i("SecondFragment - onAttach - fragment lifecycle: ${lifecycle.currentState}")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.tag("fragment").i("SecondFragment - onCreate - fragment lifecycle: ${lifecycle.currentState}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.tag("fragment")
            .i("SecondFragment - onCreateView - fragment lifecycle: ${lifecycle.currentState}, View lifecycle: ${viewLifecycleOwner.lifecycle.currentState}")
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.tag("fragment")
            .i("SecondFragment - onCreate - fragment lifecycle: ${lifecycle.currentState}, fragment lifecycle: ${lifecycle.currentState}, viewLifecycleOwner : ${viewLifecycleOwner.lifecycle.currentState}")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Timber.tag("fragment")
            .i("SecondFragment - onViewStateRestored - fragment lifecycle: ${lifecycle.currentState}, View lifecycle: ${viewLifecycleOwner.lifecycle.currentState}")
    }

    override fun onStart() {
        super.onStart()
        Timber.tag("fragment")
            .i("SecondFragment - onStart - fragment lifecycle: ${lifecycle.currentState}, View lifecycle: ${viewLifecycleOwner.lifecycle.currentState}")
    }

    override fun onResume() {
        super.onResume()
        Timber.tag("fragment")
            .i("SecondFragment - onResume - fragment lifecycle: ${lifecycle.currentState}, View lifecycle: ${viewLifecycleOwner.lifecycle.currentState}")
    }

    override fun onPause() {
        super.onPause()
        Timber.tag("fragment")
            .i("SecondFragment - onPause - fragment lifecycle: ${lifecycle.currentState}, View lifecycle: ${viewLifecycleOwner.lifecycle.currentState}")
    }

    override fun onStop() {
        super.onStop()
        Timber.tag("fragment")
            .i("SecondFragment - onStop - fragment lifecycle: ${lifecycle.currentState}, View lifecycle: ${viewLifecycleOwner.lifecycle.currentState}")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Timber.tag("fragment")
            .i("SecondFragment - onSaveInstanceState - fragment lifecycle: ${lifecycle.currentState}, View lifecycle: ${viewLifecycleOwner.lifecycle.currentState}")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.tag("fragment")
            .i("SecondFragment - onDestroyView - fragment lifecycle: ${lifecycle.currentState}, View lifecycle: ${viewLifecycleOwner.lifecycle.currentState}")
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.tag("fragment").i("SecondFragment - onDestroy - fragment lifecycle: ${lifecycle.currentState}")
    }

    override fun onDetach() {
        super.onDetach()
        Timber.tag("fragment").i("SecondFragment - onDetach - fragment lifecycle: ${lifecycle.currentState}")
    }
    // defaultLifecycleobserver
}
