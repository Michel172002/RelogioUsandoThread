import java.util.Scanner;
import java.util.Objects;

public class Main extends Thread{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ThreadRelogio threadR = new ThreadRelogio();
        threadR.start();

        ThreadCronometro threadC = new ThreadCronometro();

        ThreadAlarme threadA = new ThreadAlarme();

        int escolha = 0;
        while (escolha != 7){
            System.out.println("""
                    Menu:
                    [ 1 ] - Ajustar Horario
                    [ 2 ] - Ver horario
                    [ 3 ] - Iniciar Cronometro
                    [ 4 ] - Parar Cronometro
                    [ 5 ] - Zerar Cronometro
                    [ 6 ] - Definir Alarme
                    [ 7 ] - Fechar
                    Escolha uma opção: """);
            escolha = input.nextInt();

            switch (escolha){
                case 1:
                    System.out.println("Digite o novo horario(Exemplo: 15:30:20): ");
                    String novo_horario = input.next();
                    threadR.alterarHorario(novo_horario);
                    break;

                case 2:
                    System.out.println("Horario: " + threadR.getTempo_string());
                    break;

                case 3:
                    if(!threadC.isAlive()){
                        threadC.start();
                    }
                    if(Objects.equals(threadC.getTempo_string(), "00:00:00")) {
                        threadC.setPassando(true);
                        System.out.println("cronometro iniciado!");
                    } else if (!Objects.equals(threadC.getTempo_string(), "00:00:00")) {
                        threadC.setPassando(true);
                        System.out.println("cronometro reiniciado!");
                    }else{
                        System.out.println("Cronometro já iniciado!");

                    }
                    break;

                case 4:
                    System.out.println(threadC.getTempo_string());
                    threadC.setPassando(false);
                    break;

                case 5:
                    threadC.zerarConometro();
                    System.out.println("Cronometro Zerado!");
                    break;

                case 6:
                    System.out.println("Digite o Horario do Alarme(Exemplo: 15:30):");
                    String alarme = input.next();
                    threadA.alarme(alarme, threadR);
                    break;
            }
        }
    }

}
