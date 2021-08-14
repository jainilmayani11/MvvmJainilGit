package com.example.mvvmjainil

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmjainil.adapter.MainAdapter
import com.example.mvvmjainil.api.RetrofitService
import com.example.mvvmjainil.base.BaseActivity
import com.example.mvvmjainil.databinding.ActivityMainBinding
import com.example.mvvmjainil.fragment.DataFragment
import com.example.mvvmjainil.repository.MainRepository
import com.example.mvvmjainil.viewModel.MainViewModel
import com.example.mvvmjainil.viewModel.MyViewModelFactory



class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragment(DataFragment.newInstance())
    }

    }
