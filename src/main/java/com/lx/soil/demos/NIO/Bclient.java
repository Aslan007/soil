package com.lx.soil.demos.NIO;

import java.io.IOException;

public class Bclient {

    public static void main(String[] args) throws IOException {
            new NioClient().start("Bclient");
    }
}
