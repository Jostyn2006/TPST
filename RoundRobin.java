package classe4itpst;

public class RoundRobin {

    public static void main(String[] args) {

        String[] processo = new String[4];
        int[] tArrivo = new int[4];
        int[] tEse = new int[4];
        int[] tServizio = new int[4];
        double[] tAttesa = new double[4];
        double media = 0;
        int quantitaTempo = 3;

        processo[0] = "P0";
        processo[1] = "P1";
        processo[2] = "P2";
        processo[3] = "P3";

        tArrivo[0] = 0;
        tArrivo[1] = 1;
        tArrivo[2] = 2;
        tArrivo[3] = 3;

        tEse[0] = 5;
        tEse[1] = 3;
        tEse[2] = 8;
        tEse[3] = 6;

        System.out.println("Time quantum: " + quantitaTempo);

        // Calcoliamo i tempi di servizio e attesa per ogni processo
        for (int i = 0; i < 4; i++) {
            if (i == 0) {
                tServizio[i] = tArrivo[i]; // Tempo di servizio del primo processo è l'arrivo
            } else {
                tServizio[i] = Math.max(tArrivo[i], tServizio[i - 1] + quantitaTempo); // Algoritmo RR
                tAttesa[i] = tServizio[i] - tArrivo[i];
                media += tAttesa[i];
                int tempoEsecuzioneRimanente = tEse[i] - quantitaTempo;
                tEse[i] = tempoEsecuzioneRimanente >= 0 ? tempoEsecuzioneRimanente : 0;
            }

            System.out.println("Process: " + processo[i]);
            System.out.println("Arrival Time: " + tArrivo[i]);
            System.out.println("Execution Time: " + tEse[i]);
            System.out.println("Service Time: " + tServizio[i]);
            System.out.println("Waiting Time: " + tAttesa[i]);
        }

        System.out.println("Average waiting time: " + (media / 4)); // Calcoliamo la media
    }
}
