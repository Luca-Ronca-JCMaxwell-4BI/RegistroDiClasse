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
        int op, i, pos;
        String nu, pw;
        Scanner sc = new Scanner(System.in);
        System.out.println("REGISTRO ELETTRONICO");
        System.out.println("ver " + this.getVersione());
        System.out.println("-------------------------");
        do
        {
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
                    for(i=0; i<admin.getNProfessori(); i++)
                    {
                        if(admin.prof[i].getNomeUtente().equals(nu) && admin.prof[i].getPassword().equals(pw))
                        {
                            System.out.println("Accesso in corso");
                            pos = i;
                            homeProfessori(admin, pos);
                        }
                        else
                        {
                            System.out.println("Utente inesistente");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Inserire nome utente");
                    nu = sc.next();
                    System.out.println("Inserire password");
                    pw = sc.next();
                    for(i=0; i<admin.getNStudenti(); i++)
                    {
                        if(admin.classe[i].getNomeUtente().equals(nu) && admin.classe[i].getPassword().equals(pw))
                        {
                            System.out.println("Accesso in corso");
                            pos = i;
                            homeStudenti(admin, pos);
                        }
                        else
                        {
                            System.out.println("Utente inesistente");
                        }
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
