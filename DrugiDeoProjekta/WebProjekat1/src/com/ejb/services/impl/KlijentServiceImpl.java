package com.ejb.services.impl;

import javax.persistence.EntityManager;
//package com.ejb.services.impl;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.ejb.services.KlijentService;
import com.jpa.entities.Klijent;

@Stateless
public class KlijentServiceImpl implements KlijentService {
	@PersistenceContext(name="WebProjekat1")
	private EntityManager em;
	
	@Override
	public void dodajKlijenta(Klijent kl)
	{
		em.persist(kl);
	}
	
	@Override
	public void obrisiKlijenta(int id)
	{
		Klijent k=em.find(Klijent.class,id);
		em.remove(k);
	}
	
	@Override
	public void nadogradiKlijenta(int id,int novostanjeracuna)
	{
		Klijent k=em.find(Klijent.class, id);
		k.setStanjeracuna(novostanjeracuna);
	}
	
	@Override
	public List<Klijent> listaKlijenata()
	{
		List<Klijent> sviklijenti=em.createQuery("SELECT e FROM Klijent e",Klijent.class).getResultList();
		return sviklijenti;
	}
	
	

}
