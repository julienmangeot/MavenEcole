package service;

import java.util.List;

import model.Etudiant;

public interface IEtudiantService {

	public boolean addEtudiant(Etudiant etudiant);
	
	public boolean supEtudiant(int idEtudiant);
	
	public List<Etudiant> showEtudiants();
	
	public Etudiant showOneEtudiant(int idEtudiant);

}
