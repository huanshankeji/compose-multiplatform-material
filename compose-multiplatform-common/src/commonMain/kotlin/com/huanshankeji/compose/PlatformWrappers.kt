package com.huanshankeji.compose

interface PlatformWrapperInterface<PlatformValue> {
    val platformValue: PlatformValue

    abstract class Impl<PlatformValue>(override val platformValue: PlatformValue) :
        PlatformWrapperInterface<PlatformValue>
}

abstract class PlatformWrapperClass<PlatformValue>(val platformValue: PlatformValue)
