
import java.util.ArrayList;

import java.io.IOException;
//package com.ejb.services.impl;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
//import com.ejb.services.TransakcijaService;
//import com.jpa.entities.Transakcija;
//import com.jpa.entities.Klijent;
//import com.ejb.services.KlijentService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.persistence.TypedQuery;
import java.nio.*;


@Stateless
public class TransakcijaServiceImpl implements TransakcijaService {
	//@PersistenceContext(name="WebProjekat1")
	private EntityManager em;
	
	public TransakcijaServiceImpl()
	{
		   EntityManagerFactory emf = Persistence
	               .createEntityManagerFactory("KlijentPU");
	       em = emf.createEntityManager();
	}
	
	@Override
	public void dodajTransakciju(int idprimaoca, int idposiljaoca,int iznos,int status)
	{
		try {
		//int prid=Integer.parseInt(primaocid);
		//int poid=Integer.parseInt(posiljaocid);
		//int i=Integer.parseInt(iznos);
		//int status; 
			
		//pribavlja se tako sto zovemo f-ju checkTransakcija(ckid);	
		String idprimaoca1=Integer.toString(idprimaoca);
		String komentar=this.checkTransakcija(idprimaoca1);
		int ckid=idprimaoca;
		//Transakcija t2=new Transakcija(ckid,idposiljaoca,iznos,status,komentar);
		//em.persist(t2);
			
		
		//pribavljamo klijenta koji je primaoc na osnovu id-a, objekat entitetskog tipa
		Klijent k1=em.find(Klijent.class, idprimaoca);
		
		//pribavljamo i posiljaoca
		Klijent k2=em.find(Klijent.class,idposiljaoca);
		
		int bla=k2.getStanjeracuna();
		//System.out.println(bla);
		int stanje=k2.getStanjeracuna()-iznos;
		int stanje1=k1.getStanjeracuna()+iznos;
		//System.out.println(stanje1);
		//System.out.println(stanje);
		//System.out.println(iznos);
		//uslov da bi se obavila transakcija je da posiljaoc ima dovoljno novca i da status potvrde bude tacan
		if(stanje>=0 && status==1)
		{
			//ima dovoljno novca za transfer
			Transakcija t1=new Transakcija(idprimaoca,idposiljaoca,iznos,status,komentar);
			em.persist(t1);
			
			//posiljaocu se smanjuje novac i sada ima ovoliko:
			k2.setStanjeracuna(stanje); //dobro je
			
			
			//int stanje1=k1.getStanjeracuna()+iznos;
			//primaocu se povecava prethodno stanje racuna sto je imao 
			//int novac=k1.getStanjeracuna();
			//novac+=iznos;
			k1.setStanjeracuna(stanje1);
			
		}
		else {
			//OVDE DA UBACIM KAO PORUKU KOJU CE DA VRATI MOJA STRANICA
			//ovde je samo da u consoli se izbaci
			System.out.println("Posiljaoc nema dovoljno novca da bi se izvrsio transfer.");
		}
		 } catch(Exception ex) {
				
				System.out.println("Greska prilikom rada sa bazom: \n" + ex.getMessage());
				
				}  
		}
	
	/*@Override
	public void dodajTransakciju1(Transakcija t1)
	{
		em.persist(t1);
	}*/
	
	@Override
	public void obrisiTransakciju(int id)
	{
		Transakcija t=em.find(Transakcija.class,id);
		em.remove(t);
	}
	@Override
	public List<Transakcija> listaTransakcija()
	{
		List<Transakcija> svetransakcije=em.createQuery("SELECT e FROM Transakcija e",Transakcija.class).getResultList();
		return svetransakcije;
	}
	
	//OVO JE ONO ZA DOCKER dodato
	private static final String USER_AGENT = "Mozilla/5.0";
	@Override
    public String checkTransakcija(String ckid) throws IOException
    {
		String res="";
		try {
		return sendGET(ckid);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return res;
	}
    }
	public String sendGET(String ckid) throws IOException {
		String res="";
		URL obj = new URL("http://192.168.99.100/?ckid="+ckid);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());
			return response.toString();
		} else {
			res="";
			System.out.println("GET request not worked");
			return res;
		}

	}
	


}

