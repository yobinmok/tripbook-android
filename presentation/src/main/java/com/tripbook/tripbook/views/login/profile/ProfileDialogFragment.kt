package com.tripbook.tripbook.views.login.profile

import android.content.ContentValues
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia
import androidx.fragment.app.DialogFragment
import com.tripbook.tripbook.databinding.FragmentProfileBinding
import com.tripbook.tripbook.databinding.FragmentProfileDialogBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ProfileDialogFragment(profileBinding: FragmentProfileBinding): DialogFragment() {

    private var _binding: FragmentProfileDialogBinding? = null
    private val binding get() = _binding!!

    private lateinit var photoUri: Uri
    private val galleryLauncher = registerForActivityResult(PickVisualMedia()){ uri ->
        if(uri != null){
            Log.d("Photo Picker", uri.toString())
            profileBinding.profile.setImageURI(uri)
        }else{
            Log.d("Photo Picker", "No Media selected")
        }
        dismiss()
    }

    private val cameraLauncher = registerForActivityResult(ActivityResultContracts.TakePicture()){ isSuccess ->
        if(isSuccess)
            profileBinding.profile.setImageURI(photoUri)
        else
            Log.d("cameraLauncher", "Failed")
        dismiss()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileDialogBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.album.setOnClickListener{
            galleryLauncher.launch(PickVisualMediaRequest(PickVisualMedia.ImageOnly))
        }
        binding.camera.setOnClickListener{
            createImgFile().let { uri ->
                photoUri = uri!!
                cameraLauncher.launch(uri)
            }
        }
        binding.basicImage.setOnClickListener{
            Log.d("ProfileDialogFragment", "basic")
            dismiss()
        }
    }

    private fun createImgFile(): Uri?{
        val now = SimpleDateFormat("yyMMdd-HHmmss", Locale.getDefault()).format(Date())
        val content = ContentValues().apply {
            put(MediaStore.Images.Media.DISPLAY_NAME,"IMG_$now.jpg")
            put(MediaStore.Images.Media.MIME_TYPE, "image/jpg")
        }
        return requireContext().contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, content)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}