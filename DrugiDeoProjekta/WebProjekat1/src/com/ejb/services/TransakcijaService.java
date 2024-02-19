package com.ejb.services;
import java.util.List;
import java.lang.String;
import java.io.IOException;
import java.util.ArrayList;

import com.jpa.entities.Klijent;
import com.jpa.entities.Transakcija;

public interface TransakcijaService {
	public void dodajTransakciju(int idprimaoca, int idposiljaoca,int iznos,int status);
	public List<Transakcija> listaTransakcija();
	
	
	// probam novo
	//public void dodajTransakciju1(Transakcija t1);
	public void obrisiTransakciju(int id);//radi
   public String checkTransakcija(String ckid) throws IOException;
   public String sendGET(String ckid) throws IOException;


}
