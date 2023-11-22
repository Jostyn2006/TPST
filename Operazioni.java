package classe4itpst;

public class Operazioni {
	int n1,n2;
	public Operazioni (int x, int y){
		n1=x;
		n2=y;
	}
	public int Somma() {
		return n1+n2;
	}
	public int Prodotto() {
		return n1*n2;
	}
	public static void main(String[] args) {
		Operazioni op = new Operazioni(3,4);
		System.out.println(op.Somma());
		System.out.println(op.Prodotto());
	}
}
