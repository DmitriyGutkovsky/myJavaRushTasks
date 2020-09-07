package com.javarush.task.task31.task3110;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {
    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception{
       try(ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile));
           InputStream inputStream = Files.newInputStream(source)){
           ZipEntry zipEntry = new ZipEntry(source.getFileName().toString());
           zipOutputStream.putNextEntry(zipEntry);
           byte[] buffer = new byte[inputStream.available()];
           while (inputStream.available() >0) {
               inputStream.read(buffer);
           }
           zipOutputStream.write(buffer);
       }
    }
}