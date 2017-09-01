package com.uziasferreira.randomuser.util

interface ErrorPredicate {
    fun evaluate(error: Throwable): Boolean
}