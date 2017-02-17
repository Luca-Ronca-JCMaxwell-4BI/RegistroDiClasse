package registroelettronico;
import java.util.Scanner; /*importa la classe Scanner la quale è nella cartella UTIL che è dentro la cartella JAVA.  
                          Scanner : classe predefinita per prendere input dagli utenti*/
public class Admin {
    public String password;
    public final String tipoUtente = "Admin";
    public static final int N_STUDENTI = 24;
    public static final int N_PROF = 10;
    public Studenti[] classe;
    public Professori[] prof;
    public int nStudenti = 0;
    public int nProfessori = 0;
    //Costruttore
    public Admin(String password){
        setPassword(password);
        classe = new Studenti[N_STUDENTI];
        prof = new Professori[N_PROF];
    }
    //Setter/Getter
    public void setPassword(String p){
        password = p;
    }
    public String getPassword(){
        return password;
    }
    public int getNStudenti(){
        return N_STUDENTI;
    }
    public int getNProfessori(){
        return N_PROF;
    }
    //Metodi
    public void cambiaPassword(){
        String p;
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserisci la nuova password");
        p = sc.next();
        setPassword(p);
        System.out.println("Password cambiata correttamente");
    }
    public void aggiungiStudente(){
        Studenti s;
        String nome, cognome, nUtente, pass;
        Scanner sc = new Scanner(System.in);
        if(nStudenti < getNStudenti())
        {
            System.out.println("Inserire il nome dello studente");
            nome = sc.next();
            System.out.println("Inserire il cognome dello studente");
            cognome = sc.next();
            System.out.println("Inserire il nomeUtente dello studente");
            nUtente = sc.next();
            System.out.println("Inserire la password dello studente");
            pass = sc.next();
            s = new Studenti(nome, cognome, nUtente, pass);
            classe[nStudenti] = s;
            nStudenti ++;
            ordinaClasse();
            System.out.println("Studente creato correttamente");
        }  
        else
        {
            System.out.println("La classe è piena");
        }
    }
    public void aggiungiProfessore(){
        Professori p;
        String nome, cognome, nUtente, pass, mat = "x";
        int op;
        Scanner sc = new Scanner(System.in);
        if(nProfessori < getNProfessori())
        {
            System.out.println("Inserire il nome del professore");
            nome = sc.next();
            System.out.println("Inserire il cognome del professore");
            cognome = sc.next();
            System.out.println("Inserire il nomeUtente del professore");
            nUtente = sc.next();
            System.out.println("Inserire la password del professore");
            pass = sc.next();
            System.out.println("Scegliere la materia del professore");
            System.out.println("1 - Matematica");
            System.out.println("2 - Italiano");
            System.out.println("3 - Informatica");
            do
            {
                op = sc.nextInt();
                switch(op)
                {
                    case 1: 
                        mat = "Matematica";
                        break;
                    case 2:
                        mat = "Italiano";
                        break;
                    case 3:
                        mat = "Informatica";
                        break;
                    default:
                        System.out.println("Selezionare una materia");
                        break;    
                }
            }
            while(op <= 0 || op > 3);
            p = new Professori(nome, cognome, nUtente, pass, mat); 
            prof[nProfessori] = p;
            nProfessori ++;
            System.out.println("Professore creato correttamente");
        }  
        else
        {
            System.out.println("Ci sono abbastanza professori");
        }
    }
}
