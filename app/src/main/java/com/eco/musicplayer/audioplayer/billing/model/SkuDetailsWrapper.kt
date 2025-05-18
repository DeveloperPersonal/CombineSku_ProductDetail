package com.eco.musicplayer.audioplayer.billing.model

import com.android.billingclient.api.SkuDetails

data class SkuDetailsWrapper(@Suppress("DEPRECATION") val skuDetails: SkuDetails) :
    BaseProductDetails() {
    override val productId: String
        get() = skuDetails.sku

}