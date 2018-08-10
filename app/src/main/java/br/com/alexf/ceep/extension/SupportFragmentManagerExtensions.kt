package br.com.alexf.ceep.extension

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction

fun FragmentManager.transaction(
        addToBackStack: Boolean = false,
        tag: String? = null,
        body: FragmentTransaction.() -> Unit) {
    val transaction = this.beginTransaction()
    if (addToBackStack) transaction?.addToBackStack(tag)
    transaction.body()
    transaction.commit()
}

fun FragmentManager.hasInBackStack() = backStackEntryCount > 1

fun FragmentManager.notHasInBackStack() = !hasInBackStack()