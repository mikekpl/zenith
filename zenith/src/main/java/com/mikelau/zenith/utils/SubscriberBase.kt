package com.mikelau.zenith.utils

import io.reactivex.FlowableSubscriber
import org.reactivestreams.Subscription

abstract class SubscriberBase<T : Any> : FlowableSubscriber<T> {

    var subscription: Subscription? = null
        private set

    protected abstract fun onSuccess(t: T)
    protected abstract fun onFailure(t: Throwable)

    private fun printCurrentTraffic(scenario: String) {
        val dataTraffic = DataTraffic()
        val txDifference = dataTraffic.totalTxBytes - mDataTraffic.totalTxBytes
        val rxDifference = dataTraffic.totalRxBytes - mDataTraffic.totalRxBytes

        DebugLog.justPrint(String.format("xXx<|DataConsumption:%s, %s|>xXx",
            scenario.toUpperCase(),
            DataTraffic(txDifference, rxDifference)))
        mDataTraffic = dataTraffic
    }

    override fun onSubscribe(s: Subscription) {
        s.request(java.lang.Long.MAX_VALUE)
        this.subscription = s
    }

    override fun onNext(t: T) {
        if (!DebugLog.isProduction) {
            val enclosingClass = t.javaClass.enclosingClass
            val currentObjectName = if (enclosingClass != null)
                enclosingClass.name
            else
                t.javaClass.name
            printCurrentTraffic(currentObjectName)
        }
        onSuccess(t)
    }

    override fun onError(t: Throwable) {
        DebugLog.justPrint(t.message + "")
        onFailure(t)
    }

    override fun onComplete() {

    }

    companion object {
        private var mDataTraffic = DataTraffic()
    }
}
