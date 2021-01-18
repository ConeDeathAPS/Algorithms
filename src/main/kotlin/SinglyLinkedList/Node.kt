package SinglyLinkedList

fun printList(root: Node?) {
    var node = root;
    while (node != null) {
        println(node.key)
        node = node.next
    }
}

fun fromArray(array: List<Int>): Node {
    var node: Node? = null
    var root: Node? = null
    array.forEach {
        if (node != null) {
            node?.next = Node(it)
            node = node?.next
        } else {
            node = Node(it)
            root = node
        }
    }
    return root!!
}

fun removeValue(value: Int, listRoot: Node) {
    var currentNode: Node? = listRoot
    var previousNode: Node? = null
    while(currentNode != null) {
        if (currentNode.key == value) {
            previousNode?.next = currentNode.next
            break
        }
        previousNode = currentNode
        currentNode = currentNode.next
    }
}

class Node (val key: Int) {
    var next: Node? = null
}