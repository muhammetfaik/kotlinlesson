package com.programming.kotlin.chapter01

abstract class Shape protected constructor() {
    var XLocation: Int
        get() = this.XLocation
        set(value: Int) {
        this.XLocation = value
        }

    var YLocation: Int
        get() = this.YLocation
        set(value: Int) {
        this.YLocation = value
        }
    var Width: Double
        get() = this.Width
        set(value: Double){
            this.Width = value
        }

}