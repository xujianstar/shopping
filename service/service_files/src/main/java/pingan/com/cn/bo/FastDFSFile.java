package pingan.com.cn.bo;

import java.io.Serializable;
import java.io.StringReader;

public class FastDFSFile implements Serializable {

    // 文件名
    private String fileName;
    // 文件内容
    private byte[] content ;
    // 文件扩展名
    private String fileExtName;
    // 作者
    private String authorName ;
    //文件MD5摘要值
    private String md5;

    public FastDFSFile(String fileName, byte[] content, String fileExtName, String authorName,String md5){
        this.fileName   = fileName;
        this.content    = content;
        this.fileName   = fileName;
        this.authorName = authorName;
        this.fileExtName = fileExtName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getFileExtName() {
        return fileExtName;
    }

    public void setFileExtName(String fileExtName) {
        this.fileExtName = fileExtName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
