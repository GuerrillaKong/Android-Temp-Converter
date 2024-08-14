package edu.umb.homework1

import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment

/**
 * A simple [Fragment] subclass.
 * Use the [CalculateFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CalculateFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.calculate, container, false)
    }
}