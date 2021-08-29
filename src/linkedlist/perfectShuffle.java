package com.interview.linklist;


/**
 * Date 17/08/2021
 * @author Brijoo Bopanna
 *
 * Suppose you have a deck of cards represented as a linked list. You can perfectly shuffle
 * that list by cutting it at the halfway point, then interleaving the two halves by alternating back
 * and forth between the cards. For example, suppose you want to perfectly shuffle
 * this sequence: 1 2 3 4 5 6 7 8 9 10
 * You'd start by splitting it into two halves, like this:  1 2 3 4 5       6 7 8 9 10
 * Then, you'd interleave the halves, like this: 6 1 7 2 8 3 9 4 10 5
 * The resulting list is said to have been perfectly shuffled
 *
 * Time complexity  O(n)
 * Space complexity O(1)
 */

public class perfectShuffle {

  public Node perfectShuffleImpl(Node head) {
    LinkList ll = new LinkList();
      if (head == null) return null;
      int len = ll.size(head);
      int j = len%2;
      if ((len <=2) || (j>0)) return head;
      Node head1 = ll.nodeAt(head, len/2-1);
      Node head2 = head1.next;
      head1.next = null;
    return interLeaveMerge(head, head2);

  }

  public Node interLeaveMerge(Node head1, Node head2)
  {
    Node head3 = null;
    Node temp = null;
    Node curNode = null;
    head3 = head1;
    while((head1 != null) && (head2 != null))
    {
      temp = head1.next;
      head1.next = head2;
      head2 = head2.next;
      head1.next.next = null;
      if (curNode != null)
      {
        curNode.next = head1;
        curNode = head1.next;
      }
      else
      {
        curNode = head1.next;
      }
      head1 = temp;
    }
    return head3;
  }

  public static void main(String args[]) {
    LinkList ll = new LinkList();
    perfectShuffle ps= new perfectShuffle();
    Node head = null;
    head = ll.addNode(1, head);
    head = ll.addNode(2, head);
    head = ll.addNode(3, head);
    head = ll.addNode(4, head);
    head = ll.addNode(5, head);
    head = ll.addNode(6, head);
    ll.printList(head);
    head = ps.perfectShuffleImpl(head);
    ll.printList(head);

  }
}