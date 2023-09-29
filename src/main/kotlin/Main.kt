import instance.Machine
import modules.Engine
import modules.WheelPlatform
import source.Params
import source.safeIntInput
import source.safeStringInput
import source.vec3

sealed interface Body {
    var params: Params
    var position: vec3
    fun move()
}
class Bike(
    enginePower: Int,
//    volume: Int,
    brand: String,
    startPosition: vec3,
    name: String,
): Machine {

    override val wheels = WheelPlatform(2, 0.5, "gray")
    override val engine = Engine(enginePower)
    override var position = startPosition
    override var params = Params(20)
    override val brand = brand
    override val name = name

    companion object {
        fun create(): Bike {
            println("Название: ")
            val iname = safeStringInput()
            println("Марка: ")
            val ibrand = safeStringInput()
            println("Мощность двигателя (число): ")
            val ienginePower = safeIntInput()
            return Bike(
                ienginePower,
                ibrand,
                vec3(0, 0, 0),
                iname,
            )
        }
    }

}

abstract class Car(
    wheelRadius: Double,
    name: String
): Machine {
    override val wheels = WheelPlatform(4, wheelRadius, "black")
    override val name = name
    fun upgrate(energy: Int) {
        this.engine.power += energy
    }
}


abstract class Bus: Car {
    abstract val seatsCount: Int
    abstract var availableSeats: Int
    constructor(wheelRadius: Double, name: String): super(wheelRadius, name)
}

class PublicBus(
    availableSeats: Int,
    seatsCount: Int,
    brand: String,
    initPosition: vec3,
    enginePower: Int,
    name: String,
    val cost: Int,
): Bus(1.0, name) {
    override var params = Params(100)
    override var availableSeats = availableSeats
    override val brand = brand
    override var position = initPosition
    override val seatsCount = seatsCount
    override val engine = Engine(enginePower)
    companion object {
        fun create(): PublicBus {
            println("Название: ")
            val iname = safeStringInput()
            println("Марка: ")
            val ibrand = safeStringInput()
            println("Мощность двигателя (число): ")
            val ienginePower = safeIntInput()
            println("Количество мест: ")
            val iseatsCount = safeIntInput()
            println("Количество свободных мест: ")
            val iavailableSeats = safeIntInput()
            println("Стоимость проезда: ")
            val icost = safeIntInput()
            return PublicBus(
                iavailableSeats,
                iseatsCount,
                ibrand,
                vec3(0, 0, 0),
                ienginePower,
                iname,
                icost,
            )
        }
    }
}
class MilitaryBus(
    availableSeats: Int,
    seatsCount: Int,
    initPosition: vec3,
    name: String,
    val weapon: String
): Bus(2.0, name) {
    override var params = Params(100)
    override var availableSeats = availableSeats
    override val brand = "Army"
    override var position = initPosition
    override val seatsCount = seatsCount
    override val engine = Engine(100)

    fun shoot() {
        println("shoot by military bus")
    }

    companion object {
        fun create(): MilitaryBus {
            println("Название: ")
            val iname = safeStringInput()
            println("Тип орудия: ")
            val iweapon = safeStringInput()
            println("Количество мест: ")
            val iseatsCount = safeIntInput()
            println("Количество свободных мест: ")
            val iavailableSeats = safeIntInput()
            return MilitaryBus(
                iavailableSeats,
                iseatsCount,
                vec3(0, 0, 0),
                iname,
                iweapon
            )
        }
    }

}
class Truck(
    brand: String,
    initPosition: vec3,
    enginePower: Int,
    val loadCapacity: Int,
    name: String
): Car(3.0, name) {
    override var params = Params(100)
    override val brand = brand
    override var position = initPosition
    override val engine = Engine(enginePower)

    companion object {
        fun create(): Truck {
            println("Название: ")
            val iname = safeStringInput()
            println("Марка: ")
            val ibrand = safeStringInput()
            println("Мощность двигателя: ")
            val ienginePower = safeIntInput()
            println("Грузоподъемность: ")
            val iloadCapacity = safeIntInput()
            return Truck(
                ibrand,
                vec3(0, 0, 0),
                ienginePower,
                iloadCapacity,
                iname,
            )
        }
    }

}


fun main(args: Array<String>) {

    val publicBus = PublicBus.create()
    publicBus.move()
    publicBus.upgrate(100)
    publicBus.move()
    val militaryBus = MilitaryBus.create()
    militaryBus.move()
    militaryBus.upgrate(100)
    militaryBus.move()
    val bike = Bike.create()
    bike.move()
    val truck = Truck.create()
    truck.move()
    truck.upgrate(100)
    truck.move()

    println(truck.position)
    println(militaryBus.position)
    println(publicBus.position)
    println(bike.position)

}