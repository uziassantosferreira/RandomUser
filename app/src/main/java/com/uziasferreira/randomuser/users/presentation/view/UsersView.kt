package com.uziasferreira.randomuser.users.presentation.view

import com.uziasferreira.randomuser.core.presentation.BaseView
import com.uziasferreira.randomuser.users.presentation.model.PresentationUser
import io.reactivex.Flowable
import io.reactivex.disposables.Disposable

interface UsersView : BaseView {
    fun subscribeInto(flow: Flowable<List<PresentationUser>>): Disposable
}