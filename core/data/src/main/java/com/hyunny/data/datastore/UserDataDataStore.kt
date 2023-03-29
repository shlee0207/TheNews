package com.hyunny.data.datastore

import android.content.Context
import androidx.datastore.core.CorruptionException
import androidx.datastore.core.DataStore
import androidx.datastore.core.Serializer
import androidx.datastore.dataStore
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream

object InterestsSerializer : Serializer<Interests> {
    override val defaultValue: Interests
        get() = Interests.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): Interests {
        try {
            return Interests.parseFrom(input)
        }  catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(
        t: Interests,
        output: OutputStream
    ) = t.writeTo(output)
}

val Context.interestsDataStore: DataStore<Interests> by dataStore(
    fileName = "userdata.proto",
    serializer = InterestsSerializer
)
