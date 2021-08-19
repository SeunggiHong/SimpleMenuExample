package com.example.mockwebserver

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import com.example.simplemenuexample.utils.App
import com.example.simplemenuexample.viewmodels.MainViewModel
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MockRequestTest {
    private val server: MockWebServer = MockWebServer()
    private val MOCK_WEBSERVER_PORT = 8000

    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        viewModel = MainViewModel(App.instance)

        server.start(MOCK_WEBSERVER_PORT)
    }

    @After
    fun tearDown() {
        server.shutdown()
    }

}