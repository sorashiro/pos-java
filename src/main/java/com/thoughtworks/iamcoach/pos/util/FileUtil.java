package com.thoughtworks.iamcoach.pos.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileUtil {
  public static List<String> textToList(String path) {
    Path file = Paths.get(path);

    List<String> linesRead = null;
    try {
      linesRead = Files.readAllLines(file);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return linesRead;
  }
}
