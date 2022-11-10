package daos;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T> {
    public T crear(T t) throws SQLException;
    public T buscar(int id) throws SQLException;
    public List<T> buscarTodos() throws SQLException;
    public boolean actualizar(T t);
    public boolean borrar(int id);
}
