package com.diplomado.workorder.service.template.activity.image;

import com.diplomado.workorder.domain.template.activity.Image;
import com.diplomado.workorder.repository.template.activity.image.ImageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ImageService implements IImageService {
  
  private ImageRepository imageRepository;
  
  @Override
  public Image save(Image image) {
    return imageRepository.save(image);
  }
  
  @Override
  public List<Image> getAll() {
    return null;
  }
  
  @Override
  public Optional<Image> findById(UUID uuid) {
    return imageRepository.findById(uuid);
  }
  
  @Override
  public Image update(Image image) {
    return null;
  }
  
  public void delete(Image image) {
    imageRepository.delete(image);
  }
}
