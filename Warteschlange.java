import java.util.LinkedList;
import java.util.List;

class WSchlange
{
    protected List<Object> list = new LinkedList<>();

    public void add(Object e)
    {
        list.add(e);
    }

    //testen was passiert wenn man eine leere liste hat
    public void removeObject(Object e)
    {
        list.remove(e);
    }

    public void remove()
    {
        list.remove(0);
    }

    //ich schätze mal die soll auch nach dem FIFO Prinzip ausgegeben werden
    public void print()
    {
        System.out.println("Die Elemente der Liste lauten wie folgt: ");
        for(int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }
    }
}

class Schlange <T>
{
    List <T> typeList = new LinkedList<T>();

    public void add(T e)
    {
        typeList.add(e);
    }

    //testen was passiert wenn man eine leere liste hat
    public void remove(T e)
    {
        typeList.remove(0);
    }

    //ich schätze mal die soll auch nach dem FIFO Prinzip ausgegeben werden
    public void print(T e)
    {
        System.out.println("Die Elemente der Liste lauten wie folgt: ");
        for(int i = 0; i < typeList.size(); i++)
        {
            System.out.println(typeList.get(i));
        }
    }
}

public class Warteschlange
{
    public static void main(String[] args)
    {
        WSchlange test1 = new WSchlange();
        test1.add("foo");
        test1.add("bar");
        test1.add(24);
        test1.add(false);
        test1.remove();
        test1.print();


        Schlange <String> test2 = new Schlange<String>();
        test2.add("moin");
        test2.add("Meister");

        Schlange <Integer> test3 = new Schlange<Integer>();
        test3.add(420);
        test3.add(318);
    }
}