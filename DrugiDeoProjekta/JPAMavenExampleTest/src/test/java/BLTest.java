

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;

public class BLTest {

   @Test
   public void testAssertions() 
   {
	   
	  /* KlijentServiceImpl service=new KlijentServiceImpl();
	   List<Klijent> klijenti=service.listaKlijenata();
	   assertNotNull(klijenti);*/
	   
	 
	   TransakcijaServiceImpl service=new TransakcijaServiceImpl();
	   List<Transakcija> transakcije=service.listaTransakcija();
	   assertNotNull(transakcije);
	   
   }
   
   
}

