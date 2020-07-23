package pingan.com.cn.controller;


import entity.Result;
import entity.StatusCode;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pingan.com.cn.bo.FastDFSFile;
import pingan.com.cn.util.FastDFSUtil;

@RestController
@RequestMapping(value = "/upload")
@CrossOrigin
public class FileController {

    @PostMapping
    public Result fileUp(@RequestParam(value = "file") MultipartFile file) throws Exception {
        FastDFSFile fastDFSFile = new FastDFSFile(
                file.getOriginalFilename(),
                file.getBytes(),
                StringUtils.getFilenameExtension(file.getOriginalFilename()),
                "黑马", null);
        System.out.println("Hello ,file up");
        String[] result = FastDFSUtil.upload(fastDFSFile);
//        String path = "http://120.76.135.172:8080/"+result[0]+"/"+result[1];
        String path = FastDFSUtil.getTrackerInfo()+"/"+result[0]+"/"+result[1];
        System.out.println("ok");
        return new Result(true, StatusCode.OK, "文件上传成功:"+path);
    }
}
