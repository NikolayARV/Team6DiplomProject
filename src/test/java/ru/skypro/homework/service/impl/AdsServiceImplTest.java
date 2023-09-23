package ru.skypro.homework.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.model.Ad;
import ru.skypro.homework.repository.AdRepository;
import ru.skypro.homework.repository.CommentRepository;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.ImageService;
import ru.skypro.homework.validation.PriceValidation;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AdsServiceImplTest {
    @Mock
    private AdRepository adRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private ImageService imageService;
    @Mock
    private CommentRepository commentRepository;
    @Mock
    private PriceValidation priceValidation;

    @InjectMocks
    AdsServiceImpl out;

    Ad ad = new Ad();
    Ad ad2 = new Ad();
    List<Ad> adList = new ArrayList<>();
    List<Ad> adList2 = new ArrayList<>();


    @Test
    void getAllAds() {
        when(adRepository.findAll()).thenReturn(adList);
        assertEquals(out.getAllAds(), new AdsDto().fromAdsList(adList));
        verify(adRepository, times(1)).findAll();

    }

    @Test
    void createAds() {

    }

    @Test
    void getAdById() {
    }

    @Test
    void getFullAdById() {
    }

    @Test
    void removeAd() {
    }

    @Test
    void updateAdById() {
    }

    @Test
    void getAllAdsForUser() {
    }

    @Test
    void updateImageById() {
    }
}