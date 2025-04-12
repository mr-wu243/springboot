package com.aliyun.oss;

import com.aliyun.oss.common.auth.CredentialsProviderFactory;
import com.aliyun.oss.common.auth.EnvironmentVariableCredentialsProvider;
import com.aliyuncs.exceptions.ClientException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * 阿里云 OSS 工具类
 */


@Slf4j
public class AliOSSUtils {
    private AliOssProperties aliOssProperties;

    public AliOssProperties getAliOssProperties() {
        return aliOssProperties;
    }

    public void setAliOssProperties(AliOssProperties aliOssProperties) {
        log.info("1");
        this.aliOssProperties = aliOssProperties;
        System.out.println(aliOssProperties);
    }

    private String endpoint = aliOssProperties.getEndpoint();
    private String bucketName = aliOssProperties.getBucketName();
    private String region = aliOssProperties.getRegion();

    /**
     * 实现上传图片到OSS
     */
    public String upload(MultipartFile file) throws IOException, ClientException {
        // 获取上传的文件的输入流
        InputStream inputStream = file.getInputStream();

        // 避免文件覆盖
        String originalFilename = file.getOriginalFilename();
        String fileName = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));
        EnvironmentVariableCredentialsProvider credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();
        ClientBuilderConfiguration clientBuilderConfiguration = new ClientBuilderConfiguration();
        //上传文件到 OSS
        OSS ossClient = OSSClientBuilder.create()
                .endpoint(endpoint)
                .credentialsProvider(credentialsProvider)
                .clientConfiguration(clientBuilderConfiguration)
                .region(region)
                .build();
        ossClient.putObject(bucketName, fileName, inputStream);

        //文件访问路径
        String url = endpoint.split("//")[0] + "//" + bucketName + "." + endpoint.split("//")[1] + "/" + fileName;
        // 关闭ossClient
        ossClient.shutdown();
        return url;// 把上传到oss的路径返回
    }

}
