package com.udacity.shoestore

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class MainViewmodel: ViewModel() {

    val shoeListLiveData: MutableLiveData<ArrayList<Shoe>?> = MutableLiveData(arrayListOf())
    val name : MutableLiveData<String> = MutableLiveData()
    val size  : MutableLiveData<String> = MutableLiveData()
    val company : MutableLiveData<String> = MutableLiveData()
    val description : MutableLiveData<String> = MutableLiveData()


    fun addShoe(){
        val shoe = Shoe(name = name.value?:"", company = company.value?:"", size = size.value?.toDoubleOrNull()?:0.0, description = description.value?:"")
        val arrayList = shoeListLiveData.value
        arrayList?.add(shoe)
        shoeListLiveData.postValue(arrayList)

    }

}