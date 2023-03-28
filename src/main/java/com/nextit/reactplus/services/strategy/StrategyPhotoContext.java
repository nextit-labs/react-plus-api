package com.nextit.reactplus.services.strategy;

import com.nextit.reactplus.exception.ErrorCodes;
import com.nextit.reactplus.exception.InvalidOperationException;
import com.flickr4java.flickr.FlickrException;
import java.io.InputStream;
import lombok.Setter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StrategyPhotoContext {

    private BeanFactory beanFactory;
    private Strategy strategy;
    @Setter
    private String context;

    @Autowired
    public StrategyPhotoContext(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public Object savePhoto(String context, Integer id, InputStream photo, String title) throws FlickrException {
        determinContext(context);
        return strategy.savePhoto(id, photo, title);
    }

    private void determinContext(String context) {
        final String beanName = context + "Strategy";
        switch (context) {
            /*
            case "article":
                strategy = beanFactory.getBean(beanName, SaveArticlePhoto.class);
                break;
            case "client" :
                strategy = beanFactory.getBean(beanName, SaveClientPhoto.class);
                break;
            case "fournisseur" :
                strategy = beanFactory.getBean(beanName, SaveFournisseurPhoto.class);
                break;
            case "entreprise" :
                strategy = beanFactory.getBean(beanName, SaveEntreprisePhoto.class);
                break;
                */
            case "user" :
                strategy = beanFactory.getBean(beanName, SaveUserPhoto.class);
                break;
            default: throw new InvalidOperationException("사진 저장을 위한 알 수 없는 배경", ErrorCodes.UNKNOWN_CONTEXT);
        }
    }


}