package org.example.Model;

import java.util.List;

public interface InterfaceDAO {
    public int insert(Empleado obj);
    public int delete(Empleado obj);
    public List<Empleado> getAll();
}
