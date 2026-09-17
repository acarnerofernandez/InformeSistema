public class InformeSistema {
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        double m = 1024.0 * 1024.0;


        System.out.println("PROCESADORES");
        System.out.println("==================================================");
        System.out.println("Disponibles JVM: " + r.availableProcessors());
        System.out.println("(son hilos lógicos: con SMT no coinciden con los núcleos físicos)");

        System.out.println("\nMEMORIA · ANTES");
        System.out.println("==================================================");
        long total1 = r.totalMemory();
        long libre1 = r.freeMemory();
        long uso1 = total1 - libre1;
        long max = r.maxMemory();
        int pct1 = (int) Math.round((uso1 * 100.0) / total1);

        System.out.println("Total reservada: " + Math.round(total1 / m) + " MiB");
        System.out.println("Libre: " + Math.round(libre1 / m) + " MiB");
        System.out.println("En uso: " + Math.round(uso1 / m) + " MiB (" + pct1 + " % de la total)");
        System.out.println("Máxima (-Xmx): " + Math.round(max / m) + " MiB");


        long[] reservado = new long[8 * 1024 * 1024];


        System.out.println("\nMEMORIA · DESPUÉS DE RESERVAR 64 MIB");
        System.out.println("==================================================");
        long total2 = r.totalMemory();
        long libre2 = r.freeMemory();
        long uso2 = total2 - libre2;
        int pct2 = (int) Math.round((uso2 * 100.0) / total2);
        long incremento = uso2 - uso1;

        System.out.println("Total reservada: " + Math.round(total2 / m) + " MiB");
        System.out.println("Libre: " + Math.round(libre2 / m) + " MiB");
        System.out.println("En uso: " + Math.round(uso2 / m) + " MiB (" + pct2 + " % de la total)");
        System.out.println("Máxima (-Xmx): " + Math.round(max / m) + " MiB");
        System.out.println("Incremento en uso: " + Math.round(incremento / m) + " MiB");

        reservado[0] = 0;
        System.out.println("(el array sigue en memoria: reservado[0] = " + reservado[0] + ")");


        System.out.println("\nSISTEMA");
        System.out.println("==================================================");
        String user = System.getProperty("user.home");
        String separador = System.getProperty("file.separator");
        System.out.println("os.name:    " + System.getProperty("os.name") );
        System.out.println("file.separator: "  + "\""+ separador + "\"");
        System.out.println("Ruta construida con las propiedades: ");
        System.out.println("    "+ user + separador + "psp" + separador + "informe.txt" );


    }
}