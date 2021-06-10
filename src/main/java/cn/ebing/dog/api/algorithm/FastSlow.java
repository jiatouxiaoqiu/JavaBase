package cn.ebing.dog.api.algorithm;

public class FastSlow {

    public static void main(String[] args){
        int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        ListNode head = ListNode.arrayToList(array);
        ListNode.printList(head);
        findMid(head);
    }

    private static void findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null){
            if(fast.next.next != null){
                fast = fast.next.next;
                slow = slow.next;
            } else {
                slow = slow.next;
            }

        }
        System.out.println(slow.val);
    }
}
