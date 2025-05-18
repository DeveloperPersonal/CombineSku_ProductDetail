package com.eco.musicplayer.audioplayer.screens.paywall

import com.android.billingclient.api.Purchase
import com.eco.musicplayer.audioplayer.billing.InAppBillingListener
import com.eco.musicplayer.audioplayer.billing.model.BaseProductDetails
import com.eco.musicplayer.audioplayer.billing.model.ProductInfo

fun PaywallActivity.initBilling() {
    inAppBillingManager.listener = createInAppBillingListener()
    inAppBillingManager.productInfoList = emptyList()
    inAppBillingManager.startConnectToGooglePlay()
}

fun PaywallActivity.createInAppBillingListener() = object : InAppBillingListener {
    override fun onStartConnectToGooglePlay() {
// Loading goi gia
    }

    override fun onProductsLoaded(products: List<BaseProductDetails>) {
        loadPrice(products)
    }

    override fun onPurchasesLoaded(purchases: List<BaseProductDetails>) {
        // TODO: Update goi gia va luu vao SharedPreferences
        if (purchases.isNotEmpty()) updatePurchases(purchases)
    }

    override fun onInAppBillingError(message: String) {

    }

    override fun onStartAcknowledgePurchase() {
        // Loading full screen
    }

    override fun onPurchaseAcknowledged(productInfo: ProductInfo, purchase: Purchase) {
        // TODO: Update UI
    }

    override fun onUserCancelPurchase() {

    }

    override fun onPurchaseError(message: String, productInfo: ProductInfo) {
// Bao loi
    }

}