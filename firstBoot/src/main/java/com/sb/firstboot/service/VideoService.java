package com.sb.firstboot.service;

import com.sb.firstboot.domain.Video;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface VideoService {
    Video getVideo(String name);

    void saveVideo(MultipartFile file, String name) throws IOException;

    List<String> getAllVideoNames();
}
