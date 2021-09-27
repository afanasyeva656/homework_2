import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.LinkedList;


public class Main {
    public static void main(String[] args) {
        System.out.println("<-- Реализация LinkedList -->");
        LinkedList<Integer> linkedList = new LinkedList<Integer>();

        Integer a = 1;
        Integer b = 2;

        linkedList.add(a);
        linkedList.add(b);
        linkedList.add(3);
        linkedList.add(0,21);

        linkedList.remove(1);
        linkedList.set(0, 33);

        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println("На позиции " + i + " - " + linkedList.get(i));
        }

        System.out.println("");

        System.out.println("<-- Реализация ArrayList -->");
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(a);
        arrayList.add(b);
        arrayList.add(2, 35);
        arrayList.add(4);

        arrayList.remove(0);
        arrayList.set(0, 22);

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println("На позиции " + i + " - " + arrayList.get(i));
        }

        System.out.println("");

        System.out.println("<-- Реализация myArrayList -->");
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("Маркетинг");
        myArrayList.add("Продажи");
        myArrayList.add("Поддержка");
        myArrayList.add("Бухгалтерия");
        myArrayList.add(4,"Производство");


        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println("На позиции " + i + " - " + myArrayList.get(i));
        }

        myArrayList.remove("Продажи");
        myArrayList.set(0, "Продажи и Маркетинг");
        System.out.println("Удалили Продажи и заменили отдел Маркетинг на Продажи и Маркетинг (по индексу 0)");
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println("На позиции " + i + " - " + myArrayList.get(i));
        }

        try {
            myArrayList.set(21, "Отдел снабжения");
        } catch (IndexOutOfBoundsException error) {
            System.out.println("Выброшена ошибка IndexOutOfBoundsException в myArrayList");
        }

        System.out.println("");

        System.out.println("<-- Реализация myLinkedList -->");
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("Оля");
        myLinkedList.add("Женя");
        myLinkedList.add(1, "Вадим");
        myLinkedList.add("Алина");
        myLinkedList.add("Слава");
        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.println("На позиции " + i + " - " + myLinkedList.get(i));
        }

        myLinkedList.remove(0);
        myLinkedList.remove("Женя");
        System.out.println("Удалили Олю (по индексу 0) и Женю");
        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.println("На позиции " + i + " - " + myLinkedList.get(i));
        }

        myLinkedList.add("Катя");
        myLinkedList.set(2, "Никита");
        System.out.println("Добавили Катю и заменили Славу (по индексу 2) на Никиту");
        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.println("На позиции " + i + " - " + myLinkedList.get(i));
        }

        try {
            myLinkedList.set(21, "Артем");
        } catch (IndexOutOfBoundsException error) {
            System.out.println("Выброшена ошибка IndexOutOfBoundsException в myLinkedList");
        }
    }
}
