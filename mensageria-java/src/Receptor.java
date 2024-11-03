import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Receptor {
    public static void main(String[] args) {
        final Integer PORTA = 12345;

        try (ServerSocket serverSocket = new ServerSocket(PORTA)) {
            System.out.println("Esperando mensagem na porta: " + PORTA);

            try (Socket socket = serverSocket.accept();
                 BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                System.out.println("Conexão bem sucedida.");

                String mensagem = input.readLine();
                System.out.println("Mensagem recebida: " + mensagem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

