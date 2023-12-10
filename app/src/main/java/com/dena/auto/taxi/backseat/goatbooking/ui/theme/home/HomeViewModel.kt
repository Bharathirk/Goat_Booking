package com.dena.auto.taxi.backseat.goatbooking.ui.theme.home

import androidx.lifecycle.ViewModel
import com.dena.auto.taxi.backseat.goatbooking.data.homeScreen.HomeScreenRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private var homeScreenRepository: HomeScreenRepository
) : ViewModel(){

}