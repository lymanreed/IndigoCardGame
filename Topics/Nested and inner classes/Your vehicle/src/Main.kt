class Vehicle {
    inner class Engine {
        fun start() {
            println("RRRrrrrrrr....")
        }
    }
}
// do not touch the class above

fun main() {
    val engine = Vehicle().Engine()
    engine.start()
}