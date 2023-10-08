import java.util.*;

class Node 
{
    char value;
    Node prev;
    Node next;

    Node(char value) 
    {
        this.value = value;
    }
}

class FirstNonRepeatingStream 
{
    private Map<Character, Node> c;
    private Node head;
    private Node tail;

    public FirstNonRepeatingStream()
    {
        c = new HashMap<>();
        head = new Node('-');
        tail = new Node('-');
        head.next = tail;
        tail.prev = head;
    }

    public void add(char ch) 
    {
        if (c.containsKey(ch)) 
        {
            Node node = c.get(ch);
            removeNode(node);
        } 
        else 
        {
            Node temp = new Node(ch);
            c.put(ch,temp);
            insertNode(temp);
        }
    }

    public char getFirstNonRepeating() 
    {
        if (head.next != tail) 
        {
            return head.next.value;
        }
        return '-';
    }

    private void removeNode(Node node) 
    {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        c.remove(node.value);
    }

    private void insertNode(Node node) 
    {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}
public class Q2{
        public static void main(String[] args) {
            FirstNonRepeatingStream stream = new FirstNonRepeatingStream();
    
            stream.add('a');
            stream.add('b');
            stream.add('c');
            stream.add('b');
            stream.add('a');
    
            System.out.println("First non-repeating character: " + stream.getFirstNonRepeating()); // Output: c
    
            stream.add('c');
            stream.add('d');
            stream.add('d');
    
            System.out.println("First non-repeating character: " + stream.getFirstNonRepeating()); // Output: -
        }
}