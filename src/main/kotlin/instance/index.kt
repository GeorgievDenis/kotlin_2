package instance

import modules.Engine
import modules.WheelPlatform
import source.Params
import source.vec3

sealed interface Body {
    var params: Params
    var position: vec3
    fun move()
}
sealed interface Brand {
    val brand: String
}

interface Machine: Body, Brand {
    val engine: Engine
    val wheels: WheelPlatform
    val name: String
    override fun move() {
        print(name)
        print(": ")
        val dif = engine.move(wheels)
        position += dif;
    }
}