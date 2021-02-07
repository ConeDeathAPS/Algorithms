fun main(args: Array<String>) {
    val string: String = "PAYPALISHIRING"
    val zz: String = StringUtility.ZigZag().convertStringToZigZag(string, 4)
    println("Zig zagged string: $zz")
}
