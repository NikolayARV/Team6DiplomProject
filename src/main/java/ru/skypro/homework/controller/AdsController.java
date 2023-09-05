package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.CreateOrUpdateAdDto;
import ru.skypro.homework.dto.CreateOrUpdateCommentDto;
import ru.skypro.homework.service.AdsService;

@Slf4j
@CrossOrigin(value = "http://localhost:3000")
@RestController
//@RequiredArgsConstructor
@RequestMapping("/ads")
public class AdsController {
    private final AdsService adsService;

    public AdsController(AdsService adsService) {
        this.adsService = adsService;
    }

    @GetMapping
    public ResponseEntity<?> ads() {
//запрос в сервис
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<?> createAd(@RequestBody CreateOrUpdateAdDto createOrUpdateAdDto, @RequestBody String image) {
        //запрос в сервис
        return ResponseEntity.ok().build();
    }
    @GetMapping("{id}")
    public ResponseEntity<?> adDto(@PathVariable Integer id) {

        return ResponseEntity.ok(adsService.getAdById(id));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteAd(@PathVariable Integer id) {
//запрос в сервис
        return ResponseEntity.ok().build();
    }
    @PatchMapping("{id}")
    public ResponseEntity<?> UpdateAd(@RequestBody CreateOrUpdateAdDto createOrUpdateAdDto, @PathVariable Integer id) {
//запрос в сервис
        return ResponseEntity.ok().build();
    }
    @GetMapping("/me")
    public ResponseEntity<?> myAds() {
//запрос в сервис
        return ResponseEntity.ok().build();
    }

    @PatchMapping("{id}/image")
    public ResponseEntity<?> UpdateImage(@RequestBody String image, @PathVariable Integer id) {
//запрос в сервис
        return ResponseEntity.ok().build();
    }
    /**
     * Контроллеры для комментариев
     */
    @GetMapping("{id}/comments")
    public ResponseEntity<?> comments(@PathVariable Integer id) {
//запрос в сервис
        return ResponseEntity.ok().build();
    }
    @PostMapping("{id}/comments")
    public ResponseEntity<?> createComment(@RequestBody CreateOrUpdateCommentDto createOrUpdateCommentDto, @PathVariable Integer id) {
        //запрос в сервис
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}/comments/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable Integer id, @PathVariable Integer commentId) {
//запрос в сервис
        return ResponseEntity.ok().build();
    }
    @PatchMapping("{id}/comments/{commentId}")
    public ResponseEntity<?> UpdateComment(@PathVariable Integer id,
                                           @PathVariable Integer commentId,
                                           @RequestBody CreateOrUpdateAdDto createOrUpdateAdDto) {
//запрос в сервис
        return ResponseEntity.ok().build();
    }

}
