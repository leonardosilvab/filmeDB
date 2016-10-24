package Imdb;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import org.json.JSONException;
import org.json.JSONObject;

public class View implements ActionListener, Observer {

	private Subject model;
	public String titulo1 = "", diretor1 = "", ano1 = "", sinopse1="", variavel = "";

	JFrame frame;
	private Controller controller;


	JPanel titulo;                   // cV
	JPanel diretor;
	JPanel ano;
	JPanel sinopse;


	JPanel dados;
	JPanel botoes;
	JPanel infoExtra;

	JLabel lblTitulo;
	JLabel textTitulo;

	JLabel lblDiretor;
	JLabel textDiretor;

	JLabel lblAno;
	JLabel textAno;

	JLabel lblSinopse;
	JLabel textSinopse;

	JButton infoBasica;
	JButton infoCompleta;
	

	public View(String s, Subject mo, Controller co){    //
		this.variavel = s;
		this.model = mo;
		this.controller = co;
	}



	public void createView(){              //

		frame = new JFrame("IMDB");

		infoExtra = new JPanel(); 
		botoes = new JPanel();
		titulo = new JPanel();
		diretor = new JPanel();
		ano = new JPanel();
		sinopse = new JPanel();
		dados = new JPanel();

		infoBasica = new JButton("Info. Basica");
		infoCompleta = new JButton("Info. Completa");


		lblDiretor = new JLabel();
		lblTitulo = new JLabel();
		lblAno = new JLabel();
		lblSinopse = new JLabel();



		textTitulo = new JLabel("Titulo: ");
		textDiretor = new JLabel("Diretor: ");
		textAno= new JLabel("Lançamento: ");
		textSinopse = new JLabel("Sinopse: ");


		infoBasica.addActionListener(this);
		infoCompleta.addActionListener(this);

		botoes.add(infoBasica);
		botoes.add(infoCompleta);
		titulo.add(textTitulo);
		titulo.add(lblTitulo);
		diretor.add(textDiretor);
		diretor.add(lblDiretor);
		ano.add(textAno);
		ano.add(lblAno);
		sinopse.add(textSinopse);
		sinopse.add(lblSinopse);
		dados.add(titulo);
		dados.add(diretor);
		dados.add(ano);
		infoExtra.add(sinopse);


		frame.getContentPane().add(BorderLayout.PAGE_START, dados);
		frame.getContentPane().add(BorderLayout.CENTER, infoExtra);
		frame.getContentPane().add(BorderLayout.SOUTH, botoes);


		frame.setSize(600, 120);


		frame.setVisible(true);
		sinopse.setVisible(false);	


	}

	public void update(String a, String b, String c, String d){    // 
		titulo1 = a;
		diretor1 = b;
		ano1 = c;
		sinopse1 = d;
		display();

	}
	public void display() {                    // 

		lblTitulo.setText(titulo1);
		lblDiretor.setText(diretor1);
		lblAno.setText(ano1);
		lblSinopse.setText(sinopse1);

	}
	public void janelaSimples(){
		sinopse.setVisible(false);
		frame.setSize(600, 120);
	}

	public void janelaCompleta(){
		sinopse.setVisible(true);
		frame.setSize(1100, 150);
	}

	@Override
	public void actionPerformed(ActionEvent e) {          //
		                                                  
	
		// TODO Auto-generated method stub
		if(e.getSource() == infoBasica){
			janelaSimples();
			controller.exibe();

		}
		if(e.getSource() == infoCompleta){                            //
			janelaCompleta();
			controller.exibe();
		}
	}

}