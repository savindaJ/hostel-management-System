package lk.ijse.d24hostalmng.bo;

import java.util.List;

public interface CrudBO <T,J> extends SuperBO{

    boolean save(T t);

    boolean update(T t);

    boolean delete(J j);

    T find(J j);

    List<T> getAll();

}
