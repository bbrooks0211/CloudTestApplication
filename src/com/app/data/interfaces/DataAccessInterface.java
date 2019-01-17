package com.app.data.interfaces;

import java.util.List;

public interface DataAccessInterface<T> {
	public boolean create(T model);
	public T find(T model);
	public T find(int id);
	public T find(String string);
	public List<T> findAll();
	public boolean update(T model);
	public boolean delete(int id);
}
