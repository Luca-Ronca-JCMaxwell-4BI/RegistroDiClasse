package registroelettronico;
import java.util.Scanner; /*Importa la classe Scanner la quale è nella cartella UTIL che è dentro la cartella JAVA.  
                          Scanner : classe predefinita per prendere input dagli utenti*/

public class Professori { 
    //Attributi della classe professori
    private String nome; 
    private String cognome;
    private String nomeUtente;
    private String password;
    private String materia;
    public final String tipoUtente = "Professore";
    //Costruttore
    public Professori(String nome, String cognome, String nomeUtente, String password, String materia){
        setNome(nome);
        setCognome(cognome);
        setNomeUtente(nomeUtente);
        setPassword(password);
        setMateria(materia);
    }
    //Setter/Getter
    private void setNome(String n){
        nome = n;  
    }
    public String getNome(){
        return nome;
    }
    private void setCognome(String c){
        cognome = c;
    }
    public String getCognome(){
        return cognome;
    }
    private void setNomeUtente(String nu){
        nomeUtente = nu;
    }
    public String getNomeUtente(){
        return nomeUtente;
    }
    private void setPassword(String p){
        password = p;
    }
    public String getPassword(){
        return password;
    }
    private void setMateria(String m){
        materia = m;
    }
    public String getMateria(){
        return materia;
    }
    //metodi aggiungi voto togli voto
}
