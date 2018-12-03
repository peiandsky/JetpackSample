package com.zlcdgroup.fastjson

import com.alibaba.fastjson.JSON
import com.zlcdgroup.jetpacksample.BuildConfig
import okhttp3.MediaType
import okhttp3.RequestBody
import okhttp3.ResponseBody
import okio.Okio
import retrofit2.Converter
import retrofit2.Retrofit
import java.io.IOException
import java.lang.reflect.Type


class FastJsonResponseBodyConverter<T>(private val type: Type) : Converter<ResponseBody, T> {

    /*
    * 转换方法
    */
    @Throws(IOException::class)
    override fun convert(value: ResponseBody): T? {
        val bufferedSource = Okio.buffer(value.source())
        val tempStr = bufferedSource.readUtf8()
        if (BuildConfig.DEBUG) {
            // Logger.json(tempStr)
        }
        bufferedSource.close()
        return JSON.parseObject<T>(tempStr, type)

    }
}


class FastJsonRequestBodyConverter<T> : Converter<T, RequestBody> {
    @Throws(IOException::class)
    override fun convert(value: T): RequestBody {
        return RequestBody.create(
            MediaType.parse("application/json; charset=UTF-8")
            , JSON.toJSONBytes(value)
        )
    }
}

class FastJsonConverterFactory : Converter.Factory() {

    /**
     * 需要重写父类中responseBodyConverter，该方法用来转换服务器返回数据
     */
    @JvmSuppressWildcards
    override fun responseBodyConverter(
        type: Type?,
        annotations: Array<Annotation>?,
        retrofit: Retrofit?
    ): Converter<ResponseBody, Any>? {
        return FastJsonResponseBodyConverter(type!!)
    }

    /**
     * 需要重写父类中responseBodyConverter，该方法用来转换发送给服务器的数据
     */
    @JvmSuppressWildcards
    override fun requestBodyConverter(
        type: Type?,
        parameterAnnotations: Array<Annotation>?,
        methodAnnotations: Array<Annotation>?,
        retrofit: Retrofit?
    ): Converter<Any, RequestBody>? {
        return FastJsonRequestBodyConverter()
    }

    companion object {
        fun create(): FastJsonConverterFactory {
            return FastJsonConverterFactory()
        }
    }

}

