package ru.skypro.homework.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.AdsDto;
import ru.skypro.homework.dto.CreateOrUpdateAdDto;
import ru.skypro.homework.dto.Role;
import ru.skypro.homework.model.Ad;
import ru.skypro.homework.model.User;
import ru.skypro.homework.repository.AdRepository;
import ru.skypro.homework.repository.AuthoritiesRepository;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.service.AdsService;
import ru.skypro.homework.service.ImageService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AdsServiceImpl implements AdsService {

    private AdRepository adRepository;
    private final UserRepository userRepository;
    private final ImageService imageService;
    private final AuthoritiesRepository authoritiesRepository;

    public AdsServiceImpl(AdRepository adRepository, UserRepository userRepository, ImageService imageService, AuthoritiesRepository authoritiesRepository) {
        this.adRepository = adRepository;
        this.userRepository = userRepository;
        this.imageService = imageService;
        this.authoritiesRepository = authoritiesRepository;
    }

    @Override
    public AdsDto getAllAds() {
        List<Ad> adList = adRepository.findAll();
        return new AdsDto().fromAdsList(adList);
    }

    @Override
    public AdDto createAds(CreateOrUpdateAdDto createOrUpdateAdDto, MultipartFile image) {
        Ad newAd = new Ad();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        newAd.setTitle(createOrUpdateAdDto.getTitle());
        newAd.setPrice(createOrUpdateAdDto.getPrice());
        newAd.setDescription(createOrUpdateAdDto.getDescription());
        newAd.setUser(userRepository.findUserByUsername(username).orElseThrow(NoSuchElementException::new));
        newAd.setImage(imageService.uploadImage(image));

        adRepository.save(newAd);
        return AdDto.fromAd(newAd);
    }

    @Override
    public AdDto getAdById(Integer id) {

        return AdDto.fromAd(adRepository.findByPk(id));
    }

    @Override
    public void removeAd(Integer id, String username) {
        User user = userRepository.findUserByUsername(username).orElseThrow(NoSuchElementException::new);
        Ad ad = adRepository.findByPk(id);
        Role role = authoritiesRepository.findByUsername(username).getRole();
        if (user.equals(ad.getUser()) || role.equals(Role.ADMIN)) {
            adRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }

    }

    @Override
    public AdDto updateAdById(Integer id, CreateOrUpdateAdDto createOrUpdateAdDto, String username) {
        User user = userRepository.findUserByUsername(username).orElseThrow(NoSuchElementException::new);
        Ad oldAd = adRepository.findByPk(id);
        Role role = authoritiesRepository.findByUsername(username).getRole();
        if (user.equals(oldAd.getUser()) || role.equals(Role.ADMIN)) {
            oldAd.setTitle(createOrUpdateAdDto.getTitle());
            oldAd.setPrice(createOrUpdateAdDto.getPrice());
            oldAd.setDescription(createOrUpdateAdDto.getDescription());
            oldAd.setUser(oldAd.getUser());
            adRepository.save(oldAd);
        }
        return AdDto.fromAd(oldAd);
    }
    @Override
    public AdsDto getAllAdsForUser(String userName) {
        List<Ad> userAdList = adRepository.findAdsByUser_UsernameContains(userName);
        return new AdsDto().fromAdsList(userAdList);
    }

    @Override
    public boolean updateImageById(Integer id, MultipartFile image) {
        Ad oldAd = adRepository.findByPk(id);
        String imageId = imageService.uploadImage(image);
        oldAd.setImage(imageId);
        adRepository.save(oldAd);
        return true;
    }
}
