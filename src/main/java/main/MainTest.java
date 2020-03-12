package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import model.Etudiant;
import service.IEtudiantService;

public class MainTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("dao");
		context.scan("service");
		context.refresh();
		
		IEtudiantService dao = (IEtudiantService) context.getBean("etudiantService");
		dao.addEtudiant(new Etudiant("Toribio", "Alvaro", 1));
	}

}
