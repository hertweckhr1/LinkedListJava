// singly linked list -> you can only go forwards (not forwards and backwards)
public class LinkedList {
//  how do you keep head private?
    Node head;

    static class Node {
        int data;
        Node next;

//      constructor
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    public static LinkedList insert(LinkedList list, int data)
    {
        // Create a new node with given data
        Node new_node = new Node(data);
        new_node.next = null;

        // If the Linked List is empty,
        // then make the new node as head
        if (list.head == null) {
            list.head = new_node;
        }
        else {
            // Else traverse till the last node
            // and insert the new_node there
            Node current = list.head;
            while (current.next != null) {
                current = current.next;
            }

            // Insert the new_node at last node
            current.next = new_node;
        }

        // Return the list by head
        return list;
    }

    // Method to print the LinkedList.
    public static void printList(LinkedList list)
    {
        Node currentNode = list.head;

        System.out.print("LinkedList: ");

        // Traverse through the LinkedList
        while (currentNode != null) {
            // Print the data at current node
            System.out.println(currentNode.data);

            // Go to next node
            currentNode = currentNode.next;
        }
    }


    // Method to delete a node in the LinkedList by KEY
    public static LinkedList deleteByValue(LinkedList list, int value)
    {
        // Store head node
        Node currentNode = list.head,
        prev = null;

        //
        // CASE 1:
        // If head node itself holds the key to be deleted

        if (currentNode != null && currentNode.data == value) {
            list.head = currentNode.next; // Changed head

            // Return the updated List
            return list;
        }

        // CASE 2:
        // If the key is somewhere other than at head
        //

        // Search for the key to be deleted,
        // keep track of the previous node
        // as it is needed to change currNode.next
        while (currentNode != null && currentNode.data != value) {
            // If currNode does not hold key
            // continue to next node
            prev = currentNode;
            currentNode = currentNode.next;
        }

        // If the value was present, it should be at currNode
        // Therefore the currNode shall not be null
        if (currentNode != null) {
            // Since the value is at currNode
            // Unlink currNode from linked list
            prev.next = currentNode.next;
        }

        //
        // CASE 3: The value is not present
        //

        // If value was not present in linked list
        // currentNode should be null
        if (currentNode == null) {
            // Display the message
            System.out.println("No key found");
        }

        // return the List
        return list;
    }


    // method to create a Singly linked list with n nodes
    public static void main(String[] args)
    {
        /* Start with the empty list. */
        LinkedList list = new LinkedList();


        // Insert the values
        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list, 6);
        list = insert(list, 7);
        list = insert(list, 8);

        // Print the LinkedList
        printList(list);

        deleteByValue(list, 6);

        printList(list);
    }
}

