package com.example.service;

import com.example.entity.Files;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface FilesService {
    void save(Files userFiles);

    List<Files> findFiles(int userId);

    Files findById(int id);

    void updateDownloadCounts(Files files);

    void deleteById(int id);
}
