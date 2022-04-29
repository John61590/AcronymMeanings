package com.albertsons.interview

import androidx.lifecycle.MutableLiveData
import com.albertsons.interview.network.model.Abbreviation
import com.albertsons.interview.repository.ApiRepository
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual
import org.junit.Test

import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(MockitoJUnitRunner::class)
class MainActivityViewModelTest {

    private lateinit var activityViewModel: MainActivityViewModel
    private val apiRepository = mock(ApiRepository::class.java)

    @Before
    fun setUp() {
        activityViewModel = MainActivityViewModel(apiRepository)
    }

    @Test
    fun `Given a mutablelivedata response from the API, when the viewmodel is called, then the same livedata is returned`() {
        //Given
        val liveData = mock<MutableLiveData<List<Abbreviation>>>()
        whenever(apiRepository.getAcronymResponse(anyString())) doReturn liveData

        //When
        val result = activityViewModel.getAcronymResponse("HHH")

        //Then
        assertThat(result, IsEqual(liveData))
    }
}