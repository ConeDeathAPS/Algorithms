import SinglyLinkedList.fromArray
import SinglyLinkedList.printList
import SinglyLinkedList.removeValue

fun main(args: Array<String>) {
    println("Linked list")
    val intArray = listOf<Int>(3,8,2,6,5,9,1)
    val singlyLinkedList = fromArray(intArray)
    printList(singlyLinkedList)
    removeValue(6, singlyLinkedList)
    printList(singlyLinkedList)
}