public class LinkedList implements List {

    private Node head;
    private int size = 0;

    public static class Node{
        Object data;
        Node next;

        public Node(Object data, Node next){
            this.data = data;
            this.next = next;
        }

    };

    public void add(Object obj){
        add(size, obj);
    }
    public void add(int pos, Object obj) {
        //System.out.println(obj);
        if (pos == 0) {
            Node node = new Node(obj, head);
            head = node;
            ++size;
        } else{
            Node prev = getNode(pos-1);
            Node node = new Node(obj, prev.next);
            prev.next = node;
            ++size;
        }
    }
    public Object get(int pos){
        if(size == 0){
            throw new IllegalArgumentException("Error");
        }
        Node node = head;
        for(int i = 1; i < pos; i++){
            node = node.next;
        }
        return node.data;
    }

    public Node getNode(int pos){
        if(size == 0){
            throw new IllegalArgumentException("Error");
        }
        Node node = head;
        for(int i = 1; i < pos; i++){
            node = node.next;
        }
        return node;
    }

    public Object remove(int pos){
        if(pos < 0 || pos > size){
            throw new IllegalArgumentException("Error");
        }
        if(pos == 0){
            Node curr = head;
            head = head.next;
            size--;
            return curr.data;
        }else {
            Node prev = getNode(pos - 1);
            Node curr = prev.next;
            prev.next = curr.next;
            size--;
            return curr.data;
        }
    }
    public int size(){
        return size;
    }
}
