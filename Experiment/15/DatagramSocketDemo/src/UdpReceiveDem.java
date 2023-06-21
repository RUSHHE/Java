import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReceiveDem {
    public static void main(String[] args) throws IOException {
        //使用try-with-resources语句声明和初始化socket资源
        try (DatagramSocket socket = new DatagramSocket(6677)) {

            while (true) {
                //准备接受包裹
                byte[] container = new byte[1024];
                DatagramPacket packet = new DatagramPacket(container, 0, container.length);
                socket.receive(packet);//阻塞式接受包裹

                //断开连接 bye

                byte[] data = packet.getData();

                String receiveData = new String(data, 0, packet.getLength());

                System.out.println(receiveData);//读取接收的数据

                if (receiveData.equals("bye")) {
                    break;
                }
            }
        }
    }
}
