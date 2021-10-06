import java.io.*;
import java.net.*;
import java.util.*;

public class Server_socket {
    
    Client porta;
    
    ServerSocket server = null;
    Socket client = null;
    String stringaRicevuta = null;
    String stringaModificata = null;
    
    BufferedReader indDalClient;
    DataOutputStream outVersoClient;
    
    
public Socket attendi()
{
    
    try
    {
        
        System.out.println("Server partito " + /n);
        
        server = new ServerSocket(porta.getPortaServer);
        
        //attesa di un client+
        
        client = server.accept();
        
        server.close();
        
        inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
                
        outVersoClient = new DataOutputStream(client.getOutputStream());
        
        
        
    } catch(Exception e)
    {
        
        System.out.pritln(e.getMessage());
        
        System.out.pritln(" Errore durante creazione server sulla porta: " + porta.getPortaServer() );
        
        
        System.exit(1);
        
    }
    
    return client;
    
    
} //fine metodo attendi
    

public void comunica()
{
    
    try
    {
        
        System.out.println("Ciao! Scrivi una frase e la trasformo in maiuscolo");
        
        stringaRicevuta = inDalClient.readline();
        
        System.out.println("La frase digitata è: " + stringaRicevuta);
        
        stringModificata = stringaRicevuta.toUpperCase();
        
        System.out.pritln("Invio della modifica della frase al client...");
        
        outVersoClient.writeBytes(stringaModificata + '/n');
        
        
        //dopo cio chiudo comunicazione col client
        
        System.out.println("Chiusura socket");
    
        
        client.close();
        
    }
    
    
    
}
    
    

    
} //fine classe