package com.wadiz.operation.test;

import org.junit.Test;

import java.io.*;

/**
 * @Class com.wadiz.operation.test.CSVReWriter
 * @Description
 * @Author hyungeun.jin
 * @Since 2020. 4. 14.
 * @Version 1.0
 * @COPYRIGHT © WADIZ ALL RIGHTS RESERVED.
 * ------------------------------------------------------------------------
 * Modification Information
 * ------------------------------------------------------------------------
 * 수정일 || 수정자 || 수정내용
 * ------------------------------------------------------------------------
 * 2020. 4. 14. || 진형은 || 최초생성
 */
public class CSVReWriter {

  @Test
  public void csv_ReWriter() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader("/Users/hyungeun.jin/ked/master/KED5002_normal_converted.csv"));

    StringBuilder result = new StringBuilder();
    String line = null;
    while( (line = reader.readLine()) != null){
      String[] values = line.split("[|]");
      result
              .append("'").append(values[0]).append("'")
              .append(",")
              .append(System.lineSeparator());
    }
    System.out.println(result.toString());
    BufferedWriter writer = new BufferedWriter((new FileWriter("/Users/hyungeun.jin/KED5002_IsDeleted_government.csv")));
    writer.write(result.toString());
    writer.flush();
  }
}
