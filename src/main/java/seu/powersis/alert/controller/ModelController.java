package seu.powersis.alert.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import seu.powersis.alert.common.model.Result;
import seu.powersis.alert.param.CreateModelInfo;
import seu.powersis.alert.param.ModelSelectQuery;
import seu.powersis.alert.service.ModelService;
import seu.powersis.alert.vo.ModelInfoVO;
import seu.powersis.alert.vo.ModelSimpleVO;

import java.util.List;
import java.util.Objects;

/**
 * @author chenjiale
 * @version 1.0
 * @date 2023-08-19 13:07
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/model")
public class ModelController {
    private final ModelService modelService;


    @GetMapping("/card/list")
    public Result<List<ModelSimpleVO>> getModelList(ModelSelectQuery query) {
        List<ModelSimpleVO> modelList = modelService.getModelList(query);
        return Result.success(modelList);
    }

    @GetMapping("info/{id}")
    public Result<ModelInfoVO> getModelInfo(@PathVariable Integer id) {
        ModelInfoVO modelInfo = modelService.getModelInfo(id);
        return Result.success(modelInfo);
    }

    @PostMapping("/")
    public Result<Integer> saveModel(@RequestBody CreateModelInfo model) {
        Integer id = modelService.createModel(model);
        if (Objects.nonNull(id) && id > 0) {
        return Result.success(id);
        }
        return Result.fail("新建模型异常");
    }
}
