/*Autores: Jean Jônatas 
	   Higor Ferreira
*/


package Trabalho;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Interface extends JFrame {
	
	int x = 50;
	private JButton eButton,
					bButton,
					gButton,
					dButton,
					aButton,
					EButton,
					botaoFrame;
	
	private JLabel label1,
					label2;
	private URL caminhoTopo, caminhoPrincipal;  
    private Image iconeTitulo;
	
	
	
	public Interface(){
		super("Afinador");
		
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 530);
		this.setLocationRelativeTo(null);
		
		//LaF padrão do SO
		try {       
            UIManager.setLookAndFeel(  
             UIManager.getSystemLookAndFeelClassName());  
         }catch(Exception ex) {  
             ex.printStackTrace(System.err);  
         }
		
				
		caminhoTopo = this.getClass().getClassLoader().getResource("imagens\\violao.png");  
        iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoTopo);
        setIconImage(iconeTitulo);
		
		
		//Label de texto 
		label1 = new JLabel("Clique para reproduzir uma das notas:");
		label1.setFont( new Font("Arial", Font.PLAIN, 13));
		label1.setLocation(50, 10);	
		label1.setSize(500, 25);
		add(label1);
		
		//Label de Imagem
		caminhoPrincipal = this.getClass().getClassLoader().getResource("imagens\\cordas-violao1.jpg");
		Icon violao = new ImageIcon(caminhoPrincipal);
		
		label2 = new JLabel();
		label2.setIcon(violao);
		label2.setToolTipText("Posição das cordas no Violão!");
		label2.setLocation(160, 40);
		label2.setSize(300, 400);
		add(label2);
		
				
		
		//Configuração visual dos Botões
		EButton = new JButton("E");
		EButton.setToolTipText("Mi");
		EButton.setLocation(x, 50);
		EButton.setSize(80, 40);
		add(EButton);
		
		aButton = new JButton("A");
		aButton.setToolTipText("Lá");
		aButton.setLocation(x , 115);
		aButton.setSize(80, 40);
		add(aButton);
		
		dButton = new JButton("D");
		dButton.setToolTipText("Ré");
		dButton.setLocation(x , 180);
		dButton.setSize(80, 40);
		add(dButton);
		
		gButton = new JButton("G");
		gButton.setToolTipText("Sol");
		gButton.setLocation(x , 245);
		gButton.setSize(80, 40);
		add(gButton);
		
		bButton = new JButton("B");
		bButton.setToolTipText("Si");
		bButton.setLocation(x , 310);
		bButton.setSize(80, 40);
		add(bButton);
		
		eButton = new JButton("e");
		eButton.setToolTipText("Mizinho");
		eButton.setLocation(x , 375);
		eButton.setSize(80, 40);
		add(eButton);
				
		botaoFrame = new JButton("Acordes >>>");
		botaoFrame.setToolTipText("Ir para Janela de Acordes");
		botaoFrame.setLocation(199, 460);
		botaoFrame.setSize(98, 20);
		add(botaoFrame);
	
		
		//Adicionando manipuladores
		ButtonHandler handler = new ButtonHandler();
		eButton.addActionListener(handler);
		bButton.addActionListener(handler);
		gButton.addActionListener(handler);
		dButton.addActionListener(handler);
		aButton.addActionListener(handler);
		EButton.addActionListener(handler);
		
		//Botão para abrir Janela de acordes
		botaoFrame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Interface2 tela = new Interface2(Trabalho.Interface.this,"Acordes", true);
			    tela.setLocationRelativeTo(null);  
			    tela.setVisible(true);
			}
		});
	}
	
	
	//Classe interna para tratamento de eventos dos botoes de afinação
	private class ButtonHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent evento) {
			String nota;
			int valor = 0;
			
			nota  = evento.getActionCommand();
			
			switch (nota){
			case "e":
				valor = 1;
				break;
			case "B":
				valor = 2;
				break;
			case "G":
				valor = 3;
				break;
			case "D":
				valor = 4;
				break;
			case "A":
				valor = 5;
				break;
			case "E":
				valor = 6;
				break;
			}
			try {
				Reprodutor music = new Reprodutor(valor);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}