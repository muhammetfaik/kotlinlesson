package com.programming.kotlin.chapter01

import java.io.InputStream
import java.io.OutputStream
import java.math.BigDecimal
import org.joda.time.DateTime
import java.util.*
import javax.swing.plaf.basic.BasicInternalFrameTitlePane
import kotlin.random.Random

class  BasicGraphWithInner(graphName: String) {
    private val name: String

    init {
        name = graphName
    }
    inner class InnerLine(val x1: Int,val y1: Int, val x2: Int, val y2: Int) {
        fun draw(): Unit {
            println("Drawing Line from ($x1,$y1) to ($x2,$y2) for graph $name")
        }
        fun draw(): Unit{
            println("Drawing the graph $name")
        }
    }
}

interface Document {
    val version: Long
    val size: Long
    val name: String
    get() = "NoName"

    fun save(input: InputStream)
    fun load(stream: OutputStream)
    fun getDescription(): String {
        return  "Document $name has $size byte(-s)"
    }
}

enum class CardType {VISA,MASTERCARD,AMEX}

open class Payment(val amount: BigDecimal)
class CardPayment(amount: BigDecimal, val number: String, val expiryDate: DateTime, val type: CardType) : Payment(amount)
class ChequePayment : Payment {
    constructor(amount: BigDecimal,name: String, bankId: String) : super(amount)
    {
        this.name = name
        this.bankId = bankId
    }
    var name: String
        get() = this.name
    var bankId: String
        get() = this.bankId
}

interface Drivable {
    fun drive()
}
interface Sailable{
    fun saill()
}
class AmphibiousCar(val name: String) : Drivable,Sailable {
    override fun drive() {
        println("Driving...")
    }
    override fun saill(){
        println("Salling...")
    }
}
interface IPersistable {
 fun save(stream: InputStream)
}

interface IPrintable {
    fun print()
}

abstract class Document(val title: String)

class TextDocument(title: String) : IPersistable,Document(title),IPrintable {
 override fun save(stream: InputStream) {
    println("Saving to input stream")
 }

    override fun print() {
        println("Document name:$title")
    }
}

open class Container {
    protected open val fieldA: String = "Some Value"
}
class DerivedContainer: Container() {
    public override val fieldA: String = "Something value"
}

val derivedContainer = DerivedContainer()
println("DerivedContainer.field:")

interface Drivable {
    fun drive()
}

interface Sailable {
    fun saill()
}

class AmphibiousCar(val name: String) : Drivable,Sailable{
    override fun drive(){
        println("Driving...")
    }

    override fun saill() {
        println("Sailling...")
    }
}

interface IPersistable {
    fun save(stream: InputStream)
}
interface IPrintable {
    fun print()
}
open class Container{
    protected open val fieldA: String = "Some value"
}

class DerivedContainer : Container() {
    public override val fieldA: String = "Something else"
}
val derivedContainer = DerivedContainer()
println("DerivedContainer.fieldA:${derivedContainer.fieldA}")

abstract class A {
    abstract fun doSomething()
}
open class AParent protected constructor() {
    open fun someMethod(): Int =  Random().nextInt()
}

abstract class DDerived : AParent() {
    abstract override fun someMethod(): Int
}
class AlwaysOne : DDerived(){
    override fun someMethod(): Int {
        return 1
    }
}

