package DoublyLinkedList

class Node(var key: Int) {
    var next: Node? = null
    var prev: Node? = null
}

fun fromArray(array: List<Int>): Node {
    var prev: Node? = null
    var root: Node? = null
    array.forEach {
        val node = Node(it)
        if (root == null) {
            root = node
        }
        if (prev != null) {
            prev?.next = node
        }
        node.prev = prev
        prev = node
    }
    return root!!
}

fun printList(root: Node) {
    var node: Node? = root
    while (node != null) {
        println(node.key)
        node = node.next
    }
}