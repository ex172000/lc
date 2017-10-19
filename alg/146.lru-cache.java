import java.util.*;
class LRUCache {
    class Node {
        Node prev, next;
        int val, key;
        Node(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }
    Map<Integer, Node> map;
    Node head, tail;
    int size, cap;
    public LRUCache(int capacity) {
        cap = capacity;
        size = 0;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        node.next.prev = node.prev;
        node.prev.next = node.next;
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
        return node.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.next = head.next;
            node.next.prev = node;
            head.next = node;
            node.prev = head;
            node.val = value;
            return;
        }
        if (size == cap) {
            Node last = tail.prev;
            tail.prev.prev.next = tail;
            tail.prev = tail.prev.prev;
            map.remove(last.key);
            size--;
        }
        Node first = new Node(key, value);
        first.next = head.next;
        first.next.prev = first;
        head.next = first;
        first.prev = head;
        map.put(key, first);
        size++;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
