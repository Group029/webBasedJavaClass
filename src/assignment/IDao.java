package assignment;

import java.util.Collection;

public interface IDao<T,K,B> {
	Collection<T> getAll();
	T getOne(K key);
	void create(T t);
	Collection<T> getSpecficCustomer(B key);
	void upadte(T t);
	
}
