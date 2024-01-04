package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentInstructionsBinding
import com.udacity.shoestore.databinding.FragmentWelcomeBinding


/**
 * A simple [Fragment] subclass.
 * Use the [InstructionsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InstructionsFragment : Fragment() {

    private lateinit var binding: FragmentInstructionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding = DataBindingUtil.inflate(inflater, R.layout.fragment_instructions, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonShoeList.setOnClickListener {
            view.findNavController().navigate(InstructionsFragmentDirections.actionInstructionsFragmentToShoeListingFragment())
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment InstructionsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            InstructionsFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}