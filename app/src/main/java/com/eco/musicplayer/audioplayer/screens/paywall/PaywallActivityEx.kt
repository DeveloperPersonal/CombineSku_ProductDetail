package com.eco.musicplayer.audioplayer.screens.paywall

import android.view.View
import com.eco.musicplayer.audioplayer.billing.model.BaseProductDetails


fun PaywallActivity.loadSubsPolicyContent() {
// TODO: Update UI
}

fun PaywallActivity.loadPriceUI(products: List<BaseProductDetails>) {
    detailsMap[1] = products.find { it.productId == item1ProductId }
    detailsMap[2] = products.find { it.productId == item2ProductId }
    detailsMap[3] = products.find { it.productId == item3ProductId }
    // TODO: Update UI

}

fun PaywallActivity.updatePurchases(purchases: List<BaseProductDetails>){
    // TODO: Update UI
}

fun PaywallActivity.setOnClicks() {
    View(this).apply { contentDescription = "Item1" }.setOnClickListener {
        selectPosition = 1
        updateItem()
    }
    View(this).apply { contentDescription = "Item2" }.setOnClickListener {
        selectPosition = 2
        updateItem()
    }
    View(this).apply { contentDescription = "Item3" }.setOnClickListener {
        selectPosition = 3
        updateItem()
    }
    View(this).apply { contentDescription = "launchPurchase" }.setOnClickListener {
        detailsMap[selectPosition]?.let { it1 -> inAppBillingManager.launchPurchase(this, it1) }
            ?: run {
                // Bao loi
            }
    }
}

fun PaywallActivity.updateItem() {
    when (selectPosition) {
        1 -> {}
        2 -> {}
        3 -> {}
    }
}