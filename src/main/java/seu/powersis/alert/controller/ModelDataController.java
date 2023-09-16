package seu.powersis.alert.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import seu.powersis.alert.common.model.Result;
import seu.powersis.alert.dao.entity.RecalcCfg;
import seu.powersis.alert.dao.service.RecalcCfgService;
import seu.powersis.alert.param.ModelDataQuery;
import seu.powersis.alert.param.TimeRange;
import seu.powersis.alert.service.ModelDataService;
import seu.powersis.alert.vo.ModelDataVO;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chenjiale
 * @version 1.0
 * @date 2023-09-05 22:08
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/model/data")
public class ModelDataController {
    private final ModelDataService modelDataService;

    private final RecalcCfgService recalcCfgService;

    @GetMapping("/{id}")
    public Result<ModelDataVO> getModelData(@PathVariable Integer id, @Valid ModelDataQuery query) {
        List<Integer> indexList = Arrays.stream(query.getIndex().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        ModelDataVO modelData = modelDataService.getModelData(id, query.getType(), indexList,
                query.getSt(), query.getEt());
        return Result.success(modelData);
    }

    @PostMapping("/calculate/{id}")
    public Result<Boolean> calculate(@PathVariable Integer id, @RequestBody TimeRange timeRange) {
        RecalcCfg recalcCfg = new RecalcCfg();
        recalcCfg.setModelId(id);
        recalcCfg.setInserttime(new Date());
        recalcCfg.setStarttime(timeRange.getSt());
        recalcCfg.setEndtime(timeRange.getEt());
        boolean save = recalcCfgService.save(recalcCfg);
        return Result.success(save);
    }
}
