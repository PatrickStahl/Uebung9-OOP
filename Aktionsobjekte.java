import java.util.*;
import java.util.List;

interface actionObject
{
    public void actionA(Node n);
    public void actionB(Node n);
}
    
class Node
{
    public Object data;
    public Node next;

    Node(Object data)
    {
        this.data = data;
        this.next = null;
    }
}

class ListTest<T> implements actionObject
{
    protected Node head;
    //für a)
    protected boolean exists = false;
    //für b)
    protected int sum = 0;
    //damit createNodeList nicht bei jedem Aufruf neue Knoten erstellt 
    protected int listSize = 0;

    public void actionA(Node n)
    {
        if(n.data instanceof Integer == true)
        {
            
            if((Integer)n.data == 0)
            {
                exists = true;
            }
        }
    }

    public void actionB(Node n)
    {
        if(n.data instanceof Integer == true)
        {
            if((Integer) n.data > 0)
            {
                sum += (Integer) n.data;
            }
        }
    }

    public void createNodeList(List list)
    {
        if(listSize < list.size())
        {
            for(int i = 0; i<list.size(); i++)
            {
                Node newNode = new Node(list.get(i));
                if(this.head == null)
                {
                    this.head = newNode; 
                }
                else
                {
                    Node last = this.head;
                    while(last.next!=null)
                    {
                        last = last.next;
                    }
                    last.next = newNode;
                }
                listSize += 1;
            }
        }
    }

    public void showContainsZero(List list)
    {
        createNodeList(list);
        
        for(Node current = head; current != null; current = current.next)
        {
            actionA(current);
            
        }
        if(exists == true)
        {
            System.out.println("Die Integer-Zahl 0 kommt in der Liste vor!");
        }
        else
        {
            System.out.println("Die Integer-Zahl 0 kommt nicht in der Liste vor!");
        }
    }

    public void showPosSum(List list)
    {
        createNodeList(list);

        for(Node current = head; current!= null; current = current.next)
        {
            actionB(current);
        }
        System.out.println("Die Summe der positiven Integer-Zahlen beträgt: " + sum);
    }
}

public class Aktionsobjekte
{
    public static void main(String[] args) 
    {
        List<Object> list1 = Arrays.asList(new Object[]{0,"foo",20, 44, 8.8});
        ListTest<Object> test1 = new ListTest<Object>();
        test1.showContainsZero(list1);
        test1.showPosSum(list1);
    }
}