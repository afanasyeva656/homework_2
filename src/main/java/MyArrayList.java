public class MyArrayList<T> implements IList{

    private Object[] array = new Object[10];
    private int size = 0;

    // Добавляет элемент в ArrayList. Если размер равен числу слотов array, то число слотов в array увеличивается
    @Override
    public void add(Object o) {
        array[size] = o;
        size++;

        if (size == array.length) { grow(); }
    }

    // Добавляет элемент на заданный индекса ArrayList, если такой существует.
    // Если размер равен числу слотов array, то число слотов в array увеличивается
    @Override
    public void add(int index, Object o) {
        if (index == size) { add(o); }
        else if (index >= 0 && index < size) {
            Object[] tempArray = new Object[size + 1];
            int i = 0;

            for (int j = 0; j < tempArray.length; j++) {
                if (j == index) {
                    tempArray[j] = o;
                } else {
                    tempArray[j] = array[i];
                    i++;
                }
            }

            array = tempArray;
            size++;

            if (size >= array.length) { grow(); }
        }
        else { throw new IndexOutOfBoundsException(); }
    }

    // Удаляет элемент на заданной позиции, если такой индекс существует.
    @Override
    public void remove(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            size--;
        } else { throw new IndexOutOfBoundsException(); }
    }

    // Удаляет элемент, если такой элемент существует.
    // При отсутствии элемента ошибку не выбрасывает
    @Override
    public void remove(Object o) {
        for (int i = 0; i < array.length; i++) {
            if (o.equals(array[i])) {
                remove(i);
                size--;
                break;
            }
        }
    }

    // Заменяет элемент на указанной позиции на новый, если элемент с таким индексом существует.
    @Override
    public void set(int index, Object o) {
        if (index >= 0 && index < size) {
            array[index] = o;
        } else { throw new IndexOutOfBoundsException(); }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int index) {
        if (index >= 0 && index < size) {
            return array[index];
        } else { throw new IndexOutOfBoundsException(); }
    }

    private void grow() {
        Object[] tempArray = new Object[array.length + array.length / 2];
        for (int i = 0; i < array.length; i++) {
            tempArray[i] = array[i];
        }
        array = tempArray;
    }
}
