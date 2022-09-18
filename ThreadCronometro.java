public class ThreadCronometro extends Thread{
    private String[] tempo_Array = new String[3];
    private int tempo_seg = 0;
    private int tempo_min = 0;
    private int tempo_hora = 0;
    String tempo_string = "00:00:00";

    private boolean passando = true;

    public void run(){
        this.tempo();
    }

    public void tempo(){
        while (true){

            while(!passando){};

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

    public void zerarConometro(){
        this.setTempo_hora(0);
        this.setTempo_min(0);
        this.setTempo_seg(0);
        this.setTempo_string("00:00:00");

        this.passando = false;
    }

    public void setTempo_seg(int tempo_seg) {
        this.tempo_seg = tempo_seg;
    }

    public void setTempo_min(int tempo_min) {
        this.tempo_min = tempo_min;
    }

    public void setTempo_hora(int tempo_hora) {
        this.tempo_hora = tempo_hora;
    }

    public String getTempo_string() {
        return tempo_string;
    }

    public void setTempo_string(String tempo_string) {
        this.tempo_string = tempo_string;
    }

    public void setPassando(boolean passando) {
        this.passando = passando;
    }
}
