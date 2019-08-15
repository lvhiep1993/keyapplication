package com.base.kulturely.data.remote.base

import com.example.keyapplication.data.remote.ServiceGenerator

abstract class BaseManager<T>(private val endpointClazz: Class<T>) {

    protected val service: T
        get() = ServiceGenerator.createService(endpointClazz)
}
