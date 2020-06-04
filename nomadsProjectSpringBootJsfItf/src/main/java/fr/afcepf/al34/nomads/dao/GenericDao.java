package fr.afcepf.al34.nomads.dao;

public interface GenericDao<T> {

	T insert(T t);
	Boolean remove(T t);
	T update(T t);
	T findById(Object o);
	/*
	 * Methode Sami
	 */
	Object deepInsertOrUpdate(Object t) throws IllegalArgumentException, IllegalAccessException;
}
