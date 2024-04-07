package net.lebssty.lebsstyv5.Controller;

import lombok.RequiredArgsConstructor;
import net.lebssty.lebsstyv5.Dto.CategoryDto;
import net.lebssty.lebsstyv5.Entity.Category;
import net.lebssty.lebsstyv5.Service.Category.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/admin")
@CrossOrigin("*")
public class AdminCategoryController {

    private final CategoryService categoryService;
    @PostMapping("Category")
    public ResponseEntity<Category> createCategory(@RequestBody CategoryDto categoryDto){
        Category category = categoryService.createcategory(categoryDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }
}