package com.arudo.jetpackcompose.utils

import com.example.jetpaccomposektor.utils.Const.DETAIL_ARG_GAMES_ID
import com.example.jetpaccomposektor.utils.Const.DETAIL_SCREEN
import com.example.jetpaccomposektor.utils.Const.HOME_SCREEN

sealed class Route(val route: String) {
    object Home: Route(HOME_SCREEN)
    object Detail: Route("$DETAIL_SCREEN/{$DETAIL_ARG_GAMES_ID}") {
        fun createRoute(gamesId: Int) = "$DETAIL_SCREEN/$gamesId"
    }
}