package com.mastertheboss.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.mastertheboss.domain.Employee_old;
import com.mastertheboss.domain.DepartmentOld;

public class JpaTest {

	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistenceUnit");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			test.createEmployees();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		test.listEmployees();

		System.out.println(".. done");
	}




	private void createEmployees() {
		int numOfEmployees = manager.createQuery("Select a From Employee a", Employee_old.class).getResultList().size();
		//if (numOfEmployees == 0) {
			DepartmentOld department = new DepartmentOld("java="+numOfEmployees);
			manager.persist(department);

			manager.persist(new Employee_old("Jakab Gipsz="+numOfEmployees,department));
			manager.persist(new Employee_old("Captain Nemo="+numOfEmployees,department));

		//}
	}


	private void listEmployees() {
		List<Employee_old> resultList = manager.createQuery("Select a From Employee a", Employee_old.class).getResultList();
		System.out.println("num of employess:" + resultList.size());
		for (Employee_old next : resultList) {
			System.out.println("next employee: " + next);
		}
	}


}
