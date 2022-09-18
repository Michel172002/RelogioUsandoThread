import java.util.Objects;

public class ThreadAlarme implements Runnable {
    private String[] tempo_Array = new String[2];

    public void run(){
    }

    public void alarme(String horario, ThreadRelogio relogio){
        tempo_Array = horario.split(":");

        while (true) {
            if (Objects.equals(tempo_Array[0], relogio.getTempo_Array()[0])) {
                if (Objects.equals(tempo_Array[1], relogio.getTempo_Array()[1])) {
                    System.out.println("ALARME DISPARADO!");
                    return;
                }
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Horario: " + relogio.getTempo_string());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
