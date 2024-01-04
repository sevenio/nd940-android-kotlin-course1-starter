package com.udacity.shoestore

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class MainViewmodel: ViewModel() {

    val shoeListLiveData: MutableLiveData<ArrayList<Shoe>?> = MutableLiveData(arrayListOf())


    fun addShoe(shoe: Shoe){
        val arrayList = shoeListLiveData.value
        arrayList?.add(shoe)
        Log.d("gan", "$arrayList")
        shoeListLiveData.postValue(arrayList)
    }

}