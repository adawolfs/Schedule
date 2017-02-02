package com.adawolfs.schedule.mvp

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.StringRes
import org.jetbrains.anko.toast

abstract class BaseActivity : AppCompatActivity(), BaseView {


    override fun getContext(): Context {
        return this;
    }

    override fun showError(error: String) {
        toast(error)
    }

    override fun showError(@StringRes error: Int) {
        toast(getString(error))
    }

    override fun showMessage(message: String) {
        toast(message)
    }

    override fun showMessage(@StringRes message: Int) {
        toast(getString(message))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun isActive(): Boolean {
        return true
    }
}
