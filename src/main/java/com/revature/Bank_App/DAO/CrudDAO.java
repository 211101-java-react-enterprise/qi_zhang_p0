package com.revature.Bank_App.DAO;

import com.revature.Bank_App.util.List;

public interface CrudDAO<T> {
    T save(T newObj);
    List<T> findAll();
    T findById(String id);
    boolean update(T updatedObj);
    boolean removeById(String id);
}
