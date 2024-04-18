package com.huanshankeji.compose.ui

expect interface Modifier {
    open fun <R> foldIn(initial: R, operation: (R, Element) -> R): R
    open infix fun then(other: Modifier): Modifier
    interface Element : Modifier
    companion object : Modifier
}