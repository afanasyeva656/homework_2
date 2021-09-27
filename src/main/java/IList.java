// TODO: назови этот интерфейс по кодстайлу джавы, `CustomList` например
public interface IList<T> {
    void add(T t);
    void add(int index, T t);

    void remove(int index);
    void remove(T t);

    void set(int index, T t);
    int size();
    T get(int index);
}
