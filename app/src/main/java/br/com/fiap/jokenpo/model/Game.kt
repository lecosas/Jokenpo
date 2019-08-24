package br.com.fiap.jokenpo.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Game(
    val eventName: String = "",
    val homeTeam: String = "",
    val awayTeam: String = ""
): Parcelable