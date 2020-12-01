package com.training.ifaces;
import java.util.*;
public interface DataAccess<T> {
	public boolean add(T t);
	public List<T> findAll();
	public boolean remove(T t);
	public int update(int key,T t);
	public T findById(int key);

}
