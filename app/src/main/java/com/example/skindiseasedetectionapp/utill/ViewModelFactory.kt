package com.example.skindiseasedetectionapp.utill

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.skindiseasedetectionapp.setting.SettingDatastore
import com.example.skindiseasedetectionapp.ui.auth.login.LoginViewModel
import com.example.skindiseasedetectionapp.ui.dashboard.DashboardViewModel
import com.example.skindiseasedetectionapp.ui.home.ImagePreviewGalleryViewModel
import com.example.skindiseasedetectionapp.ui.home.ScanResultViewModel

class ViewModelFactory(private val setting: SettingDatastore) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                LoginViewModel(setting) as T
            }
            modelClass.isAssignableFrom(DashboardViewModel::class.java) -> {
                DashboardViewModel(setting) as T
            }
            modelClass.isAssignableFrom(ScanResultViewModel::class.java) -> {
                ScanResultViewModel(setting) as T
            }
            modelClass.isAssignableFrom(ImagePreviewGalleryViewModel::class.java) -> {
                ImagePreviewGalleryViewModel(setting) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }

}