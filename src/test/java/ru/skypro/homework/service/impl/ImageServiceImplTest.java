package ru.skypro.homework.service.impl;

import org.hamcrest.core.AnyOf;
import org.hibernate.mapping.Any;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.model.Image;
import ru.skypro.homework.repository.ImageRepository;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ImageServiceImplTest {
    @Mock
    private ImageRepository imageRepository;
    @InjectMocks
    private ImageServiceImpl out;


        Image image = new Image(UUID.randomUUID()+"jpeg",new byte[1] );

        MultipartFile file = new MockMultipartFile("qwer", "foto", "jpeg", new byte[1]);




    @Test
    void uploadImage() {
        //when(imageRepository.save(image)).thenReturn(true);

        //assertNotEquals(out.uploadImage(file), image.getId());

    }

    @Test
    void getImage() {
    }

    @Test
    void deleteImage() {
    }
}