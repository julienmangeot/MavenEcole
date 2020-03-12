package dao;

import java.util.List;

import model.Etudiant;

public interface IEtudiantDAO {
	
	public boolean saveEtudiant(Etudiant etudiant);
	
	public boolean deleteEtudiant(int idEtudiant);
	
	public List<Etudiant> getEtudiants();
	
	public Etudiant getOneEtudiant(int idEtudiant);

}
