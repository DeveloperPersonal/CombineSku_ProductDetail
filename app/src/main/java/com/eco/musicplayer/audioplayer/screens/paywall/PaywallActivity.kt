package com.eco.musicplayer.audioplayer.screens.paywall

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.eco.musicplayer.audioplayer.billing.InAppBillingManager
import com.eco.musicplayer.audioplayer.billing.model.BaseProductDetails
import com.eco.musicplayer.audioplayer.music.R

class PaywallActivity : AppCompatActivity() {

    val inAppBillingManager by lazy {
        InAppBillingManager(this)
    }

    // Tuong ung voi item 1,2,3
    val detailsMap = hashMapOf<Int, BaseProductDetails?>()
    var selectPosition = 0

    //Exe
    val item1ProductId = "a"
    val item2ProductId = "b"
    val item3ProductId = "c"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_paywall2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        loadSubsPolicyContent()
        setOnClicks()
        initBilling()
    }

    override fun onDestroy() {
        inAppBillingManager.endConnectToGooglePlay()
        inAppBillingManager.destroy()
        super.onDestroy()
    }
}