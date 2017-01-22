package registroelettronico;
import java.util.Scanner;

public class Admin {
    private String nomeUtente = "Admin";
    private String password;
    public final String tipoUtente = "Admin";
    public static final int N_STUDENTI = 24;
    public Studenti[] classe;
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
