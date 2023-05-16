import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        Socket socket = serverSocket.accept();
        System.out.println("A client has joined");

        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        OutputStream outputStream = socket.getOutputStream();

        PrintWriter printWriter = new PrintWriter(outputStream);

        String sendingMessage, receivingMessage;

        while (true) {
            System.out.print("Server: ");
            sendingMessage = userInput.readLine();
            printWriter.println(sendingMessage);
            printWriter.flush();

            receivingMessage = socketInput.readLine();
            System.out.println("Client: " + receivingMessage);
        }
    }
}