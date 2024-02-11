package Homework_18_01_2024;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileToZip {

    public static boolean isZip = true;

    //Дефолтное имя файла (по методу)
    public FileToZip(String result) throws IOException {
        String sourceFile = result;
        FileOutputStream fos = new FileOutputStream(result.getClass().getName() + ".zip");
        ZipOutputStream zipOut = new ZipOutputStream(fos);

        File fileToZip = new File(CachedProxyApp.HardWorkImpl.path);
        FileInputStream fis = new FileInputStream(fileToZip);
        ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
        zipOut.putNextEntry(zipEntry);

        byte[] bytes = new byte[1024];
        int length;
        while((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
        }

        zipOut.close();
        fis.close();
        fos.close();
    }

    //Заданное имя файла
    public FileToZip(String result, String fileName) throws IOException {
        String sourceFile = result;
        FileOutputStream fos = new FileOutputStream(fileName + ".zip");
        ZipOutputStream zipOut = new ZipOutputStream(fos);

        File fileToZip = new File(CachedProxyApp.HardWorkImpl.path);
        FileInputStream fis = new FileInputStream(fileToZip);
        ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
        zipOut.putNextEntry(zipEntry);

        byte[] bytes = new byte[1024];
        int length;
        while((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
        }

        zipOut.close();
        fis.close();
        fos.close();
    }

    public static boolean isZip() {
        return isZip;
    }

    public static void setZip(boolean zip) {
        isZip = zip;
    }
}