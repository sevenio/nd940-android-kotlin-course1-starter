package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.databinding.FragmentShoeListingBinding
import com.udacity.shoestore.models.Shoe


/**
 * A simple [Fragment] subclass.
 * Use the [ShoeDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeDetailFragment : Fragment() {

    private val viewmodel by activityViewModels<MainViewmodel>()


    private lateinit var binding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonCancel.setOnClickListener {
            view.findNavController().navigateUp()
        }
        binding.buttonSave.setOnClickListener {
            viewmodel.addShoe(Shoe(name = binding.etShoeName.text.toString(), company = binding.etCompany.text.toString(), size = binding.etShoeSize.text.toString().toDoubleOrNull()?:0.0, description = binding.etDescription.text.toString()))
            view.findNavController().navigateUp()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ShoeDetailFragment.
         */
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ShoeDetailFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}