package com.junewon.sopthousparty.presentation.activity_fragment_lifecycle

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.junewon.sopthousparty.R
import com.junewon.sopthousparty.databinding.FragmentOneBinding
import timber.log.Timber

class FirstFragment : Fragment() {

    private var _binding: FragmentOneBinding? = null
    private val binding get() = _binding ?: error("binding에 null이 들어갔어요")

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Timber.tag("fragment").i("FirstFragment - onAttach - ")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.tag("fragment").i("FirstFragment - onCreate - ")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.tag("fragment").i("FirstFragment - onCreateView - View lifecycle: ${viewLifecycleOwner.lifecycle.currentState}")
        _binding = FragmentOneBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.tag("fragment").i("FirstFragment - onViewCreated - View lifecycle: ${viewLifecycleOwner.lifecycle.currentState}")
        binding.btnNavigateSecondFragment.setOnClickListener {
            navigateTo(SecondFragment())
        }
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Timber.tag("fragment").i("FirstFragment - onViewStateRestored - View lifecycle: ${viewLifecycleOwner.lifecycle.currentState}")
    }

    override fun onStart() {
        super.onStart()
        Timber.tag("fragment").i("FirstFragment - onStart - View lifecycle: ${viewLifecycleOwner.lifecycle.currentState}")
    }

    override fun onResume() {
        super.onResume()
        Timber.tag("fragment").i("FirstFragment - onResume - View lifecycle: ${viewLifecycleOwner.lifecycle.currentState}")
    }

    override fun onPause() {
        super.onPause()
        Timber.tag("fragment").i("FirstFragment - onPause - View lifecycle: ${viewLifecycleOwner.lifecycle.currentState}")
    }

    override fun onStop() {
        super.onStop()
        Timber.tag("fragment").i("FirstFragment - onStop - View lifecycle: ${viewLifecycleOwner.lifecycle.currentState}")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Timber.tag("fragment").i("FirstFragment - onSaveInstanceState - View lifecycle: ${viewLifecycleOwner.lifecycle.currentState}")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.tag("fragment").i("FirstFragment - onDestroyView - View lifecycle: ${viewLifecycleOwner.lifecycle.currentState}")
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.tag("fragment").i("FirstFragment -  onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Timber.tag("fragment").i("FirstFragment = onDetach ")
    }

    inline fun <reified F : Fragment> navigateTo(fragment: F) {
        Timber.tag("fragment").i("add() - ${fragment.javaClass.simpleName}")
        parentFragmentManager.commit {
            add<F>(R.id.fragment_container_practice)
        }
    }
}
