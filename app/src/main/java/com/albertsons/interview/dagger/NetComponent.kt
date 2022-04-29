package com.albertsons.interview.dagger

import com.albertsons.interview.MainActivityViewModel
import com.albertsons.interview.repository.ApiRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface NetComponent {
    fun inject(apiRepository: ApiRepository)
    fun inject(homeScreenViewModel: MainActivityViewModel)
}