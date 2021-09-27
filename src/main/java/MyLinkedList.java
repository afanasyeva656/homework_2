public class MyLinkedList<T> implements IList{

    private int size = 0;
    private Node first;
    private Node last;

// Каждый элемент списка - нода, которая содержит ссылку на пред. и след. значения
    private static class Node {
        Node prev;
        Node next;
        Object element;

        public Node(Node prev, Object element, Node next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }
    }

// Добавляет элемент в конец LinkedList. У прошлого последнего элемента заменяется ссылка next с null на newNode
    @Override
    public void add(Object o) {
        Node newNode;
        if (first == null) {
            newNode = new Node(null, o, null);
            newNode.next = null;
            newNode.prev = null;
            first = newNode;
        } else {
            newNode = new Node(last, o, null);
            last.next = newNode;
        }
        last = newNode;
        size++;
    }


// Добавляет элемент на заданный индекса LinkedList, если такой существует.
// У элементов до и после меняются ссылки next и prev соответственно на newNode
    @Override
    public void add(int index, Object o) {
        if (index < 0 || index > size) { throw new IndexOutOfBoundsException(); }
        if (index == 0) { add(o); }
        if (index == size) {
            Node newNode = new Node(last, o, null);
            last.next = newNode;
            last = newNode;
        } else {
            Node oldNode = first;
            for (int i = 0; i < index; i++) {
                oldNode = oldNode.next;
            }
            Node oldPrevious = oldNode.prev;
            Node newNode = new Node(oldPrevious, o, oldNode);
            oldPrevious.next = newNode;
            oldNode.prev = newNode;
        }
        size++;
    }

// Удаляет элемент на заданной позиции, если такой индекс существует.
// Также меняет ссылки у nodeBefore и nodeAfter
    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            first = first.next;
        } else {
            Node nodeForDelete = findNodeByIndex(index);
            if (nodeForDelete == null) { throw  new IndexOutOfBoundsException();}
            Node nodeBefore = nodeForDelete.prev;
            Node nodeAfter = nodeForDelete.next;

            nodeBefore.next = nodeAfter;
            nodeAfter.prev = nodeBefore;
        }
        size--;
    }

// Удаляет элемент, если такой элемент существует.
// Также меняет ссылки у nodeBefore и nodeAfter
    @Override
    public void remove(Object o) {
        if (first.element == o) {
            first.next = first;
        } else {
            Node nodeForDelete = findNode(o);
            if (nodeForDelete != null) {
                Node nodeBefore = nodeForDelete.prev;
                Node nodeAfter = nodeForDelete.next;

                nodeBefore.next = nodeAfter;
                nodeAfter.prev = nodeBefore;
            }
        }
        size--;
    }

// Заменяет элемент на указанной позиции на новый, если элемент с таким индексом существует.
    @Override
    public void set(int index, Object o) {
        if (index >= 0 && index < size) {
            Node node = findNodeByIndex(index);
            if (node!= null) {
                node.element = o;
            } else {
                throw new IndexOutOfBoundsException();
            }
        }
        else { throw new IndexOutOfBoundsException(); }
    }

    @Override
    public int size() { return size; }

    @Override
    public Object get(int index) {
        if (index >= 0 && index < size) {
            Node result = first;
            for (int i = 0; i < index; i++) {
                result = result.next;
            }
            return result.element;
        } else { throw new IndexOutOfBoundsException(); }
    }

    private Node findNodeByIndex(int index) {
        if (index < 0 || index >= size) { throw new IndexOutOfBoundsException(); }

        int indexCount = 0;
        if (first == null) { return null; }
        if (index == 0) { return first; }

        Node node = first;
        while (node.next != null) {
            node = node.next;
            indexCount++;
            if (indexCount == index) {
                return node;
            }
        }
        throw new IndexOutOfBoundsException();
    }


    private Node findNode(Object value) {
        if (first.element == value) {
            return first;
        }

        Node node = first;
        while (node.next != null) {
            if (node.element == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }
}
