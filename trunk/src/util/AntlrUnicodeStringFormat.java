package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AntlrUnicodeStringFormat {
  public static void convert(String inputFile, String outputFile) {
    StringBuffer sb=new StringBuffer();
    try {
      FileReader fr=new FileReader(inputFile);
      BufferedReader br=new BufferedReader(fr);
      FileWriter fw=new FileWriter(outputFile);
      boolean isStrLit=false;
      int c=br.read();
      while (c!=-1) {
        if (c=='"') {
          isStrLit=!isStrLit;
          while (isStrLit)
          c=br.read();
          continue;
        }
        if (isStrLit) {
          sb.append('\'');
          sb.append((char)c);
          sb.append('\'');
        } else
          sb.append((char)c);
        c=br.read();
      }
      System.out.println(sb);
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
