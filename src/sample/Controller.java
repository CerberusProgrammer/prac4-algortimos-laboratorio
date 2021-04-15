package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    Queue<Alumno> pendiente = new Queue<>();
    Queue<Alumno> completo = new Queue<>();
    Queue<Alumno> general = new Queue<>();

    Queue<Alumno> psicologa1 = new Queue<>();
    Queue<Alumno> psicologa2 = new Queue<>();

    @FXML
    private TextArea textGeneral;
    @FXML
    private TextArea textPendiente;
    @FXML
    private TextArea textAtendidos;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int minutos = 0; minutos < 150; minutos++) {

            int valorDado = (int) ((Math.random() * 100) + 1);

            if (valorDado % 2 == 0) {
                int tiempoEspera = generarTiempoEspera();
                String nombre = generarID();
                String psico = generarPsicologa();

                Alumno alumno = new Alumno(
                        nombre, minutos, tiempoEspera, psico);

                general.insert(alumno);
                pendiente.insert(alumno);
            }

            if (!psicologa1.isEmpty()) {
                int tiempoCola = psicologa1.front().getInfo().getTiempoCola();

                if (tiempoCola == 0) {
                    psicologa1.front().getInfo().setTiempoTotal(
                            minutos - psicologa1.front().getInfo().getTiempoEntrada()
                    );
                    psicologa1.front().getInfo().setAtendido(true);
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
                    psicologa2.front().getInfo().setAtendido(true);
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

        generarPendiente();

        while (!pendiente.isEmpty())
            textPendiente.appendText(pendiente.remove().getInfo().toString() + "\n");

        while (!completo.isEmpty())
            textAtendidos.appendText(completo.remove().getInfo().toString() + "\n");

        while (!general.isEmpty())
            textGeneral.appendText(general.remove().getInfo().toString() + "\n");
    }

    void generarPendiente() {
        while (!psicologa1.isEmpty())
            pendiente.insert(psicologa1.remove().getInfo());

        while (!psicologa2.isEmpty())
            pendiente.insert(psicologa2.remove().getInfo());
    }

    String generarID() {
        return "" + (char) ((Math.random() * 25) + 65) +
                (char) ((Math.random() * 25) + 65) +
                (char) ((Math.random() * 25) + 65);
    }

    String generarPsicologa() {
        double valor = Math.random();

        if (valor > 0.5)
            return "Valeria Zamanda";
        else
            return "Alicia Perez";
    }

    int generarTiempoEspera() {
        return (int) ((Math.random() * 8) + 7);
    }
}
