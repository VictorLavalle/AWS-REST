package com.aws.rest.repository;

import org.springframework.web.multipart.MultipartFile;

public interface S3Repository {
    void uploadFile(long id, MultipartFile file);
    String getLinkFromS3 (long id, String fileName);
}
