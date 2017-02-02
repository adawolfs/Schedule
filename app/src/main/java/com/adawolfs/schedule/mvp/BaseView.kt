package com.adawolfs.schedule.mvp

import android.content.Context
import android.support.annotation.StringRes

/**
 * Created by adawolfs on 1/26/17.
 */
interface BaseView {

    fun getContext(): Context

    fun showError(error: String)

    fun showError(@StringRes error: Int)

    fun showMessage(message: String)

    fun showMessage(@StringRes srtResId: Int)

    fun isActive(): Boolean
}