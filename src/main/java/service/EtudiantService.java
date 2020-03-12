package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IEtudiantDAO;
import model.Etudiant;

@Service
public class EtudiantService implements IEtudiantService{
	
	@Autowired
	private IEtudiantDAO dao;

	public boolean addEtudiant(Etudiant etudiant) {
		return dao.saveEtudiant(etudiant);
	}

	public boolean supEtudiant(int idEtudiant) {
		return dao.deleteEtudiant(idEtudiant);
	}

	public List<Etudiant> showEtudiants() {
		return dao.getEtudiants();
	}

	public Etudiant showOneEtudiant(int idEtudiant) {
		return dao.getOneEtudiant(idEtudiant);
	}

}
