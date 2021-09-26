public class MyArrayList<T> implements IList<T>{
    private Object[] array = new Object[10];
    private int size = 0;

    @Override
    public void add(T t) {
        array[size] = t;
        size++;

        if (size >= array.length) {
            grow();
        }

    }

    @Override
    public void add(int index, T t) {
        if (index >= 0 && index < size) {
            Object[] tempArray = new Object[size + 1];
            int i = 0;

            for (int j = 0; j < tempArray.length; j++) {
                if (j == index) {
                    tempArray[j] = t;
                } else {
                    tempArray[j] = array[i];
                    i++;
                }
            }

            array = tempArray;
            size++;

            if (size >= array.length) { grow(); }
        }
    }


    @Override
    public void remove(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            size--;
        }
    }

    @Override
    public void remove(T t) {
        for (int i = 0; i < array.length; i++) {
            if (t.equals(array[i])) {
                remove(i);
                break;
            }
        }
    }

    @Override
    public void set(int index, T t) {
        if (index >= 0 && index < size) {
            array[index] = t;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        if (index >= 0 && index < size) {
            return (T) array[index];
        } else {
            return null;
        }
    }

    private void grow() {
        Object[] tempArray = new Object[array.length + array.length / 2];
        for (int i = 0; i < array.length; i++) {
            tempArray[i] = array[i];
        }
        array = tempArray;
    }
}
