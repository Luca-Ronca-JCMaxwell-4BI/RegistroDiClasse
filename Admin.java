package registroelettronico;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Admin implements java.io.Serializable{
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
    private void setPassword(String p){
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
    //metodi
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
            System.out.println("1 - Italiano");
            System.out.println("2 - Storia");
            System.out.println("3 - Inglese");
            System.out.println("4 - Matematica");
            System.out.println("5 - Sistemi e Reti");
            System.out.println("6 - TPSIT");
            System.out.println("7 - Informatica");
            System.out.println("1 - Telecomunicazioni");
            System.out.println("1 - Educazione Fisica");
            do
            {
                op = sc.nextInt();
                switch(op)
                {
                    case 1: 
                        mat = "Italiano";
                        break;
                    case 2: 
                        mat = "Storia";
                        break;
                    case 3: 
                        mat = "Inglese";
                        break;    
                    case 4:
                        mat = "Matematica";
                        break;
                    case 5: 
                        mat = "Sistemi e Reti";
                        break;
                    case 6: 
                        mat = "TPSIT";
                        break;    
                    case 7:
                        mat = "Informatica";
                        break;
                    case 8: 
                        mat = "Telecomunicazioni";
                        break;
                    case 9: 
                        mat = "Educazione Fisica";
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
  public void eliminaStudente(){
        boolean trovato = false;
        int i, j, pos = -1;
        String cognome;
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserire il cognome dello studente da eliminare");
        cognome = sc.next();
        for(i=0; i<nStudenti;  i++)
        {
           if(classe[i].getCognome().equals(cognome)) 
           {
               trovato = true;
               pos = i;
           }
        }
        if (trovato == true)
        {
            classe[pos] = null;
            for(i=pos; i<nStudenti-1; i++)
            {
                for(j=i+1; j<nStudenti; j++)
                {
                    classe[i] = classe[j];
                }
            }
            nStudenti --;
            ordinaClasse();
            System.out.println("Studente eliminato");
        }
        else
        {
            System.out.println("Studente inesistente");
        }
    }
    public void eliminaProfessore(){
        boolean trovato = false;
        int i, j, pos = -1;
        String cognome;
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserire il cognome del professore da eliminare");
        cognome = sc.next();
        for(i=0; i<nProfessori;  i++)
        {
           if(prof[i].getCognome().equals(cognome)) 
           {
               trovato = true;
               pos = i;
           }
        }
        if (trovato == true)
        {
            prof[pos] = null;
            for(i=pos; i<nProfessori-1; i++)
            {
                for(j=i+1; j<nProfessori; j++)
                {
                    prof[i] = prof[j];
                }
            }
            nProfessori --;
            System.out.println("Professore eliminato");
        }
        else
        {
            System.out.println("Professore inesistente");
        }
    }
    public void ordinaClasse(){
        int i, j;
        Studenti scambio;
        for(i=0; i<nStudenti-1; i++)
        {
            for(j=i+1; j<nStudenti; j++)
            {
                if(classe[i].getCognome().compareTo(classe[j].getCognome()) > 0)
                {
                    scambio = classe[i];
                    classe[i] = classe[j];
                    classe[j] = scambio;
                }
            }
        }
    }
    public void visClasse(){
        for(int i=0; i<nStudenti; i++)
        {
            System.out.println("nome:" + classe[i].getNome());
        }
    }
    public void visProf(){
        for(int i=0; i<nProfessori; i++)
        {
            System.out.println("nome:" + prof[i].getNome());
        }
    }
    public void salvaRegistro(Admin admin) throws java.io.IOException{
        ObjectOutputStream streamAdmin = new ObjectOutputStream(new FileOutputStream("admin.bin"));
        int i;
        streamAdmin.writeObject(admin);
        streamAdmin.close();
    }
    public Admin caricaRegistro(Admin admin) throws java.io.IOException, ClassNotFoundException{
        ObjectInputStream streamAdmin = new ObjectInputStream(new FileInputStream("admin.bin"));
        admin = (Admin) streamAdmin.readObject();
        streamAdmin.close();
        return admin;
    }
}
