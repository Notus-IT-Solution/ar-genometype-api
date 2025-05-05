package com.Notus_IT_Solution.AR_Genometype_API.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Notus_IT_Solution.AR_Genometype_API.entity.ImageFile;

@Repository
public interface ImageFileRepository extends JpaRepository<ImageFile, Long> {}