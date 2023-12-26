package com.cjamcu.earthquakemonitor

class EqResponse(
    val features: List<Feature>
)

class Feature(
    val id: String,
    val properties: Properties,
    val geometry: Geometry
)

class Properties(
    val mag: Double,
    val place: String,
    val time: Long

)

class Geometry(
    private val coordinates: List<Double>
) {
    val longitude: Double
        get() = coordinates[0]

    val latitude: Double
        get() = coordinates[1]
}