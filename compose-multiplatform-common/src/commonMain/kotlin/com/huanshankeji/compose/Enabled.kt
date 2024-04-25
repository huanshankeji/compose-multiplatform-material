package com.huanshankeji.compose

// consider moving to a "web-common" or "html-common" module
fun Boolean.enabledToNullableDisabled(): Boolean? =
    if (this) null else false
