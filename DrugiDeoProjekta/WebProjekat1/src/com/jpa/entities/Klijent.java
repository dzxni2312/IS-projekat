package com.jpa.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="klijenti")
public class Klijent {
	@TableGenerator(name="klijent_gen",table="id_gen",pkColumnName="gen_name",valueColumnName="gen_val",allocationSize=1,pkColumnValue="klijent_gen")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "klijent_gen")
	private int id;
	
	@Column(name="ime")
	private String ime;
	
	@Column(name="adresa")
	private String adresa;
	
	@Column(name="stanjeracuna")
	private int stanjeracuna;
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id=id;
	}
	
	public String getIme()
	{
		return ime;
	}
	
	public void setIme(String ime)
	{
		this.ime=ime;
	}
	
	public String getAdresa()
	{
		return adresa;
	}
	
	public void setAdresa(String adresa)
	{
		this.adresa=adresa;
	}
	
	public int getStanjeracuna()
	{
		return stanjeracuna;
	}
	
	public void setStanjeracuna(int stanjeracuna)
	{
		this.stanjeracuna=stanjeracuna;
	}

}
