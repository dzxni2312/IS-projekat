
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;


@Entity
@Table(name="transakcija")
public class Transakcija {

	@TableGenerator(name="trans_gen",table="id_gen",pkColumnName="gen_name",valueColumnName="gen_val",allocationSize=1,pkColumnValue="trans_gen")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "trans_gen")
	private int id;
	
	
	//ovo su strani kljucevi, ali ih koristimo kao gotove vrednosti, radi pojednostavljenja
	@Column(name="idprimaoca")
	private int idprimaoca;
	
	@Column(name="idposiljaoca")
	private int idposiljaoca;
	
	@Column(name="iznos")
	private int iznos;
	
	@Column(name="status")
	private int status;
	
	@Column(name="komentar")
	private String komentar;
	
	public Transakcija()
	{}
	
	public Transakcija(int idprimaoca,int idposiljaoca,int iznos, int status,String komentar)
	{
		this.idprimaoca=idprimaoca;
		this.idposiljaoca=idposiljaoca;
		this.iznos=iznos;
		this.status=status;
		this.komentar=komentar;
	}
	public Transakcija(int idprimaoca,int idposiljaoca,int iznos, int status)
	{
		this.idprimaoca=idprimaoca;
		this.idposiljaoca=idposiljaoca;
		this.iznos=iznos;
		this.status=status;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id=id;
	}
	
	public int getIdprimaoca()
	{
		return idprimaoca;
	}
	
	public void setIdprimaoca(int idprimaoca)
	{
		this.idprimaoca=idprimaoca;
	}
	
	public int getIdposiljaoca()
	{
		return idposiljaoca;
	}
	
	public void setIdposiljaoca(int idposiljaoca)
	{
		this.idposiljaoca=idposiljaoca;
	}
	
	public int getIznos()
	{
		return iznos;
	}
	
	public void setIznos(int iznos)
	{
		this.iznos=iznos;
	}
	
	public int getStatus()
	{
		return status;
	}
	
	public void setStatus(int status)
	{
		this.status=status;
	}
	
	public String getKomentar()
	{
		return komentar;
	}
	
	public void setKomentar()
	{
		this.komentar=komentar;
	}
	
	
}
