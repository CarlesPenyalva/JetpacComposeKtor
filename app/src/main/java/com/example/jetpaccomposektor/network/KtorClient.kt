package com.example.jetpaccomposektor.network

import android.util.Log
import com.google.gson.Gson
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.plugins.observer.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json


private const val TIME_OUT = 60_000

object KtorClient {
    val client = HttpClient(Android) {

        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })

            engine {
                connectTimeout = TIME_OUT
                socketTimeout = TIME_OUT
            }
        }

        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    Log.v("Logger Ktor =>", message)
                }

            }
            level = LogLevel.ALL
        }

        install(ResponseObserver) {
            onResponse { response ->
                Log.d("HTTP status:", "${response.status.value}")
            }
        }
    }
    val gson: Gson = Gson().newBuilder().serializeNulls().disableHtmlEscaping().create()

}


//data class DateTimeServer(
//    val date_time: String?,
//    val estado: String?,
//    val mensaje: String?,
//)

@Serializable
data class RequestDateTimeServer(@SerialName("get_date_time") val getDateTime: String)

const val url = "https://www.gacic.es/scripts/WebServices/get_date_time.php"


fun ktor() {
    runBlocking {
        val gson = KtorClient.gson
        val client = KtorClient.client
        val response: HttpResponse = client.post(url) {
            contentType(ContentType.Application.Json)
            setBody(RequestDateTimeServer("GET_DATE_TIME"))
        }

        val json = response.bodyAsText()
        val convertedObject = gson.fromJson(json, DateTimeServer::class.java)
        Log.d("convertedObject", convertedObject.toString())

    }
}