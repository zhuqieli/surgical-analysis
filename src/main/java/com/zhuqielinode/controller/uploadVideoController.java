package com.zhuqielinode.controller;
import java.io.File;
import java.util.*;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

//接口：前端视频上传
@RestController
//一级地址
@RequestMapping("/api")
@Controller
public class uploadVideoController {
    //SavePath(地址路径，也是用来后端保存在服务器哪个文件夹的地址)
    String SavePath="D:\\html";
    //@Resource
    //VideoUploadMapper videoUploadMapper;
    //解决跨域的注解
    @CrossOrigin(origins = "*", maxAge = 3600)
    //二级地址
    @PostMapping(value = "/uploadVideo3")
    @ResponseBody
    //Map<String,String>: map是键值对形式组成的集合，类似前端的数组但是里面是键值对形式的，前后两个string代表键和值都是字符串格式的。
    //post请求传入的参数：MultipartFile file(理解为springmvc框架给我们提供的工具类，代表视频流数据)，arithmetic前端传回的算法选择，以数组形式呈现
    public String savaVideoTest(@RequestParam("file") MultipartFile file,@RequestParam("arithmetic") String arithmetic  )
    //throws IllegalStateException写在方法的前面是可以抛出异常状态的，如果有错误会把错误信息发出来对应下面的try和catch
            throws IllegalStateException {
        //输出文件的路径
        String outResult="";
        try{
            //获取文件后缀，因此此后端代码可接收一切文件，上传格式前端限定
            String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
            // 重构文件名称
            System.out.println("保存路径："+SavePath);
            //UUID(全局唯一标识符)randomUUID(随机生成标识符)toString(转成字符串)replaceAll(替换字符方法，因为随机生成的里面包括了 - ，这里意思是把 - 全部换成空)
            String pikId = UUID.randomUUID().toString().replaceAll("-", "");
            //视频名字拼接：唯一标识符加上点，再加上上面的视频后缀也就是MP4之类的。就组成了现在的视频名字，比如这样：c7bbc1f9664947a287d35dd7cdc48a95.mp4
            String newVideoName = pikId + "." + fileExt;
            System.out.println("重构文件名防止上传同名文件："+newVideoName);
            //保存视频的原始名字
            String videoNameText = file.getOriginalFilename();
            System.out.println("视频原名:"+videoNameText);
            //保存视频url路径地址
            String videoUrl = SavePath + "\\" + newVideoName;
            //调用数据库接口插入数据库方法save，把视频原名，视频路径，视频的唯一标识码传进去存到数据库内（还未搭建数据库，暂存操作）
            //videoUploadMapper.save(videoNameText,videoUrl,newVideoName);
            //判断SavePath这个路径也就是需要保存视频的文件夹是否存在
            File filepath = new File(SavePath, file.getOriginalFilename());
            if (!filepath.getParentFile().exists()) {
                //如果不存在，就创建一个这个路径的文件夹。
                filepath.getParentFile().mkdirs();
            }
            //保存视频：把视频按照前端传来的地址保存进去，还有视频的名字用唯一标识符显示，需要其他的名字可改这
            File fileSave = new File(SavePath, newVideoName);
            //下载视频到文件夹中
            file.transferTo(fileSave);
            //构造Map将视频信息返回给前端
            //视频名称重构后的名称：这里put代表添加进map集合内，和前端的push一样。括号内是前面字符串是键，后面是值
            outResult = callDjango(videoUrl, arithmetic);
            //请求django进行分析，传入视频地址与选择的算法
            return  outResult;

        }catch (Exception e){
            //在命令行打印异常信息在程序中出错的位置及原因
            e.printStackTrace();
            //返回有关异常的详细描述性消息。
            e.getMessage();
            return  "error" ;
        }
    }
    public String callDjango(String videoUrl,String arithmetic){
        String outResult="";
        Map<String, Object> params = new HashMap<>();
        params.put("videourl",videoUrl);
        params.put("arithmetic",arithmetic);
        TestRestTemplate restTemplate=new TestRestTemplate();
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://127.0.0.1:8000/SurgicalAnalysis/arithmetic?videourl={videourl}&arithmetic={arithmetic}", String.class, params);
        return forEntity.toString();
    }


}

