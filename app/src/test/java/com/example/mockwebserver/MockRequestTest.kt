package com.example.mockwebserver

import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.simplemenuexample.models.api.ApiHelperImpl
import com.example.simplemenuexample.models.api.RetrofitBuilder
import com.example.simplemenuexample.models.data.TestUserData
import com.example.simplemenuexample.utils.Constants.TAG
import com.example.simplemenuexample.utils.ResultResponse
import com.example.simplemenuexample.viewmodels.TestViewModel
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.json.JSONObject
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import java.net.HttpURLConnection

@RunWith(MockitoJUnitRunner::class)
class MockRequestTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    private lateinit var viewModel: TestViewModel
    private lateinit var apiHelper: ApiHelperImpl
    private lateinit var server: MockWebServer

    @Mock
    private lateinit var apiObserver: Observer<ResultResponse<TestUserData>?>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = TestViewModel()
        viewModel.getTestUsers().observeForever(apiObserver)

        server = MockWebServer()
        server.start(8080)
        apiHelper = ApiHelperImpl(RetrofitBuilder.apiInterface)
    }

    @Test
    fun `read success json file`(){
        val reader = MockParseJson("response_success.json")
        assertNotNull(reader)
    }

    @Test
    fun `read failed json file`(){
        val reader = MockParseJson("response_failed.json")
        assertNotNull(reader)
    }

    @Test
    fun `fetch users and check response code 200 return`() {
        // Assign
        val response = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(MockParseJson("response_success.json").content)
        server.enqueue(response)
        // Act
        val actualResponse = apiHelper.getTestUsers().execute()
        // Assert
        assertEquals(response.toString().contains("200"),actualResponse.code().toString().contains("200"))
    }

    @Test
    fun `fetch users and check response success returned`(){
        // Assign
        val response = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(MockParseJson("response_success.json").content)
        server.enqueue(response)
        val mockResponse = response.getBody()?.readUtf8()
        // Act
        val actualResponse = apiHelper.getTestUsers().execute()
        // Assert
        assertEquals(response.toString().contains("200"), actualResponse.toString().contains("200"))
    }

    @Test
    fun `fetch users for failed response 400 returned`(){
        // Assign
        val response = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_BAD_REQUEST)
            .setBody(MockParseJson("response_failed.json").content)
        server.enqueue(response)
        // Act
        val actualResponse = apiHelper.getTestUsers().execute()
        // Assert
        assertEquals(response.toString().contains("400"),actualResponse.toString().contains("400"))
    }

    @After
    fun tearDown() {
        viewModel.getTestUsers().removeObserver(apiObserver)
        server.shutdown()
    }

}