package com.pogreb.shifttesttask.database

import androidx.room.TypeConverter
import com.pogreb.shifttesttask.shared.entity.Location
import com.pogreb.shifttesttask.shared.entity.Name
import com.pogreb.shifttesttask.shared.entity.Picture
import com.pogreb.shifttesttask.shared.entity.DateModel
import kotlinx.serialization.json.Json

class Converters {
    val json = Json { ignoreUnknownKeys = true }

    @TypeConverter
    fun nameToString(name: Name): String = json.encodeToString(name)

    @TypeConverter
    fun stringToName(jsonString: String): Name = json.decodeFromString(jsonString)

    @TypeConverter
    fun locationToString(location: Location): String = json.encodeToString(location)

    @TypeConverter
    fun stringToLocation(jsonString: String): Location = json.decodeFromString(jsonString)

    @TypeConverter
    fun dateModelToString(dateModel: DateModel): String = json.encodeToString(dateModel)

    @TypeConverter
    fun stringToDateModel(jsonString: String): DateModel = json.decodeFromString(jsonString)

    @TypeConverter
    fun pictureToString(picture: Picture): String = json.encodeToString(picture)

    @TypeConverter
    fun stringToPicture(jsonString: String): Picture = json.decodeFromString(jsonString)
}