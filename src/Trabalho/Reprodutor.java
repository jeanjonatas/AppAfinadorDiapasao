/*Autores: Jean Jônatas 
	   Higor Ferreira
*/

package Trabalho;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.player.Player;

 
public class Reprodutor{
    private File music;
    private Player player;
 
    public Reprodutor(int num) throws FileNotFoundException{
        
    	
    	File in = new File("sons\\1e.mp3");
    	File in2 = new File("sons\\2b.mp3");
    	File in3 = new File("sons\\3g.mp3");
    	File in4 = new File("sons\\4d.mp3");
    	File in5 = new File("sons\\5a.mp3");
    	File in6 = new File("sons\\6e.mp3");
        
    	 switch (num){
        case 1:
        	this.music = in;
        	break;
        case 2:
        	this.music = in2;
        	break;
        case 3:
        	this.music = in3;
        	break;
        case 4:
        	this.music = in4;
        	break;
        case 5:
        	this.music = in5;
        	break;
        case 6:
        	this.music = in6;
            break;          
        }
    	 
    	 try{
         	System.out.println("Executando...");
         	
         	for (int i = 0;i < 1; i++){
             
         	FileInputStream stream = new FileInputStream(music);
             BufferedInputStream buffer = new BufferedInputStream(stream);
             this.player = new Player (buffer);
             this.player.play();
             
             }System.out.println("Terminado");
             
         }
         catch (Exception e) {
             System.out.println("Erro!");
             e.printStackTrace();
         }
    }  
}