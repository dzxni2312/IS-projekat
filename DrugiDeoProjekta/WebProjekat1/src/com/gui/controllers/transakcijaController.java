package com.gui.controllers;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.ejb.services.KlijentService;
import com.ejb.services.TransakcijaService;
import com.jpa.entities.Klijent;
import com.jpa.entities.Transakcija;
import java.lang.String;

import java.util.ArrayList;

import java.io.IOException;
//package com.ejb.services.impl;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.persistence.TypedQuery;
import java.nio.*;


@ManagedBean
public class transakcijaController {

	private int idprimaocanovo=0;
	private int idposiljaocanovo=0;
	private int iznosnovo=0;
	private int statusnovo=0;
	private Klijent klijent=new Klijent();
	//private Klijent klijent1=new Klijent();
	private Transakcija transakcija=new Transakcija();
	private String komentar="";
	
	//ovo je id za brisanje i inicijalno je 0
		private int idbrisanje=0;
	
	//ubrizgava kontekst u nasu managed bean klasu
		//managed bean klasa mora da ima getere i setere za svoje podatke
		@EJB
		private TransakcijaService service;
		/*public Transakcija getTransakcija() {
			return transakcija;
		}
		public void setTransakcija(Transakcija transakcija) {
			this.transakcija = transakcija;
		}*/
		
		public Klijent getKlijent() {
			return klijent;
		}
		public void setKlijent(Klijent klijent) {
			this.klijent = klijent;
		}
		
		//public Klijent getKlijent() {
			//return klijent1;
		//}
		//public void setKlijent(Klijent klijent1) {
			//this.klijent1 = klijent1;
		//}
		
		public int getIdbrisanje()
		{
			return idbrisanje;
		}
		
		public void setIdbrisanje(int idbrisanje)
		{
			this.idbrisanje=idbrisanje;
		}
		//OVDE DODAJEM GETERE I SETERE!!!
		public int getIdprimaocanovo()
		{
			return idprimaocanovo;
		}
		
		public void setIdprimaocanovo(int idprimaocanovo)
		{
			this.idprimaocanovo=idprimaocanovo;
		}
		
		public int getIdposiljaocanovo()
		{
			return idposiljaocanovo;
		}
		
		public void setIdposiljaocanovo(int idposiljaocanovo)
		{
			this.idposiljaocanovo=idposiljaocanovo;
		}
		
		public int getIznosnovo()
		{
			return iznosnovo;
		}
		
		public void setIznosnovo(int iznosnovo)
		{
			this.iznosnovo=iznosnovo;
		}
		
		public int getStatusnovo()
		{
			return statusnovo;
		}
		
		public void setStatusnovo(int statusnovo)
		{
			this.statusnovo=statusnovo;
		}
		
		public String getKomentar()
		{
			return komentar;
		}
		
		public void setKomentar()
		{
			this.komentar=komentar;
		}
	/*	public void saveTransakcija(Transakcija tl) {
			service.dodajTransakciju1(tl);
		}*/
		
		//f-je koje cemo pozivati
		public void dodajTransakcija(int idprimaocanovo,int idposiljaocanovo,int iznosnovo,int statusnovo)
		{
			service.dodajTransakciju(idprimaocanovo, idposiljaocanovo, iznosnovo, statusnovo);
		}
		
		//da se izlistaju sve transakcije
		public List<Transakcija> listTransakcija(){
	   		List<Transakcija> svetransakcije=service.listaTransakcija();
	   		return svetransakcije;
		}
		
		public void removeTransakcija(int id) {
			service.obrisiTransakciju(id);
		}
		
	
}
