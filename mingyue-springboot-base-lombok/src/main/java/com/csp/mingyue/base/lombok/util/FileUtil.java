package com.csp.mingyue.base.lombok.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import lombok.Cleanup;
import lombok.SneakyThrows;

public class FileUtil {

  @SneakyThrows
  public void useCleanUp() {
    String inStr = "Ming Yue!";
    ByteArrayInputStream in = new ByteArrayInputStream(inStr.getBytes("UTF-8"));
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    byte[] b = new byte[1024];
    while (true) {
      int r = in.read(b);
      if (r == -1) {
        break;
      }
      out.write(b, 0, r);
    }
    String outStr = out.toString("UTF-8");
    System.out.println(outStr);

    // 手动清理
    out.close();
    in.close();
  }

  @SneakyThrows
  public void useCleanUpNew() {
    String inStr = "Ming Yue!";

    // 使用输入输出流自动关闭
    @Cleanup ByteArrayInputStream in = new ByteArrayInputStream(inStr.getBytes("UTF-8"));
    @Cleanup ByteArrayOutputStream out = new ByteArrayOutputStream();

    byte[] b = new byte[1024];
    while (true) {
      int r = in.read(b);
      if (r == -1) {
        break;
      }
      out.write(b, 0, r);
    }
    String outStr = out.toString("UTF-8");
    System.out.println(outStr);
  }
}
