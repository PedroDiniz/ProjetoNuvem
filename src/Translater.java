import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Translater {
	public Translater(){
		
	}
	
	public void traduzir(String data, String presentes, String ausentes, String ausentesJusti, String atrasos,
			String atrasosJusti, String presidente, String ateiro, String ata) throws IOException {
		// Abre texto original
		Scanner in = new Scanner(ata);
		String line = "";
		
		// Cria arquivo html
		//File out = new File("/Users/phtg/Desktop/texto.html");
		File out = new File("C:\\Users\\PedroDiniz\\Documents\\ProjetoNuvem\\ProjetoNuvem\\texto.html");
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(out), "UTF-8")); 
		
		bw.write("<html>" +
				"<head>" +
				"<meta charset=\"utf-8\"></meta>" +
				"<title>Copie e cole</title>" +
				"</head>" +
				"<body style=\"font-family:tahoma\">");
		
		// linha dos presentes esta apertado
		
		bw.write("<h1>Dia " + data + "</h1>");
		bw.write("<div style=\"line-height:0.3em;\">");
		bw.write("<p style=\"font-size:13px\"><b>Presentes: </b>" + presentes + "</p>");
		bw.write("<p style=\"font-size:13px\"><b>Ausentes: </b>" + ausentes + "</p>");
		bw.write("<p style=\"font-size:13px\"><b>Ausentes justificados: </b>" + ausentesJusti + "</p>");
		bw.write("<p style=\"font-size:13px\"><b>Atrasos: </b>" + atrasos + "</p>");
		bw.write("<p style=\"font-size:13px\"><b>Atrasos justificados: </b>" + atrasosJusti + "</p>");
		bw.write("<p style=\"font-size:13px\"><b>Presidente: </b>" + presidente + "</p>");
		bw.write("<p style=\"font-size:13px\"><b>Ateiro: </b>" + ateiro + "</p>");
		bw.write("</div>");
		
		bw.write("<br>");
		
		bw.write("<div style=font-size:15px>");
		
		while(in.hasNext()){
			line = in.next();
			line = line.trim();
			
			// Para divisoes de tempo
			if(line.startsWith("!")){
				line = in.nextLine();
				bw.write("<h2 style=\"margin-bottom: 20\"><font color=\"#31849b\">" + line.trim() + "</font></h2>");
			}
			
			// Para topicos
			if(line.startsWith("**")){
				line = in.nextLine();
				System.out.println(line.trim());
				bw.write("<h2 style=\"line-height:0.5em\" style=\"margin-top: 20\">" + line.trim() + "</h2>");
			}

			// Para subtopicos
			if(line.startsWith("-")){
				bw.write("<li style=\"margin-left: 20\">");
				line = in.nextLine();
				
				String[] broken = line.split(" ");
				for (int i = 0; i < broken.length; i++) {
					if(broken[i].startsWith("/")){
						bw.write("<font color=\"red\"><b>" + broken[i].substring(1) + "</b></font> ");
						System.out.println(broken[i].substring(1));
					} else {
						bw.write(broken[i] + " ");
						System.out.println(broken[i]);
					}
				}
				
				bw.write("</li>");
			}
		}
		
		bw.write("</div>");
		
		bw.write("</body>" +
				"</html>");
		bw.close();
	}
}
