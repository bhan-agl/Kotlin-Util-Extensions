package com.utility.etx

/**
 * can be used to convert when() statement into expression in order to make it exhaustive
 */
val <T> T.makeExhaustive: T
    get() = this