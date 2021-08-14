package com.example.mvvmjainil.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmjainil.adapter.MainAdapter
import com.example.mvvmjainil.api.RetrofitService
import com.example.mvvmjainil.base.BaseFragment
import com.example.mvvmjainil.databinding.FragmentDataBinding
import com.example.mvvmjainil.repository.MainRepository
import com.example.mvvmjainil.viewModel.MainViewModel
import com.example.mvvmjainil.viewModel.MyViewModelFactory

class DataFragment : BaseFragment() {

    lateinit var viewModel: MainViewModel

    private val retrofitService = RetrofitService.getInstance()
    val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = FragmentDataBinding.inflate(inflater, container, false)
        val view = binding.root

        viewModel = ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService))).get(MainViewModel::class.java)

        binding.recyclerview.adapter = adapter

        getCurrentActivity()?.let {
            viewModel.movieList.observe(it, Observer {
                adapter.setMovieList(it)
            })
        }

        getCurrentActivity()?.let {
            viewModel.errorMessage.observe(it, Observer {

            })
        }
        viewModel.getAllMovies()


        return view
    }

    companion object {
        fun newInstance() = DataFragment()
    }
    }
