package fr.afcepf.al34.nomads.ws.rest.dao;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.repository.Repository;

import fr.afcepf.al34.nomads.dao.GenericDao;
import fr.afcepf.al34.nomads.entities.global.InsertableIntoDatabase;

public class GenericDaoImpl<T> implements GenericDao<T>, Repository<T, Object> {

	@PersistenceContext()
	protected EntityManager em;

	public T insert(T t) {
		em.persist(t);
		return t;
	}

	public Boolean remove(T t) {
		t = em.merge(t);
		em.remove(t);
		return null;
	}

	public T update(T t) {
		em.merge(t);
		return t;
	}

	@SuppressWarnings("unchecked")
	public T findById(Object o) {
		T t = null;
		try {
			String className = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]
					.getTypeName();
			Class<?> clazz;
			clazz = Class.forName(className);
			t = (T) em.find(clazz, o);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return t;
	}

	public List<Field> getAllFields(List<Field> fields, Class<?> type) {
		fields.addAll(Arrays.asList(type.getDeclaredFields()));

		if (type.getSuperclass() != null) {
			getAllFields(fields, type.getSuperclass());
		}

		return fields;
	}

	public boolean isEntity(Object t) {
		boolean ret=false;
		String entitiesPackage="fr.afcepf.al34.nomads.entities";
		
		if(t.getClass().getPackage().toString().contains(entitiesPackage)) {
			ret=true;
		}
		return ret;
	}
	
	public boolean isList(Class<?> classe) {
		boolean ret=false;
		if(List.class.isAssignableFrom(classe)) {
			ret=true;
		}
		return ret;
	}
	
	public Object deepInsertOrUpdate(Object t) throws IllegalArgumentException, IllegalAccessException {
		
		
		Class<?> metaClass = t.getClass();
		System.out.println("========PARSING CLASS==========" + metaClass.getName());
		if (isEntity(t) ||
				isList(metaClass)
		) {
			
			List<Field> fields=new LinkedList<Field>();
			getAllFields(fields,metaClass);
			
			for (Field field : fields) {
				boolean access = field.isAccessible();
				field.setAccessible(true);

				Object object = field.get(t);
				if (object != null) {

					if (isEntity(object)) {
						System.out.println(">>>>>>deeping : " + object.toString());
						object = deepInsertOrUpdate(object);
						field.set(t, object);
						System.out.println("<<<<<<deeping done : " + object.toString());

					} else if (isList(field.getType())) {
						@SuppressWarnings("unchecked")
						List<Object> list = (List<Object>) field.get(t);
						if (list != null) {
							for (int i = 0; i < list.size(); i++) {

								Object objectInList = list.get(i);
								objectInList = deepInsertOrUpdate(objectInList);
								list.set(i, objectInList);
							}
							field.set(t, list);
						}
					}
				}
				field.setAccessible(access);
			}
			if (isEntity(t)) {
				System.out.println("####################Saving object : " + t.toString());
				if(((InsertableIntoDatabase) t).getId()==null) {
					em.persist(t);
				}else {
					System.err.println("WARNING WE DO AN UPDATE IN DATABASE");
					em.merge(t);
				}
				
				System.out.println("####################Saved object : " + t.toString());
			}
		}
		System.out.println("========END PARSING CLASS==========" + metaClass.getName());
		return t;
	}
}