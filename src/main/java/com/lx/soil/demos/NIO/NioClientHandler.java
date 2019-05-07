package com.lx.soil.demos.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * nio客户端处理服务端信息子线程，用于接收处理服务端返回的信息
 */
public class NioClientHandler implements Runnable{
    private Selector selector;

    public NioClientHandler(Selector selector) {
        this.selector = selector;
    }

    @Override
    public void run() {

        try {

            for (;;) {
              int readyChannels = selector.select();

                if (readyChannels == 0) {
                    continue;
                }

               Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();

                while (iterator.hasNext()){
                    SelectionKey  selectionKey =  iterator.next();
                    iterator.remove();

                    if (selectionKey.isReadable()) {
                        //调用读方法
                        this.readHandler(selectionKey,selector);
                    }
                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * @param selectionKey
     * @param selector
     */
    public void readHandler(SelectionKey selectionKey,Selector selector) throws IOException {
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        String response = "";
        while (socketChannel.read(buffer) > 0){
            buffer.flip();
            response += Charset.forName("UTF-8").decode(buffer);
        }
        //再次注册到selector
        socketChannel.register(selector, SelectionKey.OP_READ);

        //本地打印
        if (response.length() > 0) {
            System.out.println("本地收到服务端响应: " + response);
        }

    }


}
