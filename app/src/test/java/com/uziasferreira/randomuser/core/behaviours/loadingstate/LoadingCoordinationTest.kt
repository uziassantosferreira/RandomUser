package com.uziasferreira.randomuser.core.behaviours.loadingstate

import com.nhaarman.mockito_kotlin.mock
import com.uziasferreira.randomuser.core.presentation.LoadingView
import com.uziasferreira.randomuser.helper.MockitoHelpers
import io.reactivex.Flowable
import io.reactivex.functions.Action
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class LoadingCoordinationTest {

    private val uiScheduler = Schedulers.trampoline()
    private lateinit var loadingCoordination: LoadingCoordination<String>

    var showAction: Action = mock()
    var hideAction: Action = mock()

    @Before
    fun beforeEachTest() {
        val view = object : LoadingView {
            override fun showLoading(): Action {
                return showAction
            }

            override fun hideLoading(): Action {
                return hideAction
            }
        }

        loadingCoordination = LoadingCoordination(view, uiScheduler)
    }

    @Test
    fun should_show_and_hide_when_emits_itens() {
        Flowable.just("A", "B", "C")
                .compose<Any>(loadingCoordination)
                .subscribe()

        checkLoadingCoordinated()
    }

    @Test
    fun should_show_and_hide_when_no_emits_itens() {
        val empty = Flowable.empty<String>()
        empty.compose<Any>(loadingCoordination).subscribe()

        checkLoadingCoordinated()
    }

    @Test
    fun should_show_and_hide_when_emit_error() {
        val empty = Flowable.error<String>(RuntimeException())
        empty.compose<Any>(loadingCoordination).subscribe({}, {})

        checkLoadingCoordinated()
    }

    private fun checkLoadingCoordinated() {
        val inOrder = Mockito.inOrder(showAction, hideAction)
        inOrder.verify(showAction, MockitoHelpers.oneTimeOnly()).run()
        inOrder.verify(hideAction, MockitoHelpers.oneTimeOnly()).run()
    }

}