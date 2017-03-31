package registroelettronico;
import java.util.Scanner;

public class Professori implements java.io.Serializable{ 
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
    //metodi
    public void cambiaPassword(){
        String p;
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserisci la nuova password");
        p = sc.next();
        this.setPassword(p);
        System.out.println("Password cambiata correttamente");
    }
    public void visualizzaRegistro(Admin admin){
        int i, pos;
        for(i=0; i<admin.nStudenti; i++)
        {
            pos = i + 1;
            System.out.println(pos + " - " + admin.classe[i].getCognome() + " " + admin.classe[i].getNome());
        }
    }
    public void aggiungiVoto(Admin admin){
        int i = 0, iStudente;
        float voto;
        visualizzaRegistro(admin);
        Scanner sc = new Scanner(System.in);
        switch(this.getMateria())
        {
            case "Italiano":
                System.out.println("Inserire il numero corrispondente allo studente");
                iStudente = sc.nextInt();
                iStudente --;
                do
                {
                    if(i == iStudente)
                    {

                        System.out.println("Inserisci un voto");
                        voto = sc.nextFloat();
                        admin.classe[i].italiano[admin.classe[i].votiItaliano] = voto;
                        admin.classe[i].votiItaliano ++;
                        admin.classe[i].calcolaMediaItaliano();
                        admin.classe[i].calcolaStato();             
                    }
                    i++;
                }
                while(i<admin.getNStudenti() || i == iStudente);
                if(admin.classe[iStudente] == null)
                {
                    System.out.println("Studente inesistente");
                }
                break;
            case "Storia":
                System.out.println("Inserire il numero corrispondente allo studente");
                iStudente = sc.nextInt();
                iStudente --;
                do
                {
                    if(i == iStudente)
                    {

                        System.out.println("Inserisci un voto");
                        voto = sc.nextFloat();
                        admin.classe[i].storia[admin.classe[i].votiStoria] = voto;
                        admin.classe[i].votiStoria ++;
                        admin.classe[i].calcolaMediaStoria();
                        admin.classe[i].calcolaStato();             
                    }
                    i++;
                }
                while(i<admin.getNStudenti() || i == iStudente);
                if(admin.classe[iStudente] == null)
                {
                    System.out.println("Studente inesistente");
                }
                break;
            case "Inglese":
                System.out.println("Inserire il numero corrispondente allo studente");
                iStudente = sc.nextInt();
                iStudente --;
                do
                {
                    if(i == iStudente)
                    {

                        System.out.println("Inserisci un voto");
                        voto = sc.nextFloat();
                        admin.classe[i].inglese[admin.classe[i].votiInglese] = voto;
                        admin.classe[i].votiInglese ++;
                        admin.classe[i].calcolaMediaInglese();
                        admin.classe[i].calcolaStato();             
                    }
                    i++;
                }
                while(i<admin.getNStudenti() || i == iStudente);
                if(admin.classe[iStudente] == null)
                {
                    System.out.println("Studente inesistente");
                }
                break;
            case "Matematica": 
                System.out.println("Inserire il numero corrispondente allo studente");
                iStudente = sc.nextInt();
                iStudente --;
                do
                {
                    if(i == iStudente)
                    {

                        System.out.println("Inserisci un voto");
                        voto = sc.nextFloat();
                        admin.classe[i].matematica[admin.classe[i].votiMatematica] = voto;
                        admin.classe[i].votiMatematica ++;
                        admin.classe[i].calcolaMediaMatematica();
                        admin.classe[i].calcolaStato();             
                    }
                }
                while(i<admin.getNStudenti() || i == iStudente);
                if(admin.classe[iStudente] == null)
                {
                    System.out.println("Studente inesistente");
                }
                break;
            case "Sistemi e Reti": 
                System.out.println("Inserire il numero corrispondente allo studente");
                iStudente = sc.nextInt();
                iStudente --;
                do
                {
                    if(i == iStudente)
                    {

                        System.out.println("Inserisci un voto");
                        voto = sc.nextFloat();
                        admin.classe[i].sistemiReti[admin.classe[i].votiSistemiReti] = voto;
                        admin.classe[i].votiSistemiReti ++;
                        admin.classe[i].calcolaMediaSistemiReti();
                        admin.classe[i].calcolaStato();             
                    }
                }
                while(i<admin.getNStudenti() || i == iStudente);
                if(admin.classe[iStudente] == null)
                {
                    System.out.println("Studente inesistente");
                }
                break;
            case "TPSIT": 
                System.out.println("Inserire il numero corrispondente allo studente");
                iStudente = sc.nextInt();
                iStudente --;
                do
                {
                    if(i == iStudente)
                    {

                        System.out.println("Inserisci un voto");
                        voto = sc.nextFloat();
                        admin.classe[i].TPSIT[admin.classe[i].votiTPSIT] = voto;
                        admin.classe[i].votiTPSIT ++;
                        admin.classe[i].calcolaMediaTPSIT();
                        admin.classe[i].calcolaStato();             
                    }
                }
                while(i<admin.getNStudenti() || i == iStudente);
                if(admin.classe[iStudente] == null)
                {
                    System.out.println("Studente inesistente");
                }
                break;
            case "Informatica": 
                System.out.println("Inserire il numero corrispondente allo studente");
                iStudente = sc.nextInt();
                iStudente --;
                do
                {
                    if(i == iStudente)
                    {

                        System.out.println("Inserisci un voto");
                        voto = sc.nextFloat();
                        admin.classe[i].informatica[admin.classe[i].votiInformatica] = voto;
                        admin.classe[i].votiInformatica ++;
                        admin.classe[i].calcolaMediaInformatica();
                        admin.classe[i].calcolaStato();            
                    }
                }
                while(i<admin.getNStudenti() || i == iStudente);
                if(admin.classe[iStudente] == null)
                {
                    System.out.println("Studente inesistente");
                }
                break;
            case "Telecomunicazioni": 
                System.out.println("Inserire il numero corrispondente allo studente");
                iStudente = sc.nextInt();
                iStudente --;
                do
                {
                    if(i == iStudente)
                    {

                        System.out.println("Inserisci un voto");
                        voto = sc.nextFloat();
                        admin.classe[i].telecomunicazioni[admin.classe[i].votiTelecomunicazioni] = voto;
                        admin.classe[i].votiTelecomunicazioni ++;
                        admin.classe[i].calcolaMediaTelecomunicazioni();
                        admin.classe[i].calcolaStato();             
                    }
                }
                while(i<admin.getNStudenti() || i == iStudente);
                if(admin.classe[iStudente] == null)
                {
                    System.out.println("Studente inesistente");
                }
                break;
            case "Educazione Fisica": 
                System.out.println("Inserire il numero corrispondente allo studente");
                iStudente = sc.nextInt();
                iStudente --;
                do
                {
                    if(i == iStudente)
                    {

                        System.out.println("Inserisci un voto");
                        voto = sc.nextFloat();
                        admin.classe[i].edFisica[admin.classe[i].votiEdFisica] = voto;
                        admin.classe[i].votiEdFisica ++;
                        admin.classe[i].calcolaMediaEdFisica();
                        admin.classe[i].calcolaStato();             
                    }
                }
                while(i<admin.getNStudenti() || i == iStudente);
                if(admin.classe[iStudente] == null)
                {
                    System.out.println("Studente inesistente");
                }
                break;
        }
    }
}
