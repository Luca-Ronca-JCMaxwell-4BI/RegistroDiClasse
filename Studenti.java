package registroelettronico;
import java.util.Scanner;

public class Studenti implements java.io.Serializable{
    private String nome;
    private String cognome;
    private String nomeUtente;
    private String password;
    public final String tipoUtente = "Studente";
    private static final int N_VOTI = 19;
    public float[] italiano;
    public float[] storia;
    public float[] inglese;
    public float[] matematica;
    public float[] sistemiReti;
    public float[] TPSIT;
    public float[] informatica;
    public float[] telecomunicazioni;
    public float[] edFisica;
    public float mediaItaliano;
    public float mediaStoria;
    public float mediaInglese;
    public float mediaMatematica;
    public float mediaSistemiReti;
    public float mediaTPSIT;
    public float mediaInformatica;
    public float mediaTelecomunicazioni;
    public float mediaEdFisica;
    public int votiItaliano;
    public int votiStoria;
    public int votiInglese;
    public int votiMatematica;
    public int votiSistemiReti;
    public int votiTPSIT;
    public int votiInformatica;
    public int votiTelecomunicazioni;
    public int votiEdFisica;
    public float mediaTot;
    public String statoStudente;
    //Costruttore
    public Studenti(String nome, String cognome, String nomeUtente, String password){
        setNome(nome);
        setCognome(cognome);
        setNomeUtente(nomeUtente);
        setPassword(password);
        italiano = new float[N_VOTI];
        storia = new float[N_VOTI];
        inglese = new float[N_VOTI];
        matematica = new float[N_VOTI];
        sistemiReti = new float[N_VOTI];
        TPSIT = new float[N_VOTI];
        informatica = new float[N_VOTI];
        telecomunicazioni = new float[N_VOTI];
        edFisica = new float[N_VOTI];
        mediaItaliano = 0;
        mediaStoria = 0;
        mediaInglese = 0;
        mediaMatematica = 0;
        mediaSistemiReti = 0;
        mediaTPSIT = 0;
        mediaInformatica = 0;
        mediaTelecomunicazioni = 0;
        mediaEdFisica = 0;
        votiItaliano = 0;
        votiStoria = 0;
        votiInglese = 0;
        votiMatematica = 0;
        votiSistemiReti = 0;
        votiTPSIT = 0;
        votiInformatica = 0;
        votiTelecomunicazioni = 0;
        votiEdFisica = 0;
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
    public void setPassword(String p){
        password = p;
    }
    public String getPassword(){
        return password;
    }
    //metodi
    public void cambiaPassword(){
        String p;
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserisci la nuova password");
        p = sc.next();
        this.setPassword(p);
        System.out.println("Password cambiata correttamente");
    }
    public float calcolaMediaItaliano(){
        int i;
        float s = 0;
        for(i=0; i<votiItaliano; i++)
        {
            s += italiano[i];
        } 
        mediaItaliano = s / votiItaliano;
        return mediaItaliano;
    }
    public float calcolaMediaStoria(){
        int i;
        float s = 0;
        for(i=0; i<votiStoria; i++)
        {
            s += storia[i];
        } 
        mediaStoria = s / votiStoria;
        return mediaStoria;
    }
    public float calcolaMediaInglese(){
        int i;
        float s = 0;
        for(i=0; i<votiInglese; i++)
        {
            s += inglese[i];
        } 
        mediaItaliano = s / votiItaliano;
        return mediaItaliano;
    }
    public float calcolaMediaMatematica(){
        int i;
        float s = 0;
        for(i=0; i<votiMatematica; i++)
        {
            s += matematica[i];
        }          
        mediaMatematica = s / votiMatematica;
        return mediaMatematica;
    }
    public float calcolaMediaSistemiReti(){
        int i;
        float s = 0;
        for(i=0; i<votiSistemiReti; i++)
        {
            s += sistemiReti[i];
        }          
        mediaSistemiReti = s / votiSistemiReti;
        return mediaSistemiReti;
    }
    public float calcolaMediaTPSIT(){
        int i;
        float s = 0;
        for(i=0; i<votiTPSIT; i++)
        {
            s += TPSIT[i];
        }          
        mediaTPSIT = s / votiTPSIT;
        return mediaTPSIT;
    }
    public float calcolaMediaInformatica(){
        int i;
        float s = 0;
        for(i=0; i<votiInformatica; i++)
        {
            s += matematica[i]; 
        }           
        mediaInformatica = s / votiInformatica;
        return mediaInformatica;
    }
    public float calcolaMediaTelecomunicazioni(){
        int i;
        float s = 0;
        for(i=0; i<votiTelecomunicazioni; i++)
        {
            s += telecomunicazioni[i];
        }          
        mediaTelecomunicazioni = s / votiTelecomunicazioni;
        return mediaTelecomunicazioni;
    }
    public float calcolaMediaEdFisica(){
        int i;
        float s = 0;
        for(i=0; i<votiEdFisica; i++)
        {
            s += edFisica[i];
        }          
        mediaEdFisica = s / votiEdFisica;
        return mediaEdFisica;
    }
    public String calcolaStato(){
        mediaTot = (mediaItaliano + mediaStoria + mediaInglese + mediaMatematica + mediaSistemiReti + mediaTPSIT + mediaInformatica + mediaTelecomunicazioni + mediaEdFisica) / 9;
        if(mediaTot >= 6.0)
        {
            statoStudente = "PROMOSSO";
        }   
        else
        {
            statoStudente = "RISCHIO DI BOCCIATURA";
        }    
        return statoStudente;
    }
    public void visualizzaVoti(){
        int i;
        System.out.println("Italiano");
        for(i=0; i<votiItaliano; i++)
        {
            System.out.println(italiano[i]);
        }
        System.out.println("Storia:");
        for(i=0; i<votiStoria; i++)
        {
            System.out.println(storia[i]);
        }
        System.out.println("Inglese:");
        for(i=0; i<votiInglese; i++)
        {
            System.out.println(inglese[i]);
        }
        System.out.println("Matematica:");
        for(i=0; i<votiMatematica; i++)
        {
            System.out.println(matematica[i]);
        }
        System.out.println("Sistemi e Reti:");
        for(i=0; i<votiSistemiReti; i++)
        {
            System.out.println(sistemiReti[i]);
        }
        System.out.println("TPSIT:");
        for(i=0; i<votiTPSIT; i++)
        {
            System.out.println(TPSIT[i]);
        }
        System.out.println("Informatica:");
        for(i=0; i<votiInformatica; i++)
        {
            System.out.println(informatica[i]);
        }
        System.out.println("Telecomunicazioni:");
        for(i=0; i<votiTelecomunicazioni; i++)
        {
            System.out.println(telecomunicazioni[i]);
        }
        System.out.println("Educazione Fisica:");
        for(i=0; i<votiEdFisica; i++)
        {
            System.out.println(edFisica[i]);
        }
    }
}
