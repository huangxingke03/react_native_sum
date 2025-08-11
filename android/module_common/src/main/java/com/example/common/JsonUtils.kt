package com.example.common

import com.google.gson.Gson

class JsonUtils {
    companion object {
        fun <T> toJsonStringGson(data: T): String {
            return Gson().toJson(data)
        }
    }
}