package sample;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    Queue<Alumno> pendiente = new Queue<>();
    Queue<Alumno> completo = new Queue<>();

    Queue<Alumno> psicologa1 = new Queue<>();
    Queue<Alumno> psicologa2 = new Queue<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int minutos = 0; minutos < 480; minutos++) {

            int valorDado = (int) ((Math.random() * 100) + 1);

            if (valorDado % 2 == 0) {
                int tiempoEspera = generarTiempoEspera();
                String nombre = generarID();
                String psico = generarPsicologa();

                Alumno alumno = new Alumno(
                        nombre, minutos, tiempoEspera, psico);

                pendiente.insert(alumno);
            }

            if (!psicologa1.isEmpty()) {
                int tiempoCola = psicologa1.front().getInfo().getTiempoCola();

                if (tiempoCola == 0) {
                    psicologa1.front().getInfo().setTiempoTotal(
                            minutos - psicologa1.front().getInfo().getTiempoEntrada()
                    );
                    completo.insert(psicologa1.remove().getInfo());
                }
                else
                    psicologa1.front().getInfo().setTiempoCola(tiempoCola - 1);
            }

            if (!psicologa2.isEmpty()) {
                int tiempoCola = psicologa2.front().getInfo().getTiempoCola();

                if (tiempoCola == 0) {
                    psicologa2.front().getInfo().setTiempoTotal(
                            minutos - psicologa2.front().getInfo().getTiempoEntrada()
                    );
                    completo.insert(psicologa2.remove().getInfo());
                }
                else
                    psicologa2.front().getInfo().setTiempoCola(tiempoCola - 1);
            }

            if (minutos % 3 == 0 & !pendiente.isEmpty()) {
                if (psicologa1.isEmpty())
                    psicologa1.insert(pendiente.remove().getInfo());
                else  if (psicologa2.isEmpty())
                    psicologa2.insert(pendiente.remove().getInfo());
            }
        }

        int size = pendiente.size();
        for (int i = 0; i < size; i++) {
            System.out.println(pendiente.remove().getInfo());
        }
    }

    String generarID() {
        Random random = new Random();
        String a = "" + (char)(random.nextInt(91) + 65);
        String b = "" + (char)(random.nextInt(91) + 65);
        String c = "" + (char)(random.nextInt(91) + 65);
        return a + b + c;
    }

    String generarPsicologa() {
        int valor = (int) (Math.random() * 1);
        if (valor == 0)
            return "Valeria Zamanda";
        else
            return "Alicia Perez";
    }

    int generarTiempoEspera() {
        return (int) ((Math.random() * 8) + 7);
    }
}
