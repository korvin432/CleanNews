package com.mindyapps.cleannews.ui

import android.os.Bundle
import com.mindyapps.cleannews.R
import com.mindyapps.cleannews.base.BaseActivity
import com.mindyapps.cleannews.databinding.ActivitySingleBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SingleActivity : BaseActivity() {

    override fun getNavControllerResId(): Int = R.id.nav_host_fragment

    private lateinit var binding: ActivitySingleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingleBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}