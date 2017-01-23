package registroelettronico;
import java.util.Scanner; /*importa la classe Scanner la quale è nella cartella UTIL che è dentro la cartella JAVA.  
                          Scanner : classe predefinita per prendere input dagli utenti*/
public class Admin {
    private String nomeUtente = "Admin";
    private String password;
    public final String tipoUtente = "Admin";
    public static final int N_STUDENTI = 24;
    public Studenti[] classe; //vettore che contiene gli oggetti di tipo Studenti
    public int nStudenti;
    //Costruttore
    public Admin(String password){
        setPassword(password);
    }
    //Setter/Getter
    public void setPassword(String p){
        password = p;
    }
    public String getPassword(){
        return password;
    }
    //Metodi
}
