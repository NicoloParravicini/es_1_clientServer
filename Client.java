import java.io.*;
import java.net.*;

public class Client {

String nomeServer ="LocalHost";

int portaServer = 7000;

Socket mySocket;

BufferedReader inputTastiera;

String stringaUtenteDigitata;

String stringaRicevutaServer;

DataOutputStream outPutVersoServer;

BufferedReader inputDalServer;


//metodo oer mettere in comunicazione il cliente col server

public Socket connetti()
{

    System.out.println("Il client è partito per l'esecuzione");

    try
    {
        
        inputTastiera = new BufferedReader(new InputStreamReader(System.in));
        
        //creazione canale di comunicazione tra client e server
        
        mySocket = new Socket(nomeServer, portaServer);
        
        outPutVersoServer = new DataOutputStream(mySocket.getOutputStream());
        
        inputDalSever = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
        
    } catch (UnknownHostException er)
        
    {
        
        System.err.println("Host non riconosciuto")
        
    }
    
    catch (Exception er)
    {
        
        System.out.println(er.getMessage());
        
        System.out.println("errore mentre tentavo la connessione al server");
        
        System.exit(1);
    }
        
        
    return mySocket;
    

} //fine metodo Connetti
    
    
    
public void comunica()
{
    
    try
    {
        System.out.println("Attendo inserimento frase da mandare al server..." + '/n');
        
        stringaUtenteDigitata = inputTastiera.Readline(); //stringa digitata dal client (utente) 
        
        System.out.println("Invio frase al server ed attendo la risposta di esso...");
        
        
        outPutVersoServer.writeBytes(stringaUtenteDigitata + '/n');
        
        //stringa mandata al server
        
        // salvo la risposta del server e la stampo a video
        
        stringaRicevutaServer = inputDalServer.readline();
        
        System.out.println("Risposta server : " + '/n' + stringaRicevutaServer);
        
        System.out.println("Chiusura connessione tra client e server");
        
        mySocket.close();
        
        
    }
    
    catch (Exception e)
    {
        
        System.out.println(e.getMessage());
        
        System.out.println("errore");
        
        System.exit(1);
    }
    
    
    
}
    
    

} //fine classe client
    
    

    

    
