package com.example.madlevel7task1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.net.Uri
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.madlevel7task1.ViewModel.ProfileViewModel
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    private val viewModel: ProfileViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeProfile()
    }

    private fun observeProfile() {
        viewModel.getProfile()

        viewModel.profile.observe(viewLifecycleOwner, Observer {
            val profile = it

            tvName.text = getString(R.string.profile_name, profile.firstName, profile.lastName)
            tvDescription.text = profile.description
            if (profile.imageUri?.isNotEmpty()!!) {
                ivProfileImage.setImageURI(Uri.parse(profile.imageUri))
            }
        })
    }

}
