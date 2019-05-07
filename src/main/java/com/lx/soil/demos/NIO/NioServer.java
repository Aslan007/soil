package com.lx.soil.demos.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * Nio服务端
 */
public class NioServer {

    public void Start() throws IOException {
        //1.创建selector
        Selector selector = Selector.open();

        //2.创建channel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        //3.设置channel监听端口
        serverSocketChannel.bind(new InetSocketAddress(8000));

        //4.设置channel为非阻塞
        serverSocketChannel.configureBlocking(false);

        //5.注册channel到selector
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务端启动成功！");

        //6.死循环监听channel
        for (; ; ) {
            //阻塞等待selector响应
            int redayChannels = selector.select();

            if (redayChannels == 0) {
                continue;
            }

            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            while (iterator.hasNext()) {

                SelectionKey selectionKey = iterator.next();

                //** 重要，selectionKey检测到之后，从当前set集合里面移除掉 ** 当前是一个set集合 为何要移除？？？？
                iterator.remove();

                //7.若有就绪的channel则根据状态执行对应方法

                //7.1 接入状态
                if (selectionKey.isAcceptable()) {
                    this.acceptHandler(serverSocketChannel, selector);
                }

                //7.2 读写状态
                if (selectionKey.isReadable()) {
                    this.readHandler(selectionKey, selector);
                }
            }


        }


    }

    /**
     * 接入处理器处理逻辑
     */
    public void acceptHandler(ServerSocketChannel serverSocketChannel, Selector selector) throws IOException {
        //1.创建socketChannel
        SocketChannel socketChannel = serverSocketChannel.accept();

        //2.设置channel为非阻塞
        socketChannel.configureBlocking(false);

        //3.注册socketChannel到selector
        socketChannel.register(selector, SelectionKey.OP_READ);

        //4.注册成功之后返回信息给客户端
        socketChannel.write(Charset.forName("UTF-8").encode("你好，连接成功！"));

    }

    /**
     * 读处理器处理逻辑
     */
    public void readHandler(SelectionKey selectionKey, Selector selector) throws IOException {
        //1.获取到selectionKey里面就绪的channel
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

        //2.创建byteBuffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //3.循环读取channel里面的字符
        String request = "";
        while (socketChannel.read(buffer) > 0) {

            //切换为读模式
            buffer.flip();

            //读取buffer内容
            request += Charset.forName("UTF-8").decode(buffer);
        }

        //再次注册到selector
        socketChannel.register(selector, SelectionKey.OP_READ);

        //广播
        if (request.length() > 0) {
            System.out.println("服务端收到信息，并广播::" + request);
            this.broadCast(selector,socketChannel,request);
        }


    }

    public void broadCast(Selector selector, SocketChannel socketChannel,String request){
        //获取到所有注册到selector上面的key
        Set<SelectionKey> selectionKeys = selector.keys();

        selectionKeys.forEach(selectionKey -> {
            Channel targetChannel = selectionKey.channel();

            //必须为socketChannel而且剔除当前发消息的channel
            if (targetChannel instanceof SocketChannel && targetChannel != socketChannel) {

                try {
                    ((SocketChannel)targetChannel).write(Charset.forName("UTF-8").encode(request));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

                });

    }

    public static void main(String[] args) throws IOException {
       //     new NioServer().Start();
    }
}
