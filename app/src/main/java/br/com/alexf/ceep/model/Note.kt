package br.com.alexf.ceep.model

import java.util.*

class Note(
        val id: String = UUID.randomUUID().toString(),
        val title: String = "",
        val description: String = "")