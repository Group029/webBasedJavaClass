package assignment;

import java.util.Collection;

public interface IDao<T,K> {
	Collection<T> getAll();
	T getOne(K key);
	void create(T t);
}
