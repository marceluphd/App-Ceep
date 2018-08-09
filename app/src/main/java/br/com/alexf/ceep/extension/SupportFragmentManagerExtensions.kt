package br.com.alexf.ceep.extension

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction

fun FragmentManager.transaction(
        addToBackStack: Boolean = false,
        body: FragmentTransaction.() -> Unit) {
    val transaction = this.beginTransaction()
    if (addToBackStack) transaction?.addToBackStack(null)
    transaction.body()
    transaction.commit()
}