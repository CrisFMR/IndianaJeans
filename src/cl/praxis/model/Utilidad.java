package cl.praxis.model;

public class Utilidad {

    // Utilidad que realiza un salto de lineas limpiando la visual de la consola
    public void limpiarPantalla() {
        for(int i=0; i<100;i++) {
            System.out.println();
        }

    }

    //Utilidad emula espera de tiempo por carga información.
    public void tiempoEspera(String mensaje, int sleepTimer) {
        System.out.print("|>" + mensaje + "<|");
        for (int i=0; i< 10; i++) {
            try {
                System.out.print(".");
                Thread.sleep(sleepTimer);
            }
            catch(InterruptedException e) {
                e.printStackTrace();

            }
        }

    }
}
