

import java.util.List;

//import Klijent;

public interface KlijentService {

	public void dodajKlijenta(Klijent kl);
	public void obrisiKlijenta(int id);
	public void nadogradiKlijenta(int id,int novostanjeracuna);
	public List<Klijent> listaKlijenata();
}
