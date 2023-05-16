import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234);

        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        OutputStream outputStream = socket.getOutputStream();

        PrintWriter printWriter = new PrintWriter(outputStream);

        String sendingMessage, receivingMessage;

        while (true) {
            receivingMessage = socketInput.readLine();
            System.out.println("Server: " + receivingMessage);

            System.out.print("Client: ");
            sendingMessage = userInput.readLine();
            printWriter.println(sendingMessage);
            printWriter.flush();
        }
    }
}
