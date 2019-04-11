package cn.yer.api;


import org.junit.Test;

import java.io.*;
import java.sql.Blob;
import java.sql.SQLException;

public class test {

    final String FILE_DIR = "D:/temp/";
    final String URL_DIR = "/wspdf/";

    @Test
    public void test1() {
        try {
            FileInputStream is = new FileInputStream(new File("D:/2 token服务接口V_1.9.pdf"));
            file1("AS1234567890", "888", "A125", is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public String getFilePath(String ajbh, String wsh, String wsbt, Blob blob) {
        String filePath = "";
        if (blob != null) {
            try {
                File file_dir = new File(FILE_DIR + File.separator + ajbh);
                if (!file_dir.exists()) {
                    file_dir.mkdirs();
                }
                File file = new File(FILE_DIR + File.separator + ajbh + File.separator + ajbh + "_" + wsh + "_" + wsbt + ".pdf");
                if (!file.exists()) {
                    InputStream is = null;
                    is = blob.getBinaryStream();
                    writeFile(is, file);
                }else{
                    System.out.println("文件存在，不用重复下载");
                }
                filePath = URL_DIR + ajbh + File.separator + File.separator + ajbh + "_" + wsh + "_" + wsbt + ".pdf";
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return filePath;
    }

    public void file1(String ajbh, String wsh, String wsbt, InputStream is) {
        try {
            File file_dir = new File(FILE_DIR + File.separator + ajbh);
            if (!file_dir.exists()) {
                file_dir.mkdirs();
            }
            File file = new File(FILE_DIR + File.separator + ajbh + File.separator + ajbh + "_" + wsh + "_" + wsbt + ".pdf");
            if (!file.exists()) {
//                InputStream is = null;


//                is = blob.getBinaryStream();


                writeFile(is, file);

            } else {
                System.out.println("文件存在，不用重复下载");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void writeFile(InputStream is, File file) {

        // 将输入流is写入文件输出流fos中
        int ch = 0;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            while ((ch = is.read()) != -1) {
                fos.write(ch);
            }
            fos.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
