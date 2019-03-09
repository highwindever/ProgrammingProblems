package chapter2LinkedLists;


public class LRU {
  class Node {
    String key;
    int value;
    Node prev;
    Node next;

    public Node(String key, int value) {
      this.key = key;
      this.value = value;
    }
  }
  
  private Node head;
  private Node tail;
  private int capacity;
  private int used = 0;

  public LRU(int capacity) {
    this.capacity = capacity;
  }

  void set(String key, int value) {
    //先查询key对应的node是否存在
    Node node = findNode(key);

    if (node == null) {
      //不存在节点则新建
      node = new Node(key, value);
      //插入新节点到表头
      if (used >= capacity) {
        //容量已满先移除尾节点，再将节点插到表头
        remove(tail);
      }
    } else {
      //节点已存在，则移除旧的节点，再将节点插到表头
      remove(node);
      node.value = value;
    }
    updateHead(node);
  }

  Integer get(String key) {
    Node node = findNode(key);
    if (node != null) {
      //节点存在，则需要将节点移到表头
      remove(node);
      updateHead(node);
      return node.value;
    }
    return null;
  }

  void updateHead(Node node) {
    if (head != null) {
      node.next = head;
      head.prev = node;
    }
    head = node;
    if (tail == null) {
      tail = node;
    }
    used++;
  }

  void remove(Node node) {
    if (node.prev != null) {
      node.prev.next = node.next;
    } else {
      //node是head的情况
      head = node.next;
    }

    if (node.next != null) {
      node.next.prev = node.prev;
    } else {
      //node是tail的情况
      tail = node.prev;
    }

    node.next = null;
    node.prev = null;
    used--;
  }

  Node findNode(String key) {
    Node node = head;
    while(node.next != null) {
      if (node.key.equals(key)) {
        return node;
      }
      node = node.next;
    }
    return null;
  }


}
