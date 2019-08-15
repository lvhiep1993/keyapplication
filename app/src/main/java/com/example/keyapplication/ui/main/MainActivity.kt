package com.example.keyapplication.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.keyapplication.R
import com.example.keyapplication.ui.adapter.KeywordAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var mAdapter: KeywordAdapter? = null

    private lateinit var mViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAdapter = KeywordAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = mAdapter

        mViewModel = ViewModelProviders.of(this)[MainViewModel::class.java]
        mViewModel.getUIState().observe(this, Observer<MainViewModel.UIModelWrapper> { modelWrapper ->
            modelWrapper?.showKeywords?.let { showKeywords(it) }
            modelWrapper?.showServerError?.let { onError(it) }
        })
        mViewModel.loadKeyword()
    }

    private fun showKeywords(keyword: List<String>) {
        mAdapter?.setData(keyword)
    }

    private fun onError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }
}
