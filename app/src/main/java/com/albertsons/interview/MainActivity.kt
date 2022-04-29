package com.albertsons.interview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.albertsons.interview.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val mainActivityViewModel: MainActivityViewModel by viewModels()
    private lateinit var acronymListAdapter: AcronymMeaningAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.acronymList.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))
        binding.search.setOnClickListener {
            val acronym = binding.acronymInput.text.toString()
            if (acronym.isEmpty()) return@setOnClickListener
            if (!Utils.isInternetConnected(applicationContext)) return@setOnClickListener
            mainActivityViewModel.getAcronymResponse(acronym).observe(this@MainActivity,
                Observer { acronymResponse ->
                    if (acronymResponse == null) {
                        return@Observer
                    }
                    if (acronymResponse.isEmpty()) {
                        return@Observer
                    }
                    acronymListAdapter = AcronymMeaningAdapter(acronymResponse[0].longForms)
                    binding.acronymList.adapter = acronymListAdapter
                })
        }
    }
}