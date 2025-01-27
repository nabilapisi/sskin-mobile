package com.example.skindiseasedetectionapp.ui.dashboard

import androidx.lifecycle.*
import com.example.skindiseasedetectionapp.model.InUserModel
import com.example.skindiseasedetectionapp.setting.SettingDatastore
import com.example.skindiseasedetectionapp.utill.Event
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch

class DashboardViewModel(private val settingDatastore: SettingDatastore) : ViewModel() {

    private val _loading: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _inUserModel: MutableLiveData<InUserModel?> = MutableLiveData<InUserModel?>()
    val inUserModel: LiveData<InUserModel?> = _inUserModel

    private val _messageLogin: MutableLiveData<Event<String>> = MutableLiveData<Event<String>>()
    val messageLogin: LiveData<Event<String>> = _messageLogin

    private val _messageAddFirebaseUser: MutableLiveData<Event<String>> = MutableLiveData<Event<String>>()
    val messageAddFirebaseUser: LiveData<Event<String>> = _messageAddFirebaseUser

    private val _currentUser: MutableLiveData<FirebaseUser> = MutableLiveData<FirebaseUser>()
    val currentUser: LiveData<FirebaseUser> = _currentUser


    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
    private var db : FirebaseFirestore = FirebaseFirestore.getInstance()


    fun getDatastore() : LiveData<String>{
        return settingDatastore.readFromDataStore.asLiveData()
    }

    fun getDatastoreUser() : LiveData<InUserModel>{
        return settingDatastore.readUserFromDataStore.asLiveData()
    }



    fun clearDatastore(){
        viewModelScope.launch {
            settingDatastore.deleteData()
        }
    }
}