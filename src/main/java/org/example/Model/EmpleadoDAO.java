package org.example.Model;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO implements InterfaceDAO {
    private Session sesion;

    public EmpleadoDAO() {
        //this.con = GestionBD.getConexion();
        this.sesion = HibernateUtil.getSession();
    }

    @Override
    public int insert(Empleado obj) {

        sesion = HibernateUtil.getSession();
        sesion.beginTransaction();
        sesion.persist(obj);
        sesion.getTransaction().commit();
        sesion.close();


            return 0;


    }

    @Override
    public int delete(Empleado obj) {
        sesion = HibernateUtil.getSession();
        sesion.beginTransaction();
        sesion.remove(obj);
        sesion.getTransaction().commit();
        sesion.close();
        return 0;



    }

    @Override
    public List<Empleado> getAll() {
        sesion = HibernateUtil.getSession();
        sesion.beginTransaction();
        Query<Empleado> query = sesion.createQuery("FROM Empleado", Empleado.class);
        List<Empleado> listaClientes = query.list();
        sesion.getTransaction().commit();
        sesion.close();
        return listaClientes;



    }
}
