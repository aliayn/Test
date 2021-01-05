package com.aliayn.test.base

import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class BaseFragment(contentLayoutId: Int) : Fragment(contentLayoutId)