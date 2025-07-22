import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime alarmTime = null;
        String filePath = "Brave-Mark-Karan_-Scott-Guberman_-Angeline-Saris_-Jeremy-Hoenig.wav";

        while (alarmTime == null) {
            try {
                System.out.print("Digite o tempo do alarme #(Horas:Minutos:Segundos): ");
                String inputTime = scanner.nextLine();

                alarmTime = LocalTime.parse(inputTime, formatter);
                System.out.println("Alarme definido para " + alarmTime);

            } catch (DateTimeException e) {
                System.out.println("Formato inválido, favor usar HH:MM:SS (Horas, minutos e segundos)");
            }
        }

        AlarmClock alarmClock = new AlarmClock(alarmTime, filePath, scanner);
        Thread alarmThread = new Thread(alarmClock);
        alarmThread.start();


    }
}