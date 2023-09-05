package ru.skypro.homework.service;

import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.CreateOrUpdateAdDto;
import ru.skypro.homework.model.Ad;

public interface AdsService { // одного метода не хватает - дописать
    AdsDto getAllAds();
    AdDto createAds(CreateOrUpdateAdDto createOrUpdateAdDto);
    AdDto getAdById(Integer id);
    void removeAd(Integer id);
    AdDto updateAdById (Integer id, CreateOrUpdateAdDto createOrUpdateAdDto);
    AdsDto getAllAdsForUser(String userName);

}
