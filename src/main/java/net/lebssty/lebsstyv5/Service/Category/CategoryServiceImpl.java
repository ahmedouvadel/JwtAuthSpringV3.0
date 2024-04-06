package net.lebssty.lebsstyv5.Service.Category;

import lombok.RequiredArgsConstructor;
import net.lebssty.lebsstyv5.Dto.CategoryDto;
import net.lebssty.lebsstyv5.Entity.Category;
import net.lebssty.lebsstyv5.Repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;

    public Category createcategory(CategoryDto categoryDto){
        Category category = new Category();
        category.setName(categoryDto.getName());

        return categoryRepository.save(category);
    }
}