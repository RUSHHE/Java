import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class MyServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(8090)) {
            Socket so = server.accept();
            System.out.println("server success");

            DataInputStream in = new DataInputStream(so.getInputStream());
            DataOutputStream out = new DataOutputStream(so.getOutputStream());

            double r = in.readDouble();
            System.out.println("radius is:" + r);
            double area = r * r * Math.PI;
            out.writeDouble(area);
        }
    }
}

class MyClient {
    public static void main(String[] args) throws IOException {
        try (Socket client = new Socket("localhost", 8090)) {
            System.out.println("client connection success");

            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            Scanner scan = new Scanner(System.in);
            double r = scan.nextDouble();
            out.writeDouble(r);
            double area = in.readDouble();
            System.out.println("area is:" + area);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}