package com.nextit.reactplus.services.strategy;

import com.flickr4java.flickr.FlickrException;
import com.nextit.reactplus.dto.UserDto;
import com.nextit.reactplus.exception.ErrorCodes;
import com.nextit.reactplus.exception.InvalidOperationException;
import com.nextit.reactplus.services.FlickrService;
import com.nextit.reactplus.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.InputStream;

@Service("userStrategy")
@Slf4j
public class SaveUserPhoto implements Strategy<UserDto> {

    private FlickrService flickrService;
    private UserService userService;

    @Autowired
    public SaveUserPhoto(FlickrService flickrService,
                         UserService userService) {
        this.flickrService = flickrService;
        this.userService = userService;
    }

    @Override
    public UserDto savePhoto(Integer id, InputStream photo, String titre) throws FlickrException {
        UserDto user = userService.findById(id);
        String urlPhoto = flickrService.savePhoto(photo, titre);
        if (!StringUtils.hasLength(urlPhoto)) {
            throw new InvalidOperationException("사용자 사진을 저장하는 중에 오류가 발생했습니다.", ErrorCodes.UPDATE_PHOTO_EXCEPTION);
        }
        user.setPhoto(urlPhoto);
        return userService.save(user);
    }
}