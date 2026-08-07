package com.fooddelivery.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fooddelivery.Dto.menuDto;
import com.fooddelivery.entity.menuEntity;
import com.fooddelivery.entity.restaurantEntity;
import com.fooddelivery.mapper.menuMapper;
import com.fooddelivery.repo.menuRepo;
import com.fooddelivery.repo.restaurantRepo;

@Service
public class menuServiceImpl implements menuServiceInterface {

    @Autowired
    private menuRepo Menurepo;

    @Autowired
    private restaurantRepo repo;

    @Override
    public String addMenuItem(menuDto dto) {
        restaurantEntity entity = repo.findById(dto.getRestaurantId()).orElseThrow();
        menuEntity enti = menuMapper.toMenuEntity(dto, entity);
        Menurepo.save(enti);
        return "Item is successfully added inside the menu of a restaurant! Thanks!";
    }

    @Override
    public List<menuDto> getMenuByRestaurantId(Long restaurantId) {
        List<menuDto> menuDtoList = new ArrayList<>();
        List<menuEntity> menuEntities = Menurepo.findByRestaurantRestaurantId(restaurantId);

        for (menuEntity entity : menuEntities) {
            menuDto dto = menuMapper.convertToDto(new menuDto(), entity);
            menuDtoList.add(dto);
        }

        return menuDtoList;
    }

    @Override
    public boolean deleteItem(Long restaurantId, Long itemId) {
        Optional<menuEntity> itemOpt = Menurepo.findByItemIdAndRestaurantRestaurantId(itemId, restaurantId);
        if (itemOpt.isPresent()) {
            Menurepo.deleteById(itemId);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateItem(Long restaurantId , Long itemId, menuDto dto) {
        menuEntity entity = Menurepo.findById(itemId).orElse(null);

        if (entity != null) {
            entity.setItemName(dto.getItemName());
            entity.setItemDescription(dto.getItemDescription());
            entity.setItemPrice(dto.getItemPrice());

            Menurepo.save(entity);
            return true;
        } else {
            return false;
        }
    }
}