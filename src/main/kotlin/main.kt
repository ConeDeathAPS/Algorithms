fun main(args: Array<String>) {
//    println("Singly Linked list")
//    val intArray = listOf<Int>(3,8,2,6,5,9,1)
//    val singlyLinkedList = SinglyLinkedList.fromArray(intArray)
//    printList(singlyLinkedList)
//    removeValue(6, singlyLinkedList)
//    SinglyLinkedList.printList(singlyLinkedList)
//
//    println("Doubly linked list")
//    val anotherIntArray = listOf<Int>(4,7,6,9,1,3,2,0)
//    val doublyLinkedList = DoublyLinkedList.fromArray(anotherIntArray)
//    DoublyLinkedList.printList(doublyLinkedList)
//    val s: String = "123555789";
//    val s: String = "asdkflracecarsadfglkjh";
    val s: String = "djiwabadbsokmbadabskjkjsaaakj123";
//    val s: String = "";
//    val s: String = "aaaaaaaaaaaaaaaaaaaaa";
    val o: String = StringUtility.ShortestPalindromicSubstring(s).extractLongestPalindrome();
    println("Longest palindrome in string '$s' is '$o'")
}