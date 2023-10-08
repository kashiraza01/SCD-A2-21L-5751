import java.util.*;

class Node<T> 
{
    protected T data;
    Node<T> next;

    public Node(T data) 
    {
        this.data = data;
    }

    public T getData() 
    {
        return data;
    }

    public void setData(T data) 
    {
        this.data = data;
    }
}

class GenericStack<T> 
{
    private Node<T> head;
    private int size;

    public void push(T item) 
    {
        Node<T> newNode = new Node<>(item);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public boolean isEmpty() 
    {
        return head == null;
    }

    public T pop() throws EmptyStackException 
    {
        if (isEmpty()) 
        {
            throw new EmptyStackException();
        }
        T item = head.getData();
        head = head.next;
        size--;
        return item;
    }

    public int size() 
    {
        return size;
    }

    public void display() 
    {
        Node<T> current = head;
        for (current = head; current != null; current = current.next) 
        {
            System.out.print(current.data + " ");
        }
        System.out.println();
    }
}

public class Q1 
{
    public static <T> void Menu(GenericStack<T> obj) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWhat Stack Operation to perform:\n1) Pop \n2) Size \n3) IsEmpty \n4) Quit");
        while (true) 
        {
            int n = scanner.nextInt();
            if (n == 1) 
            {
                try 
                {
                    System.out.println("Popped item: " + obj.pop());
                } 
                catch (EmptyStackException e) 
                {
                    System.out.println("Error: " + e.getMessage());
                }
            } 
            else if (n == 2) 
            {
                System.out.println("Size of stack: " + obj.size());
            } 
            else if (n == 3) 
            {
                System.out.println("Is stack empty? " + obj.isEmpty());
            } 
            else if (n == 4) 
            {
                break;
            } 
            else 
            {
                System.out.println("Invalid n");
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Stack Size: ");
        int stackSize = scanner.nextInt();
        System.out.println("Select Data Type :\n1) Integer \n2) Float \n3) String");
        int a = scanner.nextInt();
        if (a == 1) {
            GenericStack<Integer> obj = new GenericStack<>();
            System.out.println("Enter Stack Values:");
            for (int i = 0; i < stackSize; i++) 
            {
                int value = scanner.nextInt();
                obj.push(value);
            }
            Menu(obj);
        } 
        else if (a == 2) 
        {
            GenericStack<Float> obj = new GenericStack<>();
            System.out.println("Enter Stack Values:");
            for (int i = 0; i < stackSize; i++) 
            {
                float value = scanner.nextFloat();
                obj.push(value);
            }
            Menu(obj);
        }
        else if(a == 3)
        {
            GenericStack<String> obj = new GenericStack<>();
            System.out.println("Enter Stack Values:");
            for (int i = 0; i < stackSize; i++) 
            {
                String value = scanner.next();
                obj.push(value);
            }
            Menu(obj);
        }
        else
        {
            System.out.println("Wrong Option");
        }

        scanner.close();
    }
}