package pingan.com.cn.util;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.springframework.core.io.ClassPathResource;
import pingan.com.cn.bo.FastDFSFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FastDFSUtil {

    /**
     * 加载tracker链接信息
     */
    static{
        String filePath = new ClassPathResource("fdfs_client.conf").getPath();
        try {
            ClientGlobal.init(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String[] upload(FastDFSFile fastDFSFile) throws Exception{
        // 附加参数
        NameValuePair[] list = new NameValuePair[1];
        NameValuePair nameValuePair = new NameValuePair("作者","龍門");
        list[0] = nameValuePair;

        // 创建TrackerClient客户端对象
        TrackerClient trackerClient = new TrackerClient();
        // 通过trackerClient获取TrackerServer服务信息
        TrackerServer trackerServer = trackerClient.getConnection();
        // 获取StorageClient对象
        StorageClient storageClient = new StorageClient(trackerServer,null);
        // 上传文件
        String[] result = storageClient.upload_file(fastDFSFile.getContent(), fastDFSFile.getFileExtName(), list);
        return result ;
    }

    /**
     * 获取文件信息
     *  @param groupName       存储文件所在的组  例如：group1
     * @param remoteFileName  文件的储存路径；  例如：M00/00/00/rBLHx170BDqAQESzAACPlol6c38977.jpg
     * @return
     */
    public static  FileInfo getFile(String groupName, String remoteFileName ) throws Exception {
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageClient storageClient = new StorageClient(trackerServer, null);
        return storageClient.get_file_info(groupName,remoteFileName);
    }

    /**
     *
     * 下载文件
     *  @param groupName       存储文件所在的组  例如：group1
     * @param remoteFileName  文件的储存路径；  例如：M00/00/00/rBLHx170BDqAQESzAACPlol6c38977.jpg
     * @return InputStream
     * @throws Exception
     */
    public static InputStream downLoadFile(String groupName, String remoteFileName ) throws Exception {
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageClient storageClient = new StorageClient(trackerServer, null);
        byte[] buffer = storageClient.download_file(groupName, remoteFileName);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buffer);
        return byteArrayInputStream;
    }

    /**
     * 删除文件
     *  @param groupName       存储文件所在的组  例如：group1
     * @param remoteFileName  文件的储存路径；  例如：M00/00/00/rBLHx170BDqAQESzAACPlol6c38977.jpg
     * @throws Exception
     */
    public static void deleteFile(String groupName, String remoteFileName ) throws Exception {
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageClient storageClient = new StorageClient(trackerServer, null);
        storageClient.delete_file(groupName,remoteFileName);
    }


    public static StorageServer getStorages() throws Exception {
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        return trackerClient.getStoreStorage(trackerServer);

    }

    /**
     *
     * 获取文件的所在的storage信息
     * @param groupName       存储文件所在的组  例如：group1
     * @param remoteFileName  文件的储存路径；  例如：M00/00/00/rBLHx170BDqAQESzAACPlol6c38977.jpg
     * @return
     * @throws Exception
     */
    public static ServerInfo[] getServerInfo(String groupName, String remoteFileName ) throws Exception {
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        return trackerClient.getFetchStorages(trackerServer,groupName,remoteFileName);
    }

    public static String getTrackerInfo() throws Exception {
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        int port = ClientGlobal.getG_tracker_http_port();
        String host = trackerServer.getInetSocketAddress().getHostString();
        return "http://"+host+":"+port;
    }
    public static void main(String[] args) {

/*        try {
            // 获取文件信息
            FileInfo fileInfo = FastDFSUtil.getFile("group1","M00/00/00/rBLHx170BDqAQESzAACPlol6c38977.jpg");
            System.out.println("获取到文件信息0："+fileInfo.getSourceIpAddr());
            System.out.println("获取到文件信息1："+fileInfo.getCreateTimestamp());
        } catch (Exception e) {
            e.printStackTrace();
        }*/

/*        try {
            // 文件下载
            InputStream inputStream = FastDFSUtil.downLoadFile("group1","M00/00/00/rBLHx170BDqAQESzAACPlol6c38977.jpg");
            // 定义缓存区
            byte[] buffer = new byte[1024];
            FileOutputStream fileOutputStream = new FileOutputStream("d:/xujian.jpg");
            while(inputStream.read(buffer)!=-1){
                fileOutputStream.write(buffer);
            }
            fileOutputStream.flush();
            inputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }*/


    /*    try {
            // 文件删除
            FastDFSUtil.deleteFile("group1","M00/00/00/rBLHx170BDqAQESzAACPlol6c38977.jpg");
        } catch (Exception e) {
            e.printStackTrace();
        }*/

/*
        try {
            StorageServer storageServer = FastDFSUtil.getStorages();
            System.out.println("store 组    :"+storageServer.getStorePathIndex());
            System.out.println("store 服务IP:"+storageServer.getInetSocketAddress().getHostName());
        } catch (Exception e) {
            e.printStackTrace();
        }
*/
   /*     try {
            // http://120.76.135.172:8080/group1/M00/00/00/rBLHx170Nk2AW-ocAAB3t1r0iX4674.jpg
            ServerInfo[] list = FastDFSUtil.getServerInfo("group1","/M00/00/00/rBLHx170Nk2AW-ocAAB3t1r0iX4674.jpg");
            for (ServerInfo serverInfo : list){
                System.out.println(serverInfo.getIpAddr());
                System.out.println(serverInfo.getIpAddr());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        try {
            System.out.println(FastDFSUtil.getTrackerInfo());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
