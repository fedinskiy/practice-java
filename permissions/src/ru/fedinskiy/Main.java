package ru.fedinskiy;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
      Writer writer=new Writer();
      Reader reader=new Reader ();
      System.out.println(reader.read("src/resources/allowed/toread.txt"));
      writer.Write("src/resources/allowed/toread.txt", "sdcbs");
    }
}
