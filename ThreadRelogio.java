public class ThreadRelogio extends Thread{
    private String[] tempo_Array = new String[3];
    private int tempo_seg = 0;
    private int tempo_min = 0;
    private int tempo_hora = 0;
    String tempo_string;

    public void run(){
        this.tempo();
    }

    public void tempo(){
        while (true){

            tempo_Array[0] = String.format("%02d", tempo_hora);
            tempo_Array[1] = String.format("%02d", tempo_min);
            tempo_Array[2] = String.format("%02d", tempo_seg);
            tempo_string = String.join(":", tempo_Array);

            tempo_seg++;
            if (tempo_seg == 60){
                tempo_seg = 0;
                tempo_min++;
                if (tempo_min == 60){
                    tempo_min = 0;
                    tempo_hora++;
                    if (tempo_hora == 24){
                        tempo_hora = 0;
                    }
                }
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void alterarHorario(String novo_horario){
        this.tempo_Array = novo_horario.split(":");
        this.tempo_hora = Integer.parseInt(tempo_Array[0]);
        this.tempo_min = Integer.parseInt(tempo_Array[1]);
        this.tempo_seg = Integer.parseInt(tempo_Array[2]);
    }

    public String[] getTempo_Array() {
        return tempo_Array;
    }

    public String getTempo_string() {
        return tempo_string;
    }

}
