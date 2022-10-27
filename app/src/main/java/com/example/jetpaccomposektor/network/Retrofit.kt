package com.example.jetpaccomposektor.network

import com.google.gson.annotations.SerializedName

data class DateTimeServer(
    @field:SerializedName("date_time")
    val dateTimeServer: String? = null,
    @field:SerializedName("estado")
    val estado: String? = null,
    @field:SerializedName("mensaje")
    val mensaje: String? = null,
)

