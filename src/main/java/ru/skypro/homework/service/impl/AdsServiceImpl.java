package ru.skypro.homework.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.CreateOrUpdateAdDto;
import ru.skypro.homework.model.Ad;
import ru.skypro.homework.repository.AdRepository;
import ru.skypro.homework.service.AdsService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AdsServiceImpl implements AdsService {

    private AdRepository adRepository;

    public AdsServiceImpl(AdRepository adRepository) {
        this.adRepository = adRepository;
    }

    @Override
    public AdsDto getAllAds() {
        List<Ad> adList = adRepository.findAll();
        return new AdsDto().fromAdsList(adList);
    }

    @Override
    public AdDto createAds(CreateOrUpdateAdDto createOrUpdateAdDto) {
        Ad newAd = new Ad();
    }

    @Override
    public AdDto getAdById(Integer id) {
        Ad preResult = new Ad();
        List<Ad> adList = adRepository.findAll();
        for (Ad ad: adList) {
            if (Objects.equals(ad.getPk(), id)){
                preResult = ad;
            }
        }
        return AdDto.fromAd(preResult); //уточнить что будет, если не найдет
    }

    @Override
    public void removeAd(Integer id) {
        List<Ad> adList = adRepository.findAll();
        for (Ad ad: adList) {
            if (Objects.equals(ad.getPk(), id)){
                adRepository.deleteById(id);
            }
        }
    }

    @Override
    public AdDto updateAdById(Integer id, CreateOrUpdateAdDto createOrUpdateAdDto) {
        Ad oldAd = new Ad();
        List<Ad> adList = adRepository.findAll();
        for (Ad ad: adList) {
            if (Objects.equals(ad.getPk(), id)) {
                ad.setTitle(createOrUpdateAdDto.getTitle());
                ad.setPrice(createOrUpdateAdDto.getPrice());
                ad.setDescription(createOrUpdateAdDto.getDescription());
                oldAd = ad;
            }
        }
        return AdDto.fromAd(oldAd);
    }

    @Override
    public AdsDto getAllAdsForUser(String userName) {

    }
}
