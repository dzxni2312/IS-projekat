package com.gui.controllers;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import com.ejb.services.KlijentService;
import com.jpa.entities.Klijent;
import java.lang.String;

@ManagedBean
//oznacili smo da je to model koji cemo koristiti u nekoj od nasih stranica
public class klijentController {

	//ovo su podaci u modelu koje cuvamo
	
	//ovo je id za brisanje i inicijalno je 0
	private int id=0;
	//za samog zaposlenog kojeg unosimo imamo kreiranje objekta koji je entitenog tipa
	private Klijent klijent=new Klijent();
	//ovo je id za klijenta ciju platu menjamo
	private int sid=0;
	private int novostanjeracuna=0;
	
	
	//ubrizgava kontekst u nasu managed bean klasu
	//managed bean klasa mora da ima getere i setere za svoje podatke
	@EJB
	private KlijentService service;
	public Klijent getKlijent() {
		return klijent;
	}
	public void setKlijent(Klijent klijent) {
		this.klijent = klijent;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	
	public int getNovostanjeracuna() {
		return novostanjeracuna;
	}
	public void setNovostanjeracuna(int novostanjeracuna) {
		this.novostanjeracuna = novostanjeracuna;
	}
	
	
	
	//f-je koje cemo pozivati
	//nad nasim servisom poziva f-ju dodajKlijenta
	public void saveKlijent(Klijent kl) {
		service.dodajKlijenta(kl);
	}
	
	public void removeKlijent(int id) {
		service.obrisiKlijenta(id);
	}
	
	public void updateKlijent(int id, int novostanjeracuna) {
		service.nadogradiKlijenta(id, novostanjeracuna);
	}
	
	public List<Klijent> listKlijenata(){
   		List<Klijent> sviklijenti=service.listaKlijenata();
   		return sviklijenti;
   	}
	
	
}
