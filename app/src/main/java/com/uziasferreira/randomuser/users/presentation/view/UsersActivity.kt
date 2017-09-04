package com.uziasferreira.randomuser.users.presentation.view

import android.os.Bundle
import android.widget.Toast
import com.uziasferreira.randomuser.R
import com.uziasferreira.randomuser.core.presentation.BaseActivity
import com.uziasferreira.randomuser.core.presentation.BasePresenter
import com.uziasferreira.randomuser.core.presentation.EmptyStateView
import com.uziasferreira.randomuser.users.presentation.presenter.UsersPresenter
import dagger.android.AndroidInjection
import io.reactivex.functions.Action
import javax.inject.Inject

class UsersActivity : BaseActivity(), EmptyStateView {

    @Inject
    lateinit var presenter: UsersPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        presenter.getUsers()
    }

    override fun getPresenter(): BasePresenter = presenter

    override fun injectDependencies() {
        AndroidInjection.inject(this)
    }

    override fun hideEmptyState(): Action {
        return Action {
            Toast.makeText(this, "hide", Toast.LENGTH_LONG).show() }
    }

    override fun showEmptyState(): Action {
        return Action {
            Toast.makeText(this, "show", Toast.LENGTH_LONG).show() }
    }

    override fun showErrorState(): Action {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideErrorState(): Action {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun disableRefresh(): Action {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun enableRefresh(): Action {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
