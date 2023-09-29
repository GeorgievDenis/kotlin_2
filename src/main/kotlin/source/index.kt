package source

import java.lang.reflect.Executable

data class vec3(
    var x: Int, var y: Int, var z: Int
) {
    operator fun plus(vec: vec3): vec3 {
        var rez = this
        rez.x += vec.x
        rez.y += vec.y
        rez.z += vec.z
        return rez
    }
}

data class Params(
    val volume: Int
)


fun safeIntInput(): Int {
    while (true) {
        try {
            return readLine()!!.toInt()
        } catch (e: Exception) {
            println("Неверный формат!!!")
        }
    }
}

fun safeStringInput(): String {
    while (true) {
        try {
            val field = readLine()
            if (field == null || field!! == "") {
                throw Exception()
            }
            return field
        } catch (e: Exception) {
            println("Неверный формат!!!")
        }
    }
}