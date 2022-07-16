data class Vehicle(val name: String) {

    inner class Engine(val horsepower: Int) {

        fun start() {
            println("RRRrrrrrrr....")
        }

        fun printHorsePower() {
            println("The $name vehicle has $horsepower horsepower.")
        }
    }
}