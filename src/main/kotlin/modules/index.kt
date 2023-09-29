package modules
import source.vec3

//interface Mover {
//    fun move(speed: Int)
//}

data class Wheel(
    var radius: Double,
    var color: String,
);

//data class Wing(
//    var size: Int
//);

class WheelPlatform(
    wheelCount: Int,
    radius: Double,
    color: String
) {
    val wheels = Array<Wheel>(wheelCount) { Wheel(radius, color) }
    fun move(speed: Int) {
        println("${wheels.size} wheels move with speed $speed")
    }
}

class Engine(
    var power: Int,
) {
    fun move(wheelPlatform: WheelPlatform): vec3 {
        wheelPlatform.move(power / wheelPlatform.wheels.size)
        return vec3((power.toDouble() / wheelPlatform.wheels[0].radius).toInt(), 0, 0)
    }
}