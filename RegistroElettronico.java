package registroelettronico;
import java.util.Scanner;

public class RegistroElettronico {
    private String versione;
    //Costruttore
    public RegistroElettronico (String versione){
        setVersione(versione);
    }
    //Getter/Setter
    private void setVersione(String v){
        versione = v;  
    }
    public String getVersione(){
        return versione;
    }
    //Metodi
    public void accesso(Admin admin){
        int op, i, pos, t;
        String nu, pw;
        Scanner sc = new Scanner(System.in);
        System.out.println("REGISTRO ELETTRONICO");
        System.out.println("ver " + this.getVersione());
        System.out.println("-------------------------");
        do
        {
            t = 0;
            System.out.println("Inserire il tipo dell'utente");
            System.out.println("0 - Admin");
            System.out.println("1 - Professore");
            System.out.println("2 - Studente");
            System.out.println("3 - Esci");
            op = sc.nextInt();
            switch(op)
            {
                case 0:
                    System.out.println("Inserire password");
                    pw = sc.next();
                    if(admin.getPassword().equals(pw))
                    {
                        System.out.println("Accesso in corso");
                        homeAdmin(admin);
                    }
                    else
                    {
                        System.out.println("Utente inesistente");
                    }
                    break;
                case 1:
                    System.out.println("Inserire nome utente");
                    nu = sc.next();
                    System.out.println("Inserire password");
                    pw = sc.next();
                    for(i=0; i<admin.nProfessori; i++)
                    {
                        if(admin.prof[i].getNomeUtente().equals(nu) && admin.prof[i].getPassword().equals(pw))
                        {
                            homeProfessori(admin, i);
                            t = 1;
                        }
                    }
                    if(t == 0)
                    {
                        System.out.println("Nome utente o password errati");
                    }
                    break;
                case 2:
                    System.out.println("Inserire nome utente");
                    nu = sc.next();
                    System.out.println("Inserire password");
                    pw = sc.next();
                    for(i=0; i<admin.nStudenti; i++)
                    {
                        if(admin.classe[i].getNomeUtente().equals(nu) && admin.classe[i].getPassword().equals(pw))
                        {
                            homeStudenti(admin, i);
                            t = 1;
                        }
                    }
                    if(t == 0)
                    {
                        System.out.println("Nome utente o password errati");
                    }
                    break;
                case 3:
                    System.out.println("Uscita in corso ...");
                    System.out.println("-------------------------");
                default:
                    System.out.println("Tipologia di utente inesistente");
                    break;
            }
        }
        while(op != 3); 
    }
    public void homeAdmin(Admin admin){
        int op;
        Scanner sc = new Scanner(System.in);
        do
        {
            System.out.println("-------------------------");
            System.out.println("Scegliere un opzione");
            System.out.println("0 - Cambia password");
            System.out.println("1 - Aggiungi professore");
            System.out.println("2 - Elimina professore");
            System.out.println("3 - Aggiungi studente");
            System.out.println("4 - Elimina studente");
            System.out.println("5 - Esci");
            op = sc.nextInt();            
            switch(op)
            {
                case 0:
                    admin.cambiaPassword();
                    break;
                case 1:
                    admin.aggiungiProfessore();
                    break;
                case 2:
                    admin.eliminaProfessore();
                    break;
                case 3:
                    admin.aggiungiStudente();
                    break;
                case 4:
                    admin.eliminaStudente();
                    break;
                case 5:
                    System.out.println("Uscita in corso ...");
                    System.out.println("-------------------------");
                    break;
                default:
                    System.out.println("Opzione non valida");
                    break;
            }
        }
        while(op != 5); 
    }
    public void homeProfessori(Admin admin, int pos){
        int op;
        Scanner sc = new Scanner(System.in);
        do
        {
            System.out.println("-------------------------");
            System.out.println("Scegliere un opzione");
            System.out.println("0 - Cambia password");
            System.out.println("1 - Aggiungi voto");
            System.out.println("2 - Elimina voto");
            System.out.println("3 - Esci");
            op = sc.nextInt();
            switch(op)
            {
                case 0:
                    admin.prof[pos].cambiaPassword();
                    break;
                case 1:
                    admin.prof[pos].aggiungiVoto(admin);
                    break;
                case 2:
                    admin.prof[pos].eliminaVoto(admin);
                    break;
                case 3:
                    System.out.println("Uscita in corso ...");
                    System.out.println("-------------------------");
                    break;
                default:
                    System.out.println("Opzione non valida");
                    break;
            }
        }
        while(op != 3); 
    }
    public void homeStudenti(Admin admin, int pos){
        int op;
        Scanner sc = new Scanner(System.in);
        do
        {
            System.out.println("-------------------------");
            System.out.println("Scegliere un opzione");
            System.out.println("0 - Cambia password");
            System.out.println("1 - Calcola medie");
            System.out.println("2 - Calcola stato");
            System.out.println("3 - Esci");
            op = sc.nextInt();
            switch(op)
            {
                case 0:
                    admin.classe[pos].cambiaPassword();
                    break;
                case 1:
                    double mediaTot = (admin.classe[pos].mediaMatematica + admin.classe[pos].mediaItaliano + admin.classe[pos].mediaInformatica) / 3;
                    System.out.println("Media matematica: " + admin.classe[pos].calcolaMediaMatematica());
                    System.out.println("Media italiano: " + admin.classe[pos].calcolaMediaItaliano());
                    System.out.println("Media informatica: " + admin.classe[pos].calcolaMediaInformatica());
                    System.out.println("Media totale: " + mediaTot);
                    break;
                case 2:
                    admin.classe[pos].calcolaStato();
                    break;
                case 3:
                    System.out.println("Uscita in corso ...");
                    System.out.println("-------------------------");
                    break;
                default:
                    System.out.println("Opzione non valida");
                    break;
            }
        }
        while(op != 3); 
    }
    public static void main(String[] args) {
        RegistroElettronico RE;
        Admin admin;
        RE = new RegistroElettronico("1.0");
        admin = new Admin("admin");
        RE.accesso(admin);
    }
}
