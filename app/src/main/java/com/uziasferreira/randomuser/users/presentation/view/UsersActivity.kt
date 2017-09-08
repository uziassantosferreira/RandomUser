package com.uziasferreira.randomuser.users.presentation.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.uziasferreira.randomuser.R
import com.uziasferreira.randomuser.core.presentation.BaseActivity
import com.uziasferreira.randomuser.core.presentation.BasePresenter
import com.uziasferreira.randomuser.core.presentation.EmptyStateView
import com.uziasferreira.randomuser.users.presentation.adapter.UserAdapterImpl
import com.uziasferreira.randomuser.users.presentation.adapter.UsersAdapter
import com.uziasferreira.randomuser.users.presentation.model.PresentationUser
import com.uziasferreira.randomuser.users.presentation.presenter.UsersPresenter
import dagger.android.AndroidInjection
import io.reactivex.functions.Action
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class UsersActivity : BaseActivity(), EmptyStateView {

    @Inject
    lateinit var presenter: UsersPresenter

    @Inject
    lateinit var userAdapter: UserAdapterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        recyclerview.adapter = userAdapter
        recyclerview.layoutManager = LinearLayoutManager(this)
        userAdapter.setUsers(listOf(PresentationUser(name = "TESTE"),
                PresentationUser(name = "TESTE"),
                PresentationUser(name = "TESTE"),
                PresentationUser(name = "TESTE"),
                PresentationUser(name = "TESTE"),
                PresentationUser(name = "TESTE"),
                PresentationUser(name = "TESTE"),
                PresentationUser(name = "TESTE"),
                PresentationUser(name = "TESTE"),
                PresentationUser(name = "TESTE")))
        presenter.getUsers()
    }

    override fun getPresenter(): BasePresenter = presenter

    override fun injectDependencies() {
        AndroidInjection.inject(this)
    }
}
