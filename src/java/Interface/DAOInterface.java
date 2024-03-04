/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

import java.util.List;
public interface DAOInterface<T> {

    public List<T> getAll();

    public T getById(String id);

    public int insert(T o);

    public int delete(T o);

    public int update(T o);
}
