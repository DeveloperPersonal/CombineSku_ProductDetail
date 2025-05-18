package com.eco.musicplayer.audioplayer.billing

import android.app.Activity
import android.content.Context
import android.os.Handler
import android.os.Looper
import com.android.billingclient.api.BillingClient
import com.android.billingclient.api.BillingClientStateListener
import com.android.billingclient.api.BillingResult
import com.android.billingclient.api.PurchasesUpdatedListener
import com.eco.musicplayer.audioplayer.billing.model.BaseProductDetails
import com.eco.musicplayer.audioplayer.billing.model.ProductDetailsWrapper
import com.eco.musicplayer.audioplayer.billing.model.ProductInfo
import com.eco.musicplayer.audioplayer.billing.model.SkuDetailsWrapper

class InAppBillingManager(context: Context) {

    var listener: InAppBillingListener? = null
    var productInfoList = listOf<ProductInfo>()
    val allProducts = mutableListOf<BaseProductDetails>()
    private val handler = Handler(Looper.getMainLooper())

    private val purchasesUpdatedListener =
        PurchasesUpdatedListener { billingResult, purchases ->
            // TODO: Code
        }

    private var billingClient = BillingClient.newBuilder(context)
        .setListener(purchasesUpdatedListener)
        .enablePendingPurchases()
        .build()

    fun startConnectToGooglePlay() {
        listener?.onStartConnectToGooglePlay()
        billingClient.startConnection(object : BillingClientStateListener {
            override fun onBillingSetupFinished(billingResult: BillingResult) {
                post {
                    if (billingResult.responseCode == BillingClient.BillingResponseCode.OK) {
                        queryProducts()
                    } else {

                    }
                }
            }

            override fun onBillingServiceDisconnected() {
                post { listener?.onInAppBillingError("...") }
            }
        })

    }

    private fun queryProducts() {
        // TODO: Sau khi queryProductDetails -> queryPurchases()
        // TODO: Code
        if (isFeatureSupported()) {
            //QueryProductDetailsParams
        } else {
            //SkuDetailsParams
        }
        post { listener?.onProductsLoaded(allProducts) }

        queryPurchases()
    }

    private fun queryPurchases() {
        // TODO: Code
        post { listener?.onPurchasesLoaded(emptyList()) }
    }

    fun launchPurchase(activity: Activity, baseProduct: BaseProductDetails) {
        when (baseProduct) {
            is ProductDetailsWrapper -> {
                // TODO: Code
            }

            is SkuDetailsWrapper -> {
                // TODO: Code
            }
        }
    }

    fun endConnectToGooglePlay() {
        billingClient.endConnection()
    }

    fun destroy() {
        listener = null
        endConnectToGooglePlay()
    }

    private fun isFeatureSupported(): Boolean {
        return billingClient.isFeatureSupported(
            BillingClient.FeatureType.PRODUCT_DETAILS
        ).responseCode == BillingClient.BillingResponseCode.OK
    }

    private fun post(work: (() -> Unit)) {
        handler.post { work() }
    }
}