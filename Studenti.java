package registroelettronico;
import java.util.Scanner;

public class Studenti {
    private String nome;
    private String cognome;
    private String nomeUtente;
    private String password;
    public final String tipoUtente = "Studente";
    private static final int N_VOTI = 19;
    public double[] matematica;
    public double[] italiano;
    public double[] informatica;
    public double mediaMatematica;
    public double mediaItaliano;
    public double mediaInformatica;
    public int votiMatematica;
    public int votiItaliano;
    public int votiInformatica;
    public double mediaTot;
    public String statoStudente;
    //Costruttore
    public Studenti(String nome, String cognome, String nomeUtente, String password){
        setNome(nome);
        setCognome(cognome);
        setNomeUtente(nomeUtente);
        setPassword(password);
        matematica = new double[N_VOTI];
        italiano = new double[N_VOTI];
        informatica = new double[N_VOTI];
        mediaMatematica = 0.;
        mediaItaliano = 0.;
        mediaInformatica = 0.;
        votiMatematica = 0;
        votiItaliano = 0;
        votiInformatica = 0;
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
    //metodi
}
