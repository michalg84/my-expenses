package pl.sda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.model.Category;
import pl.sda.model.User;
import pl.sda.repository.CategoryRepository;
import pl.sda.repository.UserRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Michał Gałka on 2017-05-22.
 */
@Service
public class CategoryService {
    @Autowired
    private MessageService messageService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryRepository categoryRepository;


    /**
     * Adds new category to Users Categories
     * @param category
     */
    public void add(Category category){
        User user = userService.getAcctualUser();
        //TODO: remove duplicates
        category.setName(category.getName().toUpperCase());
        category.setUser(user);
        categoryRepository.save(category);
        messageService.addSuccessMessage("Categoty " + category.getName() + " succesfuly added.");
    }

    /**
     * Creates base group of categories.
     * @return
     */
    public List<Category> initialCategories(User user) {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("FOOD"));
        categories.add(new Category("CAR"));
        categories.add(new Category("ENTERTAIMENT"));
        categories.add(new Category("SPORT"));
        categories.add(new Category("GIFTS"));
        categories.add(new Category("RENT"));
        categories.add(new Category("TAXES"));
        categories.add(new Category("BILLS"));
        categories.add(new Category("SALARY"));
        categories.forEach((c)-> c.setUser(user));
        return sort(categories);
    }

    /**
     * Sorts categories by name.
     * @param categories
     * @return sorted categories.
     */
    private List<Category> sort(List<Category> categories) {
        return categories.stream()
                .sorted(Comparator.comparing(Category::getName))
                .collect(Collectors.toList());
    }


    public List<Category> getCategories() {
        return categoryRepository.findAll(userService.getAcctualUser());
    }
}
