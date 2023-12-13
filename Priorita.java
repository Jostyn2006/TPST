package classe4itpst;
import java.util.ArrayList;

public class Priorita {
	int istanteArrivo = 0;
	int tempoCorrente = 0;
	ArrayList<String> processi = new ArrayList<String>();
	ArrayList<String> priorita = new ArrayList<String>();
	ArrayList<Integer> tArrivo = new ArrayList<Integer>();
	ArrayList<Integer> tEsecuzione = new ArrayList<Integer>();
	ArrayList<Integer> tServizio = new ArrayList<Integer>();
	ArrayList<Integer> tAttesa = new ArrayList<Integer>();

	public void add(int tempoEsecuzione) {
		processi.add("p" + istanteArrivo);
		tArrivo.add(istanteArrivo);
		tEsecuzione.add(tempoEsecuzione);
		istanteArrivo++;
	}
	public void schema() {
		int indice =0;
		System.out.println("Nome\ttArri\ttEse\ttSer\ttAtt");
		ArrayList<Integer> lista = new ArrayList<Integer>();
		ArrayList<Integer> ordinaProcessi = new ArrayList<Integer>();
		ordinaProcessi.addAll(tEsecuzione);
		for (int y = 0; y < processi.size(); y++) {
			int min = 9999;
			for (int i = 0; i < ordinaProcessi.size(); i++) {
				if (ordinaProcessi.get(i) < min) {
					min = ordinaProcessi.get(i);
					indice = i;
				}
			}
			lista.add(indice);
			ordinaProcessi.set(indice, 9999);
		}
		for (int j = 0;j < lista.size();j++) {	
			
			
			
		}
		for (int i = 0; i < lista.size(); i++) {
			int tempoAttesa;
			if(tempoCorrente-tArrivo.get(lista.get(i))<0){
				tempoAttesa=0;
				tAttesa.add(0);
			}else {
				tempoAttesa=tempoCorrente - tArrivo.get(lista.get(i));
				tAttesa.add(tempoCorrente - tArrivo.get(lista.get(i)));
			}
			System.out.println(" " + processi.get(lista.get(i)) + "\t " + tArrivo.get(lista.get(i)) + "\t " + tEsecuzione.get(lista.get(i)) + "\t "	+ tempoCorrente + "\t " + tempoAttesa	+ tAttesa.get(i));
			tempoCorrente += tEsecuzione.get(lista.get(i));
		}
	}
}
