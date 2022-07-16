import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val range1 = scanner.nextInt()..scanner.nextInt()
    val range2 = scanner.nextInt()..scanner.nextInt()
    val test = scanner.nextInt()
    println(test in range1 || test in range2)

}
