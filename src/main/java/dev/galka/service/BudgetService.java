package dev.galka.service;

import dev.galka.dto.BudgetDto;
import dev.galka.dto.MonthBudgetDto;

import java.util.List;

public interface BudgetService {

    List<BudgetDto> getBudgetDtoList(Integer year, Integer month);

    void add(MonthBudgetDto monthBudgetDto);

}
