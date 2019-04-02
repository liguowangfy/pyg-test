package cn.itcast.fastdfs;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;

public class FastdfsTest {
    /*上传文件*/
    @Test
    public void upload_file() throws  Exception{
        /**加载配置文件，产生该文件的绝对路径*/
        String cof_filename =this.getClass().getResource("/fastdfs_client.conf").getPath();
        /**初始化客户端全局的对象*/
        ClientGlobal.init(cof_filename);
         /**创建存储客户端全局的对象*/
        StorageClient storageClient=new StorageClient();
        /**上传文件*/
        String[] arr=storageClient.upload_file("C:\\Users\\Administrator\\Pictures\\Camera Roll\\12.jpg","jpg",null);
    /*访问路径
    * http://192.168.12.131/group1/M00/00/01/wKgMg1yi2IeAX8AvAA0yxVNGuKA469.jpg
    * [group1, M00/00/01/wKgMg1yi2IeAX8AvAA0yxVNGuKA469.jpg]
    * */
        System.out.println(Arrays.toString(arr));
    }
    /*下载文件*/
    @Test
    public void download_file() throws Exception {
        /*加载配置文件，产生绝对路径*/
        String conf_filename = this.getClass()
                .getResource("/fastdfs_client.conf").getPath();
        /*初始化客户端全局的对象*/
        ClientGlobal.init(conf_filename);
        /*创建储存客户端对象*/
        StorageClient storageClient=new StorageClient();
        /**下载文件*/
        byte[] data = storageClient.download_file("group1", "M00/00/01/wKgMg1yi2IeAX8AvAA0yxVNGuKA469.jpg");
        System.out.println(data.length);
        FileOutputStream fos=new FileOutputStream(new File("E:\\pyg-test\\fastdfs-test\\src\\test\\resources\\8.jpg"));
        fos.write(data);
        fos.flush();
        fos.close();
    }
    /*删除文件*/
    @Test
    public void delete_file() throws Exception{
        /**加载配置文件，产生绝对路径*/
        String conf_filename=this.getClass().getResource("/fastdfs_client.conf").getPath();
        /*初始化客户端全局的对象*/
        ClientGlobal.init(conf_filename);
        /*创建存储客户对象*/
        StorageClient storageClient=new StorageClient();
        /**删除文件*/
        int res = storageClient.delete_file("group1", "M00/00/01/wKgMg1yi2IeAX8AvAA0yxVNGuKA469.jpg");
        System.out.println(res);
    }
}
