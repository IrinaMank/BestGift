package com.giffter.bestgift.data

import android.net.Uri
import com.giffter.bestgift.domain.entity.Gift
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import io.reactivex.Completable
import io.reactivex.Single
import org.slf4j.LoggerFactory

class GiftApiRepository  : GiftApiInterface<Gift> {
    override fun getFilteredGifts(occassion: List<String>, role: List<String>, gender: List<String>, ageFrom: Int, ageTo: Int): Single<List<Gift>> {
        return Single.create { emitter ->
            if (emitter.isDisposed) {
                return@create
            }
            db.collection("gifts").whereArrayContains("occasion", occassion)
                    .get()

                    .addOnSuccessListener {
                        val tickets = it.map { document -> document.toObject(Gift::class.java) }
                        if (emitter.isDisposed) {
                            return@addOnSuccessListener
                        }
                        emitter.onSuccess(tickets)
                    }
                    .addOnFailureListener {
                        logger.error("Error getting tickets: $it")
                        emitter.onError(RuntimeException())
                    }

        }
    }

    private val db = FirebaseFirestore.getInstance()
    private val storageRef = FirebaseStorage.getInstance().reference
    private val logger = LoggerFactory.getLogger(this.javaClass.simpleName)

    override fun getAllGifts(): Single<List<Gift>> {
        return Single.create { emitter ->
            if (emitter.isDisposed) {
                return@create
            }
            db.collection("gifts")
                    .get()
                    .addOnSuccessListener {
                        val tickets = it.map { document -> document.toObject(Gift::class.java) }
                        if (emitter.isDisposed) {
                            return@addOnSuccessListener
                        }
                        emitter.onSuccess(tickets)
                    }
                    .addOnFailureListener {
                        logger.error("Error getting tickets: $it")
                        emitter.onError(RuntimeException())
                    }

        }
    }


}