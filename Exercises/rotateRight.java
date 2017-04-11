/**
 * Definition for singly-linked list.
 **/
 
public class rotateRight {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
        {
            return head;
        }
        
        int len = 0;
        
        ListNode curr = head;
        ListNode probe = head;
        
        while(curr!=null)
        {
            curr=curr.next;
            len++;
        }

        curr = head;
        
        if (k == len || k % len == 0)
        {
            return head; 
        }
        else if (k > len)
        {
            k = k % len;
        }
        
        for(int i = 0; i < k; i++)
        {
            probe = probe.next;
        }
        
        
        while(probe.next != null)
        {
            probe=probe.next;
            curr=curr.next;
        }
        
        ListNode tmp = curr.next;
        curr.next = probe.next;
        probe.next = head;
        head = tmp;
        return head;
    }

     public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        ListNode curr = head;
        for(int i = 2; i <= 5;i++)
        {
            curr.next = new ListNode(i);
            curr = curr.next;
            if(i == 5)
            {
                curr.next = null;
            }
            
        }

        curr = head;
        while(curr!=null)
        {
            //System.out.println(curr.val);
            curr=curr.next;
        }

        System.out.println(rotateRight(head, 2).val);

    }
}