package ru.skypro.homework.service.impl;

import org.hamcrest.core.AnyOf;
import org.hibernate.mapping.Any;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.model.Image;
import ru.skypro.homework.repository.ImageRepository;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.InstanceOfAssertFactories.type;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ImageServiceImplTest {
    @Mock
    private ImageRepository imageRepository;
    @InjectMocks
    private ImageServiceImpl out;



    Image image = new Image("jpeg", new byte[1]);

    MultipartFile file = new MockMultipartFile("qwer",
            "foto", "jpeg", new byte[1]);


    @Test
    void uploadImage() {


    }

    @Test
    void getImage() {
        when(imageRepository.getReferenceById(image.getId())).thenReturn(image);
        assertEquals(out.getImage(image.getId()), image.getImage());
        verify(imageRepository, times(1)).getReferenceById(image.getId());
    }

    @Test
    void deleteImage() {
        out.deleteImage(image.getId());
        verify(imageRepository, times(1)).deleteById(image.getId());
    }

    private String typeImage(MultipartFile image) {

        String type = image.getContentType();
        assert type != null;
        type = type.replace("image/", ".");

        return type;
    }
}