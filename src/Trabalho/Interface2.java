/*Autores: Jean Jônatas 
	   Higor Ferreira
*/



package Trabalho;

import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



public class Interface2 extends javax.swing.JDialog {
	    private JList ListaMenor,
    	ListaMaior;
    	
    	private static final String[] acordesmaiores = {"C","C7","C#","C#7","D","D7","D#","D#7","E","E7","F","F7","F#","F#7","G","G7","G#","G#7","A","A7","A#","A#7",
    		"B","B7"};
    	private static final String[] acordesmenores = {"Cm","C#m","Dm","D#m","Em","Fm","F#m","Gm","G#m","Am","A#m","Bm"};
    	
    	private JLabel acorde1,
    					acorde2,
    					cabecalho;
    	
    	private static final String[] acordesMa = {"imagens\\C.jpg","imagens\\C7.jpg","imagens\\C#.jpg","imagens\\C#7.jpg","imagens\\D.jpg","imagens\\D7.jpg",
    		"imagens\\D#.jpg","imagens\\D#7.jpg","imagens\\E.jpg","imagens\\E7.jpg","imagens\\F.jpg","imagens\\F7.jpg","imagens\\F#.jpg","imagens\\F#7.jpg",
    		"imagens\\G.jpg","imagens\\G7.jpg","imagens\\G#.jpg","imagens\\G#7.jpg","imagens\\A.jpg","imagens\\A7.jpg","imagens\\A#.jpg","imagens\\A#7.jpg",
    		"imagens\\B.jpg","imagens\\B7.jpg"};
    	
    	private static final String[] acordesMe = {"imagens\\Cm.jpg","imagens\\C#m.jpg","imagens\\Dm.jpg","imagens\\D#m.jpg","imagens\\Em.jpg","imagens\\Fm.jpg","imagens\\F#m.jpg",
    		"imagens\\Gm.jpg","imagens\\G#m.jpg","imagens\\Am.jpg","imagens\\A#m.jpg","imagens\\Bm.jpg"};
	
    	private URL caminho;
    	
    	 	
    	public Interface2(Frame frames,String title, boolean modal) {  
        	super(frames,title, modal);  
            
            
            this.getContentPane().setLayout(new GridBagLayout());
            
            //JLabel Subtítulo
            add(cabecalho = new JLabel("Selecione os acordes:"));
            add(ListaMaior = new JList(acordesmaiores), acorde1 = new JLabel(), "maior");
            	//Eventos JList 1
            	ListaMaior.addListSelectionListener(new ListSelectionListener() {
					
					@Override
					public void valueChanged(ListSelectionEvent e) {
						caminho = this.getClass().getClassLoader().getResource(acordesMa[ListaMaior.getSelectedIndex()]);
						Icon acordeImg = new ImageIcon(caminho);
						acorde1.setIcon(acordeImg);
					}
				});
            
            	//Segundo JList
            	add(ListaMenor = new JList(acordesmenores), acorde2 = new JLabel(), "menor");
            		//Eventos JList 2
            		ListaMenor.addListSelectionListener(new ListSelectionListener() {
					
					@Override
					public void valueChanged(ListSelectionEvent e) {
						caminho = this.getClass().getClassLoader().getResource(acordesMe[ListaMenor.getSelectedIndex()]);
						Icon acordeImg1 = new ImageIcon(caminho);
						acorde2.setIcon(acordeImg1);
					}
				});
            this.setSize(400, 500);
              
    	}
    	
    	public void add(JLabel label){
    		GridBagConstraints cons = new GridBagConstraints();  
            cons.fill = GridBagConstraints.NONE;  
            cons.anchor = GridBagConstraints.CENTER;  
            cons.insets = new Insets(4,4,4,4);
            
            
            cons.weightx = 0;  
            cons.gridwidth = GridBagConstraints.REMAINDER;
            label.setFont( new Font("Arial", Font.PLAIN, 13));
            this.getContentPane().add(label, cons);
    		
    	}
    	
    	
    	public void add( JList jList,JLabel jLabel,String nome){
    		
    		GridBagConstraints cons = new GridBagConstraints();  
            cons.fill = GridBagConstraints.NONE;
            cons.anchor = GridBagConstraints.CENTER;  
            cons.insets = new Insets(35,40,40,50);
    		
            
            cons.weightx = 0;  
            cons.gridwidth = 2;  
            this.getContentPane().add(jList,cons);
            jList.setName(nome);
            jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            this.getContentPane().add(new JScrollPane(jList),cons);
            
            cons.insets = new Insets(20,25,20,15);
            cons.fill = GridBagConstraints.CENTER;  
            cons.weightx = 1;  
            cons.gridwidth = GridBagConstraints.REMAINDER;
            caminho = this.getClass().getClassLoader().getResource("imagens\\acorde-nulo.png");
            Icon acordeIm = new ImageIcon(caminho);
            jLabel.setIcon(acordeIm);
    		jLabel.setToolTipText("Acorde");
            this.getContentPane().add(jLabel, cons);
            
    	}
}