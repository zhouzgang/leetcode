package doublepoint;

import java.util.Arrays;

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例 1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * 示例 2：
 * 输入：l1 = [], l2 = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *  
 *
 * 提示：
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 *
 * 链接：https://leetcode.cn/problems/merge-two-sorted-lists
 * @author brian.zhou
 * @date 6/22/22
 */
public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode list1 = ListNode.convert(new int[]{1,2,4});
        ListNode list2 = ListNode.convert(new int[]{1,3,4});
        ListNode.print(mergeTwoLists(list1, list2));
        list1 = ListNode.convert(new int[]{});
        list2 = ListNode.convert(new int[]{});
        ListNode.print(mergeTwoLists(list1, list2));
        list1 = ListNode.convert(new int[]{});
        list2 = ListNode.convert(new int[]{0});
        ListNode.print(mergeTwoLists(list1, list2));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1), p = dummy;
        ListNode p1 = list1, p2 = list2;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return dummy.next;
    }

    public static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        static ListNode convert(int[] arr) {
            if (arr.length == 0) {
                return null;
            }

            ListNode head = new ListNode(arr[0]), p = head;
            for (int i = 1; i < arr.length; i++) {
                p.next = new ListNode(arr[i]);
                p = p.next;
            }
            return head;
        }

        static void print(ListNode node) {
            while (node != null) {
                System.out.print(node.val + " ");
                node = node.next;
            }
            System.out.println();
        }
    }
}
