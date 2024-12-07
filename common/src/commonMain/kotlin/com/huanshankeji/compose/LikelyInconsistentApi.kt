package com.huanshankeji.compose

@RequiresOptIn(
    "This API is likely to be inconsistent now on Compose UI and Compose HTML, which could affect the final visual effect. " +
            "Please verify on both kinds of targets to make sure it works as expected.",
    RequiresOptIn.Level.WARNING
)
@Retention(AnnotationRetention.BINARY)
annotation class LikelyInconsistentApi