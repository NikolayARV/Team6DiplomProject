package ru.skypro.homework.service;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.CreateOrUpdateAdDto;
import ru.skypro.homework.model.Ad;

public interface AdsService {
    AdsDto getAllAds();
    AdDto createAds(CreateOrUpdateAdDto createOrUpdateAdDto, MultipartFile image);
    AdDto getAdById(Integer id);
    void removeAd(Integer id,  String username);
    AdDto updateAdById (Integer id, CreateOrUpdateAdDto createOrUpdateAdDto, String username);
    AdsDto getAllAdsForUser(String userName);
    boolean updateImageById (Integer id, MultipartFile image);
}
