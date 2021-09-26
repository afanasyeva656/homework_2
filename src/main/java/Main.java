import java.util.ArrayList;
import java.util.LinkedList;

// Операции удаления, добавления, поиска внутри каждой из структур
// Написать собственную реализацию каждого из них через интерфейсы

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        Integer a = 1;
        Integer b = 2;

        linkedList.add(a);
        linkedList.add(b);

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(a);
        arrayList.add(b);
        arrayList.add(0, 35);

        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
