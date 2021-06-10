package cn.ebing.dog.api.algorithm;

public class ListNode {
    ListNode next;
    int val;

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public static ListNode arrayToList(int[] array) {
        if (array == null) {
            return new ListNode();
        }
        ListNode root = new ListNode();
        root.setVal(array[0]);

        ListNode other = root;//生成另一个节点，并让other指向root节点，other在此作为一个临时变量，相当于指针

        for (int i=1; i<array.length; i++) {
            ListNode listNode = new ListNode();
            listNode.setVal(array[i]);

            other.setNext(listNode);
            other = listNode;
        }

        return root;
    }

    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("head is null");
        }
        ListNode node = head;
        while (node != null) {
            System.out.println(node.getVal() + " , ");
            node = node.getNext();
        }
    }
}

