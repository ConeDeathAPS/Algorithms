package BinaryTree

class Node(
    var key: Int,
    var left: Node? = null,
    var right: Node? = null
) {
    fun find(value: Int): Node? = when {
        value > this.key -> right?.find(value)
        value < this.key -> left?.find(value)
        else -> this
    }

    fun scan(value: Int, node: Node?, parent: Node?) {
        if (node == null) {
            System.out.println("Unable to find node with value $value in the tree")
            return
        }
        when {
            value > this.key -> scan(value, this.right, this)
            value < this.key -> scan(value, this.left, this)
            else -> removeNode(this, parent)
        }
    }

    fun insert(value: Int) {
        if (value > this.key) {
            if (this.right == null) {
                this.right = Node(value)
            } else {
                this.right!!.insert(value)
            }
        } else if (value < this.key) {
            if (this.left == null) {
                this.left = Node(value)
            } else {
                this.left!!.insert(value)
            }
        }
    }

    fun delete(value: Int) {
        when {
            value > this.key -> scan(value, this.right, this)
            value < this.key -> scan(value, this.left, this)
            else -> removeNode(this, null)
        }
    }

    private fun removeNode(node: Node, parent: Node?) {
        if (parent == null) {
            throw IllegalStateException("Cannot remove root node")
        }
        when {
            node.left == null && node.right == null -> removeNoChildNode(node, parent)
            node.right == null && node.left != null -> removeSingleChildNode(parent, node.left!!)
            node.right != null && node.left == null -> removeSingleChildNode(parent, node.right!!)
        }
    }

    // Remove a node that has no children. We need to set the PARENT's corresponding node to null
    private fun removeNoChildNode(node: Node, parent: Node) {
        if (node == parent.left) {
            parent.left = null
        } else if (node == parent.right) {
            parent.right = null
        }
    }

    private fun removeSingleChildNode(parent: Node, child: Node) {
        parent.key = child.key
        parent.left = child.left
        parent.right = child.right
    }

    private fun removeTwoChildNode(node: Node) {
        val leftChild = node.left!!
        leftChild.right?.let {

        }
    }
}
