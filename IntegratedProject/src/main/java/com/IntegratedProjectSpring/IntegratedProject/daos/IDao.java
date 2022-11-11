package com.IntegratedProjectSpring.IntegratedProject.daos;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T> {
    public T create(T t) throws SQLException;
    public T search(int id) throws SQLException;
    public List<T> searchAll() throws SQLException;
    public boolean update(T t);
    public boolean delete(int id);
}
