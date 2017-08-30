package com.uziasferreira.randomuser.core.presentation

interface BasePresenter {

    fun attachTo(view: BaseView)

    fun detachFrom(view: BaseView)

}