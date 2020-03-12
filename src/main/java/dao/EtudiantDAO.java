package dao;

import java.util.ArrayList;
import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import model.Etudiant;

@Repository
public class EtudiantDAO implements IEtudiantDAO{

	public boolean saveEtudiant(Etudiant etudiant) {
		try {
			Session session=ConnectionDB.getInstance().getFactory().openSession();
			session.beginTransaction();
			session.saveOrUpdate(etudiant);
			session.getTransaction().commit();
			System.out.println("Etudiant saving succeded");
			return true;
		}
		catch(HibernateException e){
			e.printStackTrace();
			System.out.println("Etudiant saving failed");
			return false;
		}
	}

	public boolean deleteEtudiant(int idEtudiant) {
		try {
			Etudiant etudiant = new Etudiant();
			etudiant.setIdEtudiant(idEtudiant);
			
			Session session=ConnectionDB.getInstance().getFactory().openSession();
			session.beginTransaction();
			session.delete(etudiant);
			session.getTransaction().commit();
			System.out.println("Etudiant deleting succeded");
			return true;
		}
		catch(HibernateException e){
			e.printStackTrace();
			System.out.println("Etudiant deleting failed");
			return false;
		}
	}

	public List<Etudiant> getEtudiants() {
	List<Etudiant> list=new ArrayList<Etudiant>();
		try {
			Session session=ConnectionDB.getInstance().getFactory().openSession();
			session.beginTransaction();
			System.out.println("Etudiants display succeded");
			return list=(ArrayList<Etudiant>) session.createQuery("from Etudiant").list();
		}
		catch(HibernateException e) {
			e.printStackTrace();
			System.out.println("Etudiants display succeded");
			return null;
		}
	}

	public Etudiant getOneEtudiant(int idEtudiant) {
		try {
			Session session=ConnectionDB.getInstance().getFactory().openSession();
			session.beginTransaction();
			Query query =session.createQuery("from Etudiant where idEtudiant= :idEtudiant");
			query.setParameter("idEtudiant", idEtudiant);
			Etudiant etudiant =(Etudiant) query.uniqueResult();
			
			System.out.println("One Etudiant display succeded");
			return etudiant;
		}
		catch(HibernateException e) {
			e.printStackTrace();
			System.out.println("One Etudiant display succeded");
			return null;
		}
	}

}
