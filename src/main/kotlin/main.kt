fun main(args: Array<String>) {
    val integer: Int = -2147483648
    val reversed: Int = IntUtility.ReverseInt(integer).reverse()
    println("$integer reversed is $reversed")
}
