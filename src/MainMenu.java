import java.awt.Button;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainMenu {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Ata Maker");
		
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setSize(500, 800);
		frame.setLayout(null);
		
		// Label para data
		JLabel data = new JLabel();
		data.setText("Data:");
		data.setFont(new Font("arial", 0, 15));
		data.setLocation(20, 20);
		data.setSize(40, 30);
		
		// TextField para data
		final JTextField dataText = new JTextField();
		dataText.setSize(410, 30);
		dataText.setLocation(65, 20);
		
		// Label para presentes
		JLabel presentes = new JLabel();
		presentes.setText("Presentes:");
		presentes.setFont(new Font("arial", 0, 15));
		presentes.setLocation(20, 60);
		presentes.setSize(80, 30);
		
		// TextField para presentes
		final JTextArea presentesText = new JTextArea();
		presentesText.setLineWrap(true);
		presentesText.setWrapStyleWord(true);
		presentesText.setSize(370, 50);
		presentesText.setLocation(105, 60);
		
		// Label para ausentes
		JLabel ausentes = new JLabel();
		ausentes.setText("Ausentes:");
		ausentes.setFont(new Font("arial", 0, 15));
		ausentes.setLocation(20, 120);
		ausentes.setSize(80, 30);
		
		// TextField para ausentes
		final JTextField ausentesText = new JTextField();
		ausentesText.setSize(375, 30);
		ausentesText.setLocation(102, 120);
		
		// Label para ausentes justificados
		JLabel ausentesJusti = new JLabel();
		ausentesJusti.setText("Ausentes Justificados:");
		ausentesJusti.setFont(new Font("arial", 0, 15));
		ausentesJusti.setLocation(20, 160);
		ausentesJusti.setSize(150, 30);
		
		// TextField para ausentes justificados
		final JTextField ausentesJustiText = new JTextField();
		ausentesJustiText.setSize(305, 30);
		ausentesJustiText.setLocation(170, 160);
		
		// Label para atrasos
		JLabel atrasos = new JLabel();
		atrasos.setText("Atrasos:");
		atrasos.setFont(new Font("arial", 0, 15));
		atrasos.setLocation(20, 200);
		atrasos.setSize(55, 30);
		
		// TextField para atrasos
		final JTextField atrasosText = new JTextField();
		atrasosText.setSize(395, 30);
		atrasosText.setLocation(80, 200);
		
		// Label para atrasos justificados
		JLabel atrasosJusti = new JLabel();
		atrasosJusti.setText("Atrasos Justificados:");
		atrasosJusti.setFont(new Font("arial", 0, 15));
		atrasosJusti.setLocation(20, 240);
		atrasosJusti.setSize(140, 30);
		
		// TextField para atrasos justificados
		final JTextField atrasosJustiText = new JTextField();
		atrasosJustiText.setSize(305, 30);
		atrasosJustiText.setLocation(170, 240);
		
		// Label para presidente
		JLabel presidente = new JLabel();
		presidente.setText("Presidente:");
		presidente.setFont(new Font("arial", 0, 15));
		presidente.setLocation(20, 280);
		presidente.setSize(75, 30);
		
		// TextField para presidente
		final JTextField presidenteText = new JTextField();
		presidenteText.setSize(375, 30);
		presidenteText.setLocation(100, 280);
		
		//Label para ateiro
		JLabel ateiro = new JLabel();
		ateiro.setText("Ateiro:");
		ateiro.setFont(new Font("arial", 0, 15));
		ateiro.setLocation(20, 320);
		ateiro.setSize(45, 30);
		
		// TextField para ateiro
		final JTextField ateiroText = new JTextField();
		ateiroText.setSize(405, 30);
		ateiroText.setLocation(70, 320);
		
		// Label para ata
		JLabel ata = new JLabel();
		ata.setText("Ata:");
		ata.setFont(new Font("arial", 0, 15));
		ata.setLocation(20, 360);
		ata.setSize(30, 30);
		
		// TextArea para ata
		final JTextArea ataMesmo = new JTextArea();
		ataMesmo.setLineWrap(true);
		ataMesmo.setWrapStyleWord(true);
		ataMesmo.setSize(450, 350);
		ataMesmo.setLocation(20, 400);
		JScrollPane scroll = new JScrollPane(ataMesmo);
		scroll.setSize(450, 320);
		scroll.setLocation(20, 390);
		
		// Botao para gerar ata
		Button gerarAta = new Button();
		gerarAta.setLabel("Gerar ata");
		gerarAta.setSize(85, 40);
		gerarAta.setLocation(20, 715);
		gerarAta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Translater translater = new Translater();
				
				try {
					String data = dataText.getText();
					String presentes = presentesText.getText();
					String ausentes = ausentesText.getText();
					String ausentesJusti = ausentesJustiText.getText();
					String atrasos = atrasosText.getText();
					String atrasosJusti = atrasosJustiText.getText();
					String presidente = presidenteText.getText();
					String ateiro = ateiroText.getText();
					String ata = ataMesmo.getText();
					
					translater.traduzir(data, presentes, ausentes, ausentesJusti, atrasos, atrasosJusti, presidente, ateiro, ata);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		// Adicionando tudo
		frame.add(data);
		frame.add(dataText);
		frame.add(presentes);
		frame.add(presentesText);
		frame.add(ausentes);
		frame.add(ausentesText);
		frame.add(ausentesJusti);
		frame.add(ausentesJustiText);
		frame.add(atrasos);
		frame.add(atrasosText);
		frame.add(atrasosJusti);
		frame.add(atrasosJustiText);
		frame.add(presidente);
		frame.add(presidenteText);
		frame.add(ateiro);
		frame.add(ateiroText);
		frame.add(ata);
		frame.add(scroll);
		frame.add(gerarAta);
		frame.setVisible(true);
	}
}
