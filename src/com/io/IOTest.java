package com.io;

import java.io.*;

public class IOTest {
    public static void main(String[] args){
        String path = "D:\\kingdee\\Client";
        //FileTest("D:\\study\\halo\\halo-1.3.2.jar");
        //FileList(new File(path),0);
        //ByteStream(new File("D:\\kingdee\\demo.md"));
        CharacterStream(new File("D:\\kingdee\\demo.md"));
    }
    public static void FileTest(String path){
        File file = new File(path);
        System.out.println("文件或目录是否存在:" +  file.exists());
        System.out.println("是文件吗:" +  file.isFile());
        System.out.println("是目录吗:" +  file.isDirectory());
        System.out.println("名称:" +  file .getName());
        System.out.println("路径: " + file.getPath());
        System.out.println("绝对路径: " + file.getAbsolutePath());
        System.out.println("最后修改时间:" + file.lastModified());
        System.out.println("文件大小:" + file.length()+"字节");
        System.out.println("最后修改时间:" + file.lastModified());
        System.out.println("文件是否隐藏:" + file.isHidden());
        System.out.println("得到父目录:" + file.getParentFile());
        System.out.println("是否可读:" + file.canRead());
        System.out.println("是否可写:" + file.canWrite());
    }
    /**
     * 常用函数
     * public boolean createNewFile() //不存在时创建此文件对象所代表的空文件
     *
     * public boolean delete()　//删除文件。如果是目录必须是空才能删除
     *
     * public boolean deleteOnExit()　//删除文件。的虚拟机退出时删除
     *
     * public boolean mkdir() 　//创建此抽象路径名指定的目录
     *
     * public boolean mkdirs()　//创建此抽象路径名指定的目录，包括所有必需但不存在的父目录
     *
     * public booleanrenameTo(File dest)    //重新命名此抽象路径名表示的文件
     *
     * 浏览目录中的文件和子目录
     *
     * public String[] list()    //返回此目录中的文件名和目录名的数组
     *
     * public File[] listFiles()     //返回此目录中的文件和目录的File实例数组
     *
     * public File[]listFiles(FilenameFilter filter)//返回此目录中满足指定过滤器的文件和目录
     *
     * java.io.FilenameFilter接口：实现此接口的类实例可用于过滤文件名
     */
    /**
     * 文件夹目录打印
     * @param file
     * @param level
     */
    public static void FileList(File file,int level){
        File[] flist = file.listFiles();
        StringBuffer str = new StringBuffer();
        for(int l = 0;l<level;l++){
            str.append("-");
        }
        int length = flist==null?0:flist.length;
        for(int i = 0;i<=length-1;i++){
            if(flist[i].isDirectory()){
                System.out.println(str+flist[i].getName());
                FileList(flist[i],level+1);
            }else{
                System.out.println(str+flist[i].getName());
            }
        }
    }

    /**
     * 字节流
     * @param file
     */
    public static void ByteStream(File file){
        //写入文件，输出流
        OutputStream out = null;
        try {
            out = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        byte[] b = "你好".getBytes();
        try {
            out.write(b);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //读取文件，输入流
        InputStream in = null;
        byte[] b1 = new byte[1024];
        int i = 0;
        try {
            in = new FileInputStream(file);
            i = in.read(b1);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(new String(b1,0,i));
    }

    /**
     * 字符流
     * @param file
     */
    public static void CharacterStream(File file){
        Writer writer = null;
        try {
            writer = new FileWriter(file,true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String a = "-ruanshaokang";
        try {
            writer.write(a);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Reader reader = null;
        int i = 0;
        char[] c = new char[123];
        try {
            reader = new FileReader(file);
            i = reader.read(c);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(new String(c,0,i));
    }

}
