package br.com.alexf.ceep.ui.activity

import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import br.com.alexf.ceep.extension.notHasInBackStack

open class BaseActivity : AppCompatActivity() {

    override fun onBackPressed() {
        super.onBackPressed()
        with(supportFragmentManager) {
            if (notHasInBackStack()) {
                dismissActionBarBackButton()
            }
        }
    }

    private fun dismissActionBarBackButton() {
        supportActionBar?.let {
            dismissBackButton(it)
        }
    }

    protected fun showBackButton(actionBar: ActionBar, show: Boolean = true) {
        actionBar.setDisplayHomeAsUpEnabled(show)
        actionBar.setHomeButtonEnabled(show)
    }

    private fun dismissBackButton(actionBar: ActionBar) {
        showBackButton(actionBar = actionBar, show = false)
    }

}