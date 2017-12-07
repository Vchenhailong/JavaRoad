package utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * IO工具类
 *
 * @author hailongchen
 *         Date: 2017-11-09
 *         Time: 10:24
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomizeFileUtil {

    private String srcFileName;
    private String dstFileName;

    /**
     * 文本文件读写工具
     *
     */
    public void textIO() throws IOException {

        //以字符的方式操作
        Scanner in = new Scanner(new File(srcFileName), "utf-8");
        PrintWriter out = new PrintWriter(dstFileName);

        System.out.println("======开始写入...======");
        while (in.hasNextLine()) {
            String content = in.nextLine();
            out.print(content);
        }

        out.flush();  // 必须要有flush和close
        out.close();
        in.close();   // 先关出，再关进
        System.out.println("======完成写入======");

    }

    /**
     * 二进制文件读写工具
     *
     */
    public void streamIO() throws IOException {

        //定义输入流和输出流对象
        FileInputStream in = new FileInputStream(srcFileName);
        FileOutputStream out = new FileOutputStream(dstFileName);

        //判断文件对象的格式与权限
//        this.checkFileType(srcFile);

        //设定存储块空间(这种方式是最快的)
        byte[] bytes = new byte[5*1024];
        //每次以该大小bytes进行读写
        int b;
        Long start = System.currentTimeMillis();
        System.out.println("开始时间" + start);
        while ((b = in.read(bytes,0, bytes.length)) != -1){
            //完成输出执行，并返回结果
            out.write(bytes,0,b);
            out.flush();
        }
        Long end = System.currentTimeMillis();
        System.out.println("结束时间" + end);
        System.out.println("运行时间" + (end - start) + "ms");
        out.close();
        in.close();

    }

    public void bufferedIO() throws IOException {

        BufferedInputStream in = new BufferedInputStream(new FileInputStream(srcFileName));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(dstFileName));
        byte[] bytes = new byte[5*1024];
        int b;
        Long start = System.currentTimeMillis();
        System.out.println("start:" + start);
        while ((b =in.read(bytes,0,bytes.length)) !=-1){
            out.write(bytes,0,b);
            out.flush();
        }
        Long end = System.currentTimeMillis();
        System.out.println("end:" + end);
        Long during = end - start;
        System.out.println("运行时间" + during.toString() + "ms");

        out.close();
        in.close();
    }


    /**
     * 检查文件格式和权限。
     * 通过文件头信息（即实际确切的文件类型）和文件后缀综合判断。
     */
    public void checkFileType(String srcFileName) {

        //判断文件名后缀

            //进一步判断文件的真实格式

    }
}
