import java.io.PrintWriter;
import java.net.Socket;

public class Transmissor {
    public static void main(String[] args) {
        final String HOST = "localhost";
        final Integer PORTA = 12345;

        try (Socket socket = new Socket(HOST, PORTA);
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true)) {
            System.out.println("Servidor conectado.");

            String mensagem = "Mensagem de teste.";

            output.println(mensagem);

            System.out.println("Mensagem enviada: " + mensagem);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
