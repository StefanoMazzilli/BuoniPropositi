package org.generation.italy;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//variabili
		String[] buoniPropositi= {
				"Perdere cinque chili", 
				"Leggere cinque nuovi libri", 
				"Progettare un piccolo gioco per computer", 
				"Fare palestra almeno due volte a settimana per un mese consecutivo", 
				"Acquisire la certificazione A1 in giapponese"};
		boolean[] fatto = {false, false, false, false, false};
		int counter=0, i, propositoFatto;
		String risposta= new String();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Benvenuto!");
		//ciclo per fare tutti i propositi
		do {
			System.out.println("\nEcco i tuoi buoni propositi:");
			for (i=0; i<5; i++) {
				//mostro tutti i propositi non ancora fatti
				if (fatto[i]==false) 
					System.out.println((i+1)+") "+buoniPropositi[i]);
			}
			
			//adesso chiedo se ne ha già fatto qualcuno
			System.out.println("\nHai già fatto qualcuno di questi propositi?");
			risposta=sc.nextLine().toLowerCase();
			//controllo che sia una risposta sensata
			while (!risposta.equals("si")&&!risposta.equals("sì")&&!risposta.equals("no")) {
				//caso in cui abbia dato una risposta diversa da quelle accettate
				System.out.println("Non ho capito, puoi ripetere?");
				risposta=sc.nextLine().toLowerCase();
			}
			
			//controllo cosa ha risposto
			if (risposta.substring(0, 1).equals("s")) {
				System.out.println("\nBravo!");
				System.out.println("Quale proposito hai conseguito? (inserire il numero corrispondente)");
				propositoFatto= Integer.parseInt(sc.nextLine())-1;
				//controllo che l'inserimento sia corretto
				while(propositoFatto<0||propositoFatto>4) {
					System.out.print("Inserimento non valido. Riprova: ");
					propositoFatto= Integer.parseInt(sc.nextLine())-1;
				}
				
				//controllo che il proposito non sia già stato fatto
				if (fatto[propositoFatto]==true) {
					System.out.println("Avevi già fatto questo proposito. Continua ad impegnarti con gli altri! ;)");
				} else {
					System.out.println("Perfetto! Ottimo lavoro fino ad ora!!");
					fatto[propositoFatto]=true;
					counter++;
				}
			} else {
				System.out.println("Ok. Continua ad impegnarti!");
			}
			
			//controllo se sono già stati completati degli obiettivi
			if (counter!=0) {
				System.out.println("\n\nFino ad ora hai conseguito i seguenti propositi:");
				for (i = 0; i < 5; i++) {
					//mostro tutti i propositi già fatti
					if (fatto[i] == true)
						System.out.println((i + 1) + ") " + buoniPropositi[i]);
				} 
			}
			System.out.println("\nPremi INVIO  quando vuoi continuare.");
			sc.nextLine();
		} while (counter<5);
		
		System.out.println("Complimenti!! Hai conseguito tutti i tuoi buoni propositi!!!");
		sc.close();
	}

}
