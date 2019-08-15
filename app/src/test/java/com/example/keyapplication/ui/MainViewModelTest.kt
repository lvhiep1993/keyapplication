//package com.example.keyapplication.ui
//
//import com.example.keyapplication.LiveDataTestUtils
//import com.example.keyapplication.data.KeywordRepository
//import com.example.keyapplication.data.model.Failure
//import com.example.keyapplication.data.model.Success
//import com.example.keyapplication.ui.main.MainViewModel
//import com.nhaarman.mockitokotlin2.doAnswer
//import kotlinx.coroutines.runBlocking
//import org.junit.Before
//import org.junit.Test
//import org.junit.runner.RunWith
//import org.mockito.Mock
//import org.mockito.Mockito
//import org.powermock.api.mockito.PowerMockito
//import org.powermock.core.classloader.annotations.PrepareForTest
//import org.powermock.modules.junit4.PowerMockRunner
//
//@RunWith(PowerMockRunner::class)
//@PrepareForTest(KeywordRepository::class)
//class MainViewModelTest {
//
//    @Mock
//    private lateinit var mKeywordRepository: KeywordRepository
//
//    private lateinit var mMainViewModel: MainViewModel
//
//    @Before
//    fun setup() {
//        mMainViewModel = MainViewModel()
//        PowerMockito.mockStatic(KeywordRepository::class.java)
//        PowerMockito.`when`(KeywordRepository.instance).doAnswer { mKeywordRepository }
//    }
//
//    @Test
//    fun loadKeywordSuccessTest() {
//        runBlocking {
//            val keywords = listOf("", "x", "", "bitis x hunter")
//            val successResponse = Success(keywords)
//            PowerMockito.`when`(mKeywordRepository.loadKeywords()).doAnswer { successResponse }
//            mMainViewModel.loadKeyword()
//            Mockito.verify(mKeywordRepository).loadKeywords()
//            val successState = MainViewModel.UIModelWrapper(
//                showKeywords = keywords,
//                showServerError = null
//            )
//            val uiState = LiveDataTestUtils.getValue(mMainViewModel.getUIState())
//            assert(uiState == successState)
//        }
//    }
//
//    @Test
//    fun loadKeywordFailTest() {
//        runBlocking {
//            val error = "network not available"
//            val failureResponse = Failure<List<String>>(error)
//            PowerMockito.`when`(mKeywordRepository.loadKeywords()).doAnswer { failureResponse }
//            mMainViewModel.loadKeyword()
//            Mockito.verify(mKeywordRepository).loadKeywords()
//            val errorState = MainViewModel.UIModelWrapper(
//                showKeywords = null,
//                showServerError = error
//            )
//            val uiState = LiveDataTestUtils.getValue(mMainViewModel.getUIState())
//            assert(uiState == errorState)
//        }
//    }
//}
