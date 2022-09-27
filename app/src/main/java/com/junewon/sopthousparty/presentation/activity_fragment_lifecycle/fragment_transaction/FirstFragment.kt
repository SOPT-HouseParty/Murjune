package com.junewon.sopthousparty.presentation.activity_fragment_lifecycle.fragment_transaction

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.junewon.sopthousparty.R
import com.junewon.sopthousparty.databinding.FragmentOneBinding
import timber.log.Timber

class FirstFragment : Fragment() {

    private var _binding: FragmentOneBinding? = null
    private val binding get() = _binding ?: error("binding에 null이 들어갔어요")

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Timber.tag("fragment")
            .i("FirstFragment - onAttach - fragment lifecycle: ${lifecycle.currentState}")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.tag("fragment")
            .i("FirstFragment - onCreate - fragment lifecycle: ${lifecycle.currentState}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.tag("fragment")
            .i("FirstFragment - onCreateView - fragment lifecycle: ${lifecycle.currentState}, View lifecycle: ${viewLifecycleOwner.lifecycle.currentState}")
        _binding = FragmentOneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.tag("fragment")
            .i("FirstFragment - onViewCreated - fragment lifecycle: ${lifecycle.currentState}, View lifecycle: ${viewLifecycleOwner.lifecycle.currentState}")
        binding.btnNavigateSecondFragment.setOnClickListener {
            navigateTo(SecondFragment())
        }
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Timber.tag("fragment")
            .i("FirstFragment - onViewStateRestored - fragment lifecycle: ${lifecycle.currentState}, View lifecycle: ${viewLifecycleOwner.lifecycle.currentState}")
    }

    override fun onStart() {
        super.onStart()
        Timber.tag("fragment")
            .i("FirstFragment - onStart - fragment lifecycle: ${lifecycle.currentState}, View lifecycle: ${viewLifecycleOwner.lifecycle.currentState}")
    }

    override fun onResume() {
        super.onResume()
        Timber.tag("fragment")
            .i("FirstFragment - onResume - fragment lifecycle: ${lifecycle.currentState}, View lifecycle: ${viewLifecycleOwner.lifecycle.currentState}")
    }

    override fun onPause() {
        super.onPause()
        Timber.tag("fragment")
            .i("FirstFragment - onPause - fragment lifecycle: ${lifecycle.currentState}, View lifecycle: ${viewLifecycleOwner.lifecycle.currentState}")
    }

    override fun onStop() {
        super.onStop()
        Timber.tag("fragment")
            .i("FirstFragment - onStop - fragment lifecycle: ${lifecycle.currentState}, View lifecycle: ${viewLifecycleOwner.lifecycle.currentState}")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Timber.tag("fragment")
            .i("FirstFragment - onSaveInstanceState - fragment lifecycle: ${lifecycle.currentState}, View lifecycle: ${viewLifecycleOwner.lifecycle.currentState}")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.tag("fragment")
            .i("FirstFragment - onDestroyView - fragment lifecycle: ${lifecycle.currentState}, View lifecycle: ${viewLifecycleOwner.lifecycle.currentState}")
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.tag("fragment")
            .i("FirstFragment -  onDestroy - fragment lifecycle: ${lifecycle.currentState}")
    }

    override fun onDetach() {
        super.onDetach()
        Timber.tag("fragment")
            .i("FirstFragment - onDetach - fragment lifecycle: ${lifecycle.currentState}")
    }

    inline fun <reified F : Fragment> navigateTo(fragment: F) {
        Timber.tag("fragment").i("replace() - ${fragment.javaClass.simpleName}")
        parentFragmentManager.commit {
            addToBackStack(this.javaClass.name)
            replace<F>(R.id.fragment_container_practice)
        }
    }
}
