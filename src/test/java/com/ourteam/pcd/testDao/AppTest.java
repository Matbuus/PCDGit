package com.ourteam.pcd.testDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.ourteam.pcd.services.CompteService;
import com.ourteam.pcd.services.EtudiantService;
import com.ourteam.pcd.configurations.PcdConfig;
import com.ourteam.pcd.entities.Compte;
import com.ourteam.pcd.entities.Etudiant;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PcdConfig.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class,
		TransactionDbUnitTestExecutionListener.class })

public class AppTest {

	@Autowired
	private EtudiantService etudiantService;
	
	@Autowired 
	private CompteService compteService;
	
	
	@Test
	public void saveCompteAndEtudiant()  {
		Compte c =new Compte("pcd@pcd.com","PCD");
		compteService.saveAndFlush(c);
		etudiantService.saveAndFlush(new Etudiant("II000000",c,"PCDTEST","PCDTEST","12345678"));
		
	}

	
}