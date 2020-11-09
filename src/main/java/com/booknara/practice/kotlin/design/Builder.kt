package com.booknara.practice.kotlin.design

class Car private constructor(builder: Builder) {
    val engine: String          // mandatory
    val color: String?          // optional
    val rims: String?           // optional
    val rooftop: String?        // optional
    val transmission: String?   // optional

    init {
        this.engine = builder.engine
        this.color = builder.color
        this.rims = builder.rims
        this.rooftop = builder.rooftop
        this.transmission = builder.transmission
    }

    class Builder(val engine: String) {
        var color: String? = null
            private set
        var rims: String? = null
            private set
        var rooftop: String? = null
            private set
        var transmission: String? = null
            private set

        fun withColor(color: String) = apply {
            this.color = color
        }
        fun withRims(rims: String) = apply {
            this.rims = rims
        }
        fun withRooftop(rooftop: String) = apply {
            this.rooftop = rooftop
        }
        fun withTransmission(transmission: String) = apply {
            this.transmission = transmission
        }

        fun build() = Car(this)
    }
}

class CarAssembler {
    companion object {
        fun createSportsCar() : Car {
            return Car.Builder("V12")
                    .withColor("red")
                    .withRooftop("convertible")
                    .withTransmission("automatic")
                    .build()
        }

        fun createBlingBlingCar() : Car {
            return Car.Builder("2.0")
                    .withColor("white")
                    .withRims("17")
                    .build()
        }
    }
}