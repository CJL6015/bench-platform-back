package seu.powersis.alert.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seu.powersis.alert.common.model.Result;
import seu.powersis.alert.param.SelectQuery;
import seu.powersis.alert.service.ExaService;
import seu.powersis.alert.service.SelectService;
import seu.powersis.alert.vo.OptionItemVO;
import seu.powersis.alert.vo.PointOptionItemVO;
import seu.powersis.alert.vo.SelectAllOptionVO;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenjiale
 * @version 1.0
 * @date 2023-08-16 22:37
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/select")
public class SelectController {
    /**
     * 查询条件不能含有这个,否则exa会挂掉
     */
    private static final String EXA_NOT_SUPPORT_STR = "'";
    private final SelectService selectService;

    private final ExaService exaService;

    @GetMapping("list")
    public Result<SelectAllOptionVO> getAllOptions() {
        SelectAllOptionVO allOptions = selectService.getAllOptions();
        return Result.success(allOptions);
    }

    @GetMapping("/system/options")
    public Result<List<OptionItemVO>> getTypeOptions(@Valid SelectQuery query) {
        List<OptionItemVO> systemOptions = selectService.getSystemOptions(query);
        return Result.success(systemOptions);
    }

    @GetMapping("/point/options")
    public Result<List<PointOptionItemVO>> getPointOptions(String keyword) {
        List<PointOptionItemVO> pointOptionList = new ArrayList<>();
        if (StringUtils.hasText(keyword) && !keyword.contains(EXA_NOT_SUPPORT_STR)) {
            pointOptionList = exaService.getPointOptionList(keyword);
        }
        return Result.success(pointOptionList);
    }
}
