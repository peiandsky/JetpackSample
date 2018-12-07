package com.zlcdgroup.jetpacksample.net.dto

open class JuHeApiResponse<T> {
    var reason: String? = null
    var error_code: Int? = null
    var result: T? = null
}