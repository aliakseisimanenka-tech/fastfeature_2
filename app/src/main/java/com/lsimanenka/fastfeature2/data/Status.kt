package com.lsimanenka.fastfeature2.data

enum class ApiStatus(val value: String) {
    SUCCESS("success"),
    ERROR("error");

    companion object {
        fun fromString(value: String): ApiStatus? =
            entries.find { it.value == value }
    }
}