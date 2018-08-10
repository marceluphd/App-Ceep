package br.com.alexf.ceep.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Note(
        val id: String = UUID.randomUUID().toString(),
        val title: String = "",
        val description: String = "") : Parcelable