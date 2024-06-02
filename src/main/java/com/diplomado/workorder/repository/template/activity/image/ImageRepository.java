package com.diplomado.workorder.repository.template.activity.image;

import com.diplomado.workorder.domain.template.activity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ImageRepository extends JpaRepository<Image, UUID> {
}
