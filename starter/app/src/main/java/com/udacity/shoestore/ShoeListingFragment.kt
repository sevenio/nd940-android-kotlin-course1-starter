package com.udacity.shoestore

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoeListingBinding
import kotlin.time.Duration.Companion.nanoseconds


/**
 * A simple [Fragment] subclass.
 * Use the [ShoeListingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeListingFragment : Fragment() {

    private val viewmodel by activityViewModels<MainViewmodel>()

    private lateinit var binding: FragmentShoeListingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_listing, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    var navController: NavController? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fab.setOnClickListener {
            view.findNavController()
                .navigate(ShoeListingFragmentDirections.actionShoeListingFragmentToShoeDetailFragment())
        }
        navController = view.findNavController()

        viewmodel.shoeListLiveData.observe(viewLifecycleOwner) {
            it?.forEachIndexed { index, item ->
                Log.d("ganga", "$index, $item")
                val textView = TextView(requireContext())
                textView.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                textView.text = item.name
                binding.llContainer.addView(textView, index)
            }

        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.loginFragment) {
            navController?.popBackStack()

            navController?.navigate(
                R.id.loginFragment,
                null,
                NavOptions.Builder()
                    .setPopUpTo(
                        R.id.loginFragment,
                        true
                    ).build()
            )
        }
        return true

    }


}