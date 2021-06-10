package cn.ebing.dog.api.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SocketDemo {
  public static void main(String[] args) throws IOException {
      Socket socket = new Socket();
      socket.connect(new InetSocketAddress("localhost", 8080));
  }
}
